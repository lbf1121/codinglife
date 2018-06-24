The C Programming Language
-------
使用公式<sup>。</sup>C = （5/9）（<sup>。</sup>F-32）打印华氏温度与摄氏温度对照表。
```c
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

printf函数的第一个参数中的各个%分别第一个、第二个参数，它们在数目和类型上必须匹配。
%d       :按照十进制整型数打印
%6d      :按照十进制整型数打印,至少6个字符宽
%f       :按照浮点数打印
%6f      :按照浮点数打印,至少6个字符宽  
%.2f     :按照浮点数打印,保留2位小数
%6.2f    :按照浮点数打印,至少6个字符宽,保留2位小数

java中使用System.out.printf()
```
