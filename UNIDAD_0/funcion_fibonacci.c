/*
fib(n) = fib(n-1) + fib(n-2)
fib(<0)= 0
fib(0) = 1
fib(1) = 1

0,1,1,2,3,5,8,13,21,34,55,89,144,233,...
*/

#include<stdio.h>

long fibonacci(long n)
{
    long siguiente = 1, actual = 0, temporal = 0, x;
    for(x = 1; x <= n; x++)
    {
        printf("\nvalor %ld = %ld", x, actual);
        temporal = actual;
        actual = siguiente;
        siguiente += temporal;
    }
    printf("\nvalor %ld = %ld", x, actual);
    return actual;
}

long fibonacci_rec(long n)
{
    if(n < 2)
        return n;
    else
        return fibonacci_rec(n-1) + fibonacci_rec(n-2);
}

main()
{
    unsigned long fib10 = fibonacci(1000);
    //unsigned long fib10 = fibonacci_rec(1000);
    printf("\n\nEl valor del fib de 10 es: %ld", fib10);
}