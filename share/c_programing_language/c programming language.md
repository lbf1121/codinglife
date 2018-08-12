#The C Programming Language 2E
##第一章 导言
###1.1 入门
```c
#include <stdio.h>
int main(){
    printf("hello,world\n");
    return 0;
}
```
###1.2 变量和算数表达式
使用公式<sup>。</sup>C = （5/9）*（<sup>。</sup>F-32），
打印华氏温度与摄氏温度对照表。
```
#include <stdio.h>
main(){
    int fahr,celsius;
    int lower,upper,step;
    lower = 0;
    uppwer = 300;
    step = 20;
    
    fahr = lower;
    while(fahr <= upper){
        celsius = 5 * (fahr - 32) / 9;
        printf("%d\t%d\n",fahr,celsius);
        fahr = fahr + step;
    }
}
```
* printf函数永远不会自动换行
* printf函数的第一个参数中的各个%分别第一个、第二个参数，它们在数目和类型上必须匹配。
```
%d       :按照十进制整型数打印
%6d      :按照十进制整型数打印,至少6个字符宽
%f       :按照浮点数打印
%6f      :按照浮点数打印,至少6个字符宽  
%.2f     :按照浮点数打印,保留2位小数
%6.2f    :按照浮点数打印,至少6个字符宽,保留2位小数
```
###1.3 for语句
```
#include <stdio.h>
main(){
    int fahr;
    for(fahr = 0;fahr <= 300;fahr = fahr + 20){
        printf("%3d %6.1f\n",fahr,(5.0/9.0)*(fahr-32));
    }
}
```
###1.4 符号常量
\#define指令可以把符号（符号常量）定义为一个特定的字符串。
\#define 名字 替换文本
```
#include <stdio.h>
#define LOWER 0     /* 表的下限 */
#define UPPER 300   /* 表的上限 */
#define STEP  20    /* 表的步长 */
```
###1.5 字符串输入输出
getchar函数从文本流中读入下一个输入字符，并将其作为结果值返回。<br>
执行语句：c = getchar()<br>
putchar函数每次调用函数时将打印一个字符。<br>
执行语句：putchar(c)<br>
```
#include <stdio.h>
main(){
    int c;
    c = getchar();
    while(c != EOF){
        putchar(c);
        c = getchar();
    }
    
    /*修订版*/
    int c;
    while((c = getchar())!=EOF){
        putchar(c);
    }
}
```
问题：int c ，命令中可以接收字符串的参数，并正确输出。为什么可以？<br>
     getchar()接收的是字符，并非是字符串。<br>
## Week 3     
### 1.6 数组
    定义数组：int ndigit[10];
    赋值：ndigit[0] = 1;
    取值：printf(" %d",ndigit[0])
    char 类型的字符是小整型，因此char类型的变量和常量在算数表达式中等价于int类型的变量和常量。
## Week 4    
### 1.7 函数
编写一个求幂的函数power(m,n)来说明函数定义的方法。该函数用于计算整数m的n次幂，其中n是正整数。
```C
//函数原型：表明power函数有两个int类型的参数，并返回一个int类型的值。
int power(int,int);
int power(int m,int n);
以上两种声明方式都可以。


int main(int argc, const char * argv[]) {
    int i;
    for(i=0;i<10;++i)
        printf("%d %d %d\n",i,power(2,i),power(-3,i));
    return 0;
}

/* power 函数：求底数的n次幂；其中 n >= 0 */
int power(int base,int n){
    int i,p;
    p = 1;
    for(i = 1;i <= n;++i){
        p = p * base;
    }
    return p;
}

```
函数定义的一般形式为：

    返回值类型  函数名(0个或多个参数声明){
        声明部分
        语句序列
    }
通常把函数定义中圆括号内列表中出现的变量称为形式参数，而把函数调用中形式参数对应的值称为实际参数。<br>
#### 函数原型：
  * 它必须与power函数的定义和用法一致。如果函数的定义、用法与函数原型不一致，将会出现错误。如：函数的返回值类型、参数类型、参数数量、参数顺序。
  * 函数原型与函数声明中参数名不要求相同。
  * 被调函数写在主调用函数之后时，必须在主调用函数前或者主调用函数内声明该函数的函数原型。
  * 如果被调函数声明在主调用函数之前，该函数的函数原型是否声明则是可选。
```C
#include<stdio.h>
#include<conio.h>
void main()
{
    int sum();
    s=sum();
    printf("sum = %d",s);
}
int sum()
{
    int a,b;
    printf(”Enter any two numbers:”);
    scanf("%d%d",&a,&b);
    return a+b;
}
```  
## Week Five
### 1.8 参数---值传递
    在c语言中所有函数参数都是"通过值"传递的。也就是说，传递给被调用函数的参数值存放在临时变量中，而不是存放在原来的变量中。
    被调用函数不能直接修改主调函数中变量的值。
```C
    /* power 函数：求底数的n次幂；n>=0;版本2 */
    int power(int base,int n){
        int p;
        for(p=1;n>0;--n){
            p = p * base;
        }
        return p;
    }
``` 
    必要是也可以让函数能够修改主函数中的变量。调用者需要向被调用者提供待设置值的变量的地址（地址是指向变量的指针）
    而被调用函数需要将对应的参数声明为指针类型。

