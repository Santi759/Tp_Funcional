package org.example.Ejercicio4_Empleado;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Empleado> empleados = Arrays.asList(
                new Empleado("Sergio Maravilla", "Ventas", 1500.00, 29),
                new Empleado("Azul Marina", "RRHH", 1800.00, 25),
                new Empleado("Pedro Rios", "Finanzas", 4000.00, 45),
                new Empleado("Mercedes Raff", "IT", 4500.50, 46)


        );

        // 1. Obtener la lista de empleados cuyo salario sea mayor a 2000, ordenados por salario descendente.

        List<Empleado> salariosAltos = empleados.stream()
                .filter(e -> e.getSalario() > 2000)
                .sorted(Comparator.comparing(Empleado::getSalario).reversed())
                .collect(Collectors.toList());

        System.out.println("1. Empleados con salario mayor a 2000 (orden descendente): ");
        salariosAltos.forEach(System.out::println);

        // 2. Calcular el salario promedio general.

        double salarioPromedioGeneral = empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average()
                .orElse(0.0);

        System.out.printf("\n2. Salario Promedio General: %.2f%n", salarioPromedioGeneral);

        // 3. Agrupar los empleados por departamento y calcular la suma de salarios de cada uno.

        Map<String, Double> sumaSalariosPorDepartamento = empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado::getDepartamento,
                        Collectors.summingDouble(Empleado::getSalario)
                ));

        System.out.println("\n3. Suma de Salarios por Departamento");
        sumaSalariosPorDepartamento.forEach((depto, suma) ->
                System.out.printf("  -  %s: %.2f%n", depto, suma)
        );

        // 4. Obtener los nombres de los 2 empleados más jóvenes.

        List<String> dosMasJovenes = empleados.stream()
                .sorted(Comparator.comparing(Empleado::getEdad))
                .limit(2)
                .map(Empleado::getNombre)
                .collect(Collectors.toList());

        System.out.println("\n4. Nombres de los 2 empleados mas jovenes: ");
        dosMasJovenes.forEach(n -> System.out.println(" - " + n));

    }
}