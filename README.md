Servicios-Procesos
Descripción
Este proyecto en Java simula la interacción entre un proceso padre y tres procesos hijos, cada uno encargado de manejar archivos .txt con números. El objetivo es leer los archivos de texto, procesar su contenido sumando los números en cada archivo y guardar el resultado en un archivo de salida.

Características
Interacción entre procesos padre e hijos: Utiliza ProcessBuilder para ejecutar procesos hijos desde el proceso principal, pasando la ruta de los archivos a procesar.
Lectura y escritura de archivos: Maneja archivos .txt, leyendo su contenido, procesando los datos (sumando números) y escribiendo el resultado en un archivo nuevo.
Modularidad: El código está dividido en varias clases, siguiendo principios de programación orientada a objetos para mejorar su mantenimiento y legibilidad.
Manejo de errores: Implementa manejo básico de excepciones para garantizar la estabilidad del programa, especialmente en operaciones de lectura y escritura de archivos.
Ejecución en múltiples hilos: Los procesos hijos se ejecutan en hilos separados, permitiendo un procesamiento eficiente de múltiples archivos.
Tecnologías Utilizadas
Lenguaje: Java
Conceptos clave: Manejo de procesos del sistema, manejo de archivos, programación orientada a objetos, manejo de excepciones.
Flujo del Programa
El proceso padre escanea un directorio dado en busca de archivos .txt.
Por cada archivo encontrado, el padre lanza un proceso hijo específico (según el tipo de archivo) para procesarlo.
Los procesos hijos leen el archivo de texto, suman los números dentro del archivo y guardan el resultado en un archivo de salida.
Finalmente, el proceso padre recopila los resultados de las sumas y los guarda en un archivo de resumen.
Instrucciones para Ejecutar
Clona este repositorio en tu máquina local.
Asegúrate de tener Java instalado en tu entorno de desarrollo.
Ejecuta la clase Padre para iniciar el proceso de lectura, procesamiento y escritura de archivos.
Mejoras Posibles
Agregar una interfaz gráfica para una mejor interacción con el usuario.
Implementar pruebas unitarias utilizando JUnit.
Optimizar el código y hacerlo más flexible con las rutas de archivos y directorios.
