package org.example.Ejercicio3_Libro;

import java.util.*;
import java.util.stream.Collectors;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Libro> catalogo = Arrays.asList(
                new Libro("Choque de Reyes", "George R.R Martin", 958, 37000.00),
                new Libro("Juego de Tronos", "George R.R Martin", 756, 34000.00),
                new Libro("Harry Potter y la Orden del Fenix", "J.K Rowling", 976, 54000.00),
                new Libro("Harry Potter y la Camara Secreta", "J.K Rowling", 260, 35000.00)
        );

        //1. Listar los títulos de los libros con más de 300 páginas, ordenados alfabéticamente.

        List<String> titulosLargos = catalogo.stream()
                .filter(l -> l.getPaginas() > 300)
                .map(Libro::getTitulo)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("1. Titulos de libros con mas de 300 paginas (ordenados)");
        titulosLargos.forEach(t -> System.out.println("  - " + t));

        // 2. Calcular el promedio de páginas de todos los libros.

        double promedioPaginas = catalogo.stream()
                .mapToInt(Libro::getPaginas)
                .average()
                .orElse(0.0);

        System.out.printf("\n2. Promedio de paginas de todos los libros: %.2f%n", promedioPaginas);

        // 3. Agrupar los libros por autor y contar cuántos libros tiene cada uno.

        Map<String, Long> conteoLibrosPorAutor = catalogo.stream()
                .collect(Collectors.groupingBy(
                        Libro::getAutor,
                        Collectors.counting()
                ));

        System.out.println("\n3. Conteo de libros por autor:");
        conteoLibrosPorAutor.forEach((autor, cantidad) ->
                System.out.println("  - " + autor + ": " + cantidad + " libros")
        );

        // 4. Obtener el libro más caro de la lista.

        Optional<Libro> libroMasCaro = catalogo.stream()
                .max(Comparator.comparing(Libro::getPrecio));

        System.out.println("\n4. El libro mas caro de la lista: ");
        libroMasCaro.ifPresentOrElse(
                libro -> System.out.println(" -> " + libro),
                () -> System.out.println("  -> No se encontraron libros")
        );

    }
}