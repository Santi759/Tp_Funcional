package org.example.Ejercicio2_Producto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString

public class Producto {
    private String nombre;
    private String categorias;
    private double precio;
    private int stock;
}
