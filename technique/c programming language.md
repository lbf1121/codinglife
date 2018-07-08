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
###1.6 数组
    定义数组：int ndigit[10];
    赋值：ndigit[0] = 1;
    取值：printf(" %d",ndigit[0])
    char 类型的字符是小整型，因此char类型的变量和常量在算数表达式中等价于int类型的变量和常量。
###1.7
###1.8
###1.9
###1.10
