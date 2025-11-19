package org.example.Ejercicio1_Alumno;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Alumno> alumnos = Arrays.asList(
                new Alumno("Ana Pereyra", 8.5, "A"),
                new Alumno("Juan Mata", 5.0, "B" ),
                new Alumno("Mauro Lombardo", 10, "C")
        );

        System.out.println("--- PRACTICA DE STREAMS EN JAVA ----");

        //1. OBTENER LOS NOMBRES DE LOS ALUMNOS APROBADOS (NOTA >= 7) EN MAYÚSCULAS Y ORDENADOS
        System.out.println("\n1. Alumnos Aprobados (>=7), Mayúsculas y Ordenados:");
        List<String> nombresAprobadosOrdenados = alumnos.stream()
                .filter(a -> a.getNota() >= 7)
                .map(a -> a.getNombre().toUpperCase())
                .sorted()
                .collect(Collectors.toList());

        System.out.println(nombresAprobadosOrdenados);

        //2. Calcular el promedio general de notas

        System.out.println("\n2. Promedio General de Notas:");
        double promedioGeneral = alumnos.stream()
                .mapToDouble(Alumno::getNota) // Operación de mapeo a primitivo para eficiencia
                .average() // Operación terminal de reducción
                .orElse(0.0);

        System.out.printf("El promedio general de la clase es: %.2f%n", promedioGeneral);

        // 3. Agrupar alumnos por curso usando Collectors.groupingBy().
        System.out.println("\n3. Agrupación de Alumnos por Curso:");

        Map<String, List<Alumno>> alumnosPorCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));

        alumnosPorCurso.forEach((curso, lista) -> {
            System.out.println("  - Curso " + curso + " (" + lista.size() + " alumnos):");
            lista.forEach(a -> System.out.println("    " + a));
        });

        // 4. Obtener los 3 mejores promedios.
        System.out.println("\n4. Los 3 Alumnos con Mejores Promedios:");
        List<Alumno> top3Alumnos = alumnos.stream()

                // Ordenar por nota de forma descendente
                .sorted(Comparator.comparing(Alumno::getNota).reversed())
                .limit(3)
                .collect(Collectors.toList());

        top3Alumnos.forEach(System.out::println);

    }
}