package org.example.Ejercicio4_Empleado;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString

public class Empleado {

    private String nombre;
    private String departamento;
    private double salario;
    private int edad;
}
