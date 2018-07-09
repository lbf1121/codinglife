#include <stdio.h>
int main(int argc, char const *argv[])
{
    /* code */
    printf("my first c coding!\n");
    int i;
    for(i=0;i<10;i++){
        printf("%d",i,"/n");
    }

    int fahr,celsius;
    int lower,upper,step;
    lower = 0;
    upper = 300;
    step = 20;

    fahr = lower;
    while(fahr <= upper){
        //套用公式：Celsius = 5/9 Fahrenheit
        celsius = 5 * (fahr - 32) / 9;
        printf("%d\t%d\n",fahr,celsius);
        fahr = fahr + step;
    }

    return 0;
}


