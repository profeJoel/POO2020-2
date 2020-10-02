#include<stdio.h>
#include<string.h>
#define L 30
#define N 5

typedef struct automovil{
    int anio;
    char marca[L];
    char modelo[L];
}vehiculo;

void ingresar(vehiculo *a)
{
    printf("Ingrese el anio del auto: ");
    scanf("%d", &a->anio);

    printf("Ingrese la marca del auto: ");
    scanf("%s", a->marca);

    printf("Ingrese la modelo del auto: ");
    scanf("%s", a->modelo);
}

void modificar(vehiculo *a, int anio, char marca[], char modelo[])
{
    if(anio > 0) // si ingresa un número negativo, se considera NULO
        a->anio = anio;
    
    if(marca != NULL)
        strcpy(a->marca, marca);
    
    if(modelo != NULL)
        strcpy(a->modelo, modelo);
}

void imprimir_auto(vehiculo *a)
{
    printf("\n\nAnio: %d\n", a->anio);
    printf("Marca: %s\n", a->marca);
    printf("Modelo: %s\n", a->modelo);
}

void intercambio(vehiculo *origen, vehiculo *destino)
{
    destino->anio = origen->anio;
    strcpy(destino->marca, origen->marca);
    strcpy(destino->modelo, origen->modelo);
}

void ordenar_por_anio(vehiculo a[])
{
    int i,j;
    vehiculo aux;
    for(i=0; i<N; i++)
    {
        for(j=0; j<N; j++)
        {
            if(a[i].anio > a[j].anio)
            {
                intercambio(&a[i],&aux);
                intercambio(&a[j],&a[i]);
                intercambio(&aux,&a[j]);
            }
        }
    }
}

void ordenar_por_modelo(vehiculo a[])
{
    int i,j;
    vehiculo aux;
    for(i=0; i<N; i++)
    {
        for(j=0; j<N; j++)
        {
            if(a[i].modelo[0] < a[j].modelo[0])
            {
                intercambio(&a[i],&aux);
                intercambio(&a[j],&a[i]);
                intercambio(&aux,&a[j]);
            }
        }
    }
}

main()
{
    int i;
    vehiculo autitos[N];

    for(i=0; i<N; i++)
        ingresar(&autitos[i]);
    
    for(i=0; i<N; i++)
        imprimir_auto(&autitos[i]);

    ordenar_por_anio(autitos);
    printf("\n\n Vehiculos ORDENADOS POR ANIO\n");
    for(i=0; i<N; i++)
        imprimir_auto(&autitos[i]);

    
    ordenar_por_modelo(autitos);
    printf("\n\n Vehiculos ORDENADOS POR MODELO\n");
    for(i=0; i<N; i++)
        imprimir_auto(&autitos[i]);
}
