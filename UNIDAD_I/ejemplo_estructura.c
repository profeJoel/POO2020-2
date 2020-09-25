#include<stdio.h>
#include<string.h>

typedef struct direccion{
    char calle[50];
    int numero;
    char depto[10];
    char region[50];
    char ciudad[50];
}domicilio;

typedef struct humano{
    char nombre[50];
    int edad;
    domicilio casa_personal;
    domicilio laboral;
}persona;

main()
{
    persona estudiante;
    persona empleado;
    persona lista_alumnos[30];

    strcpy(estudiante.nombre,"happy8");
    estudiante.edad = 18;
    //subestructuras
    strcpy(estudiante.casa_personal.calle,"Las asusenas");
    estudiante.casa_personal.numero = 2020;
    strcpy(estudiante.casa_personal.region,"Los Lagos");
    strcpy(estudiante.casa_personal.ciudad,"Puerto Montt");

    //gets(empleado.nombre);
    //scanf("%d", &empleado.edad);

    printf("Nombre Estudiante: %s, que vive en %s\n", estudiante.nombre, estudiante.casa_personal.ciudad);
    //printf("Nombre Empleado: %s", empleado.nombre);
}