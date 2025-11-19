# 💻 T.P. Programación Funcional con Java Streams y Lombok

Este repositorio contiene la solución a una serie de casos prácticos diseñados para practicar las **Operaciones Intermedias** (filter, map, sorted, limit) y **Terminales** (collect, reduce, average, max) de los **Java Streams**.

Se utiliza la librería **Lombok** para generar automáticamente *getters*, constructores y `toString`, manteniendo el código limpio y enfocado en la lógica funcional.

El programa toma una lista inicial de objetos Alumno (cada uno con nombre, nota y curso) y la procesa de forma declarativa para generar cuatro reportes clave:

1. Alumnos Aprobados y Ordenados
El código aplica una secuencia de transformaciones (un pipeline):

Filtra (filter): Mantiene solo a los alumnos con notas mayores o iguales a 7.

Mapea (map): Convierte cada objeto Alumno restante en su nombre en mayúsculas.

Ordena (sorted): Organiza esos nombres alfabéticamente.

Recolecta (collect): Almacena el resultado final en una nueva lista.

2. Promedio General de Notas
El programa utiliza la funcionalidad de reducción de Streams:

Mapea a Primitivo (mapToDouble): Extrae todas las notas en un stream de números flotantes de alta eficiencia.

Calcula Promedio (average): Ejecuta la operación terminal para calcular el valor único que representa el promedio de todas las notas.

3. Agrupación por Curso
Se utiliza el poderoso Collector groupingBy para crear una estadística de distribución:

Agrupa (groupingBy): Transforma la lista en un Mapa. La clave de este mapa es el nombre del curso (ej: "A", "B") y el valor es una lista de todos los objetos Alumno que pertenecen a ese curso.

4. Obtener los 3 Mejores Promedios
Esta operación combina ordenamiento y limitación:

Ordena (sorted): Organiza todos los alumnos en orden descendente según su nota.

Limita (limit): Selecciona solo los primeros tres alumnos de esa lista ordenada.

Recolecta (collect): Devuelve la lista con el Top 3.

***

## 🚀 Cómo Ejecutar el Proyecto (Gradle)

El proyecto utiliza **Gradle** para manejar las dependencias (como Lombok) y la ejecución.

1.  **Asegúrate de estar en la carpeta raíz del proyecto** (`Trabajo_Practico_Funcional`).
2.  **Ejecuta el comando** `run` de Gradle en tu terminal:

```bash
./gradlew run
