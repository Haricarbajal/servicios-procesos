# servicios-procesos
Características:
Interacción entre procesos padre e hijos: Utiliza ProcessBuilder para ejecutar procesos hijos desde el proceso principal, pasando información sobre la ruta de los archivos a procesar.
Lectura y escritura de archivos: El programa maneja archivos .txt, leyendo su contenido, procesando los datos (sumando números), y escribiendo el resultado en un archivo nuevo.
Modularidad: El código está dividido en varias clases para mejorar su mantenimiento y legibilidad, siguiendo principios de programación orientada a objetos.
Manejo de errores básico: Se implementa manejo de excepciones para garantizar la estabilidad del programa, especialmente en las operaciones de lectura y escritura de archivos.
Ejecución en múltiples hilos: Los procesos hijos se ejecutan en hilos separados, lo que permite una ejecución más controlada y eficiente cuando se manejan múltiples archivos.
Tecnologías Utilizadas:
Lenguaje: Java
Conceptos: Manejo de procesos del sistema, manejo de archivos, programación orientada a objetos, manejo de excepciones.
Flujo del Programa:
El proceso padre escanea un directorio dado en busca de archivos .txt.
Por cada archivo encontrado, el padre lanza un proceso hijo específico (según el tipo de archivo) para procesarlo.
Los procesos hijos leen el archivo de texto, suman los números dentro del archivo y guardan el resultado de la suma en un archivo de salida.
Al final, el proceso padre recopila los resultados de las sumas y las guarda en un archivo de resumen.
Instrucciones para Ejecutar:
Clona este repositorio en tu máquina local.
Asegúrate de tener instalado Java en tu entorno de desarrollo.
Ejecuta la clase Padre para iniciar el proceso de lectura, procesamiento y escritura de archivos.
Mejoras Posibles:
Agregar una interfaz gráfica para una mejor interacción con el usuario.
Implementar pruebas unitarias utilizando JUnit.
Optimizar el código y hacer que el programa sea más flexible con las rutas de archivos y directorios.
