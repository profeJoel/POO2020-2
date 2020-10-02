#include<stdio.h>

int pot(int base, int exp)
{
    int p = 1;
    for(exp = exp; exp > 0; exp--)
        p *= base;
    
    return p;
}

int pot_rec(int base, int exp)
{
    if(exp == 1) // marca el término del ciclo
        return base;
    else
        return base * pot_rec(base, exp-1); // exp debe ser modificado en cada ciclo
}

int main()
{
    int a, b;
    a = 2;
    b = 6;
    printf("potencia de %d elevado a %d es %d", a, b, pot_rec(a,b));
}