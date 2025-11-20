# 🚀 Programación Funcional en Java: Streams y Lombok

Este repositorio contiene la solución a una serie de **cuatro ejercicios prácticos** diseñados para consolidar los conocimientos de **Programación Funcional en Java** utilizando la API de Streams.

Cada ejercicio se enfoca en aplicar filtros, mapeos, ordenamientos y operaciones de agregación (promedio, suma, conteo) en estructuras de datos reales.

---

## 🛠️ Tecnologías Utilizadas

* **Java 17+:** Lenguaje base para la implementación.
* **Java Streams API:** El núcleo del trabajo; se usa para procesar colecciones de forma declarativa.
* **Lombok:** Librería utilizada para simplificar las clases de datos (`Alumno`, `Producto`, `Libro`, `Empleado`), generando automáticamente *getters*, constructores y `toString`. Esto mantiene el código conciso y enfocado en la lógica funcional.
* **Gradle:** Sistema de construcción utilizado para gestionar las dependencias y ejecutar el proyecto.

---

## 📁 Estructura del Proyecto y Contenido

El trabajo práctico está dividido en cuatro casos de estudio, organizados en carpetas separadas para mantener la claridad.

| Ejercicio | Clase de Datos | Enfoque de Streams |
| :--- | :--- | :--- |
| **Ejercicio1_Alumno** | `Alumno(nombre, nota, curso)` | Filtrado, Mapeo a mayúsculas, Promedios, Top N (Limit). |
| **Ejercicio2_Producto** | `Producto(nombre, categoria, precio, stock)` | Agrupación por categoría (`groupingBy`), Suma de stock (`summingInt`), Generación de reportes (`joining`). |
| **Ejercicio3_Libro** | `Libro(titulo, autor, paginas, precio)` | Búsqueda de Máximos (`max`), Conteo por autor (`counting`), Promedio de páginas. |
| **Ejercicio4_Empleado** | `Empleado(nombre, departamento, salario, edad)` | Filtro por salario, Suma de salarios por departamento (`summingDouble`), Obtener los más jóvenes. |

---

## ⚙️ Cómo Ejecutar los Programas

Dado que todos los ejercicios comparten la misma estructura base y se ejecutan desde el archivo `Main.java` de cada carpeta, la ejecución es **uniforme** a través de Gradle.

Para ejecutar cualquiera de los ejercicios:

1.  **Asegúrate de que tu `build.gradle` tenga configurada la clase principal correcta** (`mainClass`) para el ejercicio que deseas probar.
    *(Ejemplo para ejecutar el Ejercicio 1: `mainClass = 'org.example.Ejercicio1_Alumno.Main'`)*

2.  **Ejecuta el comando `run` de Gradle** en la terminal desde la raíz del proyecto:

```bash
./gradlew run
