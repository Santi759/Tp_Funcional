package org.example.Ejercicio2_Producto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Producto> productos = Arrays.asList(
                new Producto("Laptop Pro", "Electronica", 1200.00, 5),
                new Producto("Teclado Mecanico", "Electronica", 150.00, 20),
                new Producto("Escritorio", "Mobiliario", 300.00, 2),
                new Producto("Monitor 4k", "Electronica", 500.00, 15)
        );

        // 1. Listar productos con precio mayor a 100, ordenados por precio descendente.

        List<Producto> productosCarosOrdenados = productos.stream()
                .filter(p -> p.getPrecio() > 100)
                .sorted(Comparator.comparing(Producto::getPrecio).reversed())
                .collect(Collectors.toList());

        System.out.println("1. Productos con precio > 100 (Orden descendente):");
        productosCarosOrdenados.forEach(System.out::println);

        // 2. Agrupar productos por categoría y calcular el stock total.

        Map<String, Integer> stockTotalPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategorias,
                        Collectors.summingInt(Producto::getStock)
                ));

        System.out.println("\n2. Stock Total por Categoria");
        stockTotalPorCategoria.forEach((categoria, stock) ->
                System.out.println("  - " + categoria + ": " + stock + " unidades")
        );

        // 3. Generar un String separando con “;” cada producto que contenga nombre y precio, usando map + collect(joining)

        String reporteProductoPrecio = productos.stream()
                .map(p -> p.getNombre() + " (" + p.getPrecio() + ")")
                .collect(Collectors.joining(";"));
        System.out.println("\n3. Reporte Nombre y Precio (Separado por ';'):");
        System.out.println(reporteProductoPrecio);

        // 4. Calcular el precio promedio general y por categoría.

        // Precio promedio general

        double precioPromedioGeneral = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0.0);

        System.out.printf("\n4. A) Precio Promedio General: %.2f%n", precioPromedioGeneral);

        // Precio promedio por categoría

        Map<String, Double> precioPromedioPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategorias,
                        Collectors.averagingDouble(Producto::getPrecio)
                ));
        System.out.println("4.B) Precio Promedio por Categorias");
        precioPromedioPorCategoria.forEach((categoria, promedio)->
                System.out.printf("  -%s: %.2f%n", categoria, promedio)
        );

    }
}