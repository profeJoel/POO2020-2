#include<stdio.h>
#include<stdlib.h>

int contar_caracteres(char m[])
{
    int c;
    for(c = 0; m[c] != '\0'; c++);
        //printf("caracter %c : %d\n", m[c], c+1);//solamente de prueba

    return c;
}

int contar_caracteres_rec(char m[], int c)
{
    if(m[c] == '\0') // hasta el ultimo caracter
        return c; //respuesta
    else
        return contar_caracteres_rec(m, c+1); // caso recursivo -> aumenta valor de c
}

int main()
{
    //char mensaje[] = "este es un mensaje de prueba";//28 caracteres
    char mensaje[20];
    printf("Ingrese una frase:\n");
    gets(mensaje); // gets captura hasta el ENTER
    //fgets(mensaje, 20, stdin); // captura hasta el ENTER o el LIMITE (archivos)
    //printf("\nLa cantidad de caracteres del string son: %d", contar_caracteres(mensaje));
    printf("\nLa cantidad de caracteres del string son: %d", contar_caracteres_rec(mensaje,0));
    return 0;
}