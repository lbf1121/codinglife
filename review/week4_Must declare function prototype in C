# Must declare function prototype in C? 
In ANSI C (meaning C89 or C90), you do not have to declare a function prototype.
在ANSI C（C89 或 C90）中，并不是必须声明函数原型。
however, it is a best practice to use them. 
然而，ANSI C却是使用它们的最好实践。
The only reason the standard allows you to not use them is for backward compatibility with very old code.
不使用它们的唯一的标准原因是为了兼容非常老旧的代码。
If you do not have a prototype, and you call a function, 
如果你没有函数原型，并且你调用一个函数的时候，
the compiler will infer a prototype from the parameters you pass to the function. 
编译器将会根据你传入函数的参数，推断出一个函数原型。
If you declare the function later in the same compilation unit, 
如果稍后你在同一编译单元中声明该函数。
you'll get a compile error if the function's signature is different from what the compiler guessed.
如果该函数的名称与编译器推断的不一致，你会得到一个编译错误。
Worse, if the function is in another compilation unit, 
更糟糕的是，如果后声明的这个函数，声明在其他的编译单元，
there's no way to get a compilation error, since without a prototype there's no way to check. 
你将无法获取到编译错误的信息，因为没有一个函数原型而没有办法检查错误。
In that case, if the compiler gets it wrong,you could get undefined behavior. 
在这种情况下，如果编译器出错，你可能等到未定义的行为。
if the function call pushes different types on the stack than the function expects.
如果函数在堆栈上调用推出不同的类型会与函数的预期不同。
Convention is to always declare a prototype in a header file that has the same name as the source file containing the function.
通常总是在文件的头部声明函数原型，其名称与源文件中包含的函数名称一致。
In C99 or C11, standard C requires a function declaration in scope before you call any function. 
在C99或C11中，标准C在调用任何函数之前都需要在作用域内声明函数。
Many compilers do not enforce this restriction in practice unless you force them to do so.
事实上，许多编译器都不会强制执行这个限制，除非你认为强制它们这样做。


[原文](https://stackoverflow.com/questions/2575153/must-declare-function-prototype-in-c)
