import java.util.Scanner;
/*Mostrará un menú por consola con las siguientes opciones:

Seleccionar carpeta: Permitirá la entrada por teclado de una ruta a una carpeta en el sistema de ficheros. 
Deberá controlarse la existencia de la ruta dada.

Lectura de fichero: Permitirá la entrada por teclado de un nombre de un fichero dentro de la carpeta seleccionada. 
Deberá comprobarse la existencia o no del archivo. El programa entenderá el formato del fichero mediante la extensión del mismo. 
Tras su lectura, el programa deberá tener almacenado en las estructuras de datos correspondientes la información del fichero.
Debe ser posible seleccionar esta opción múltiples veces durante una misma ejecución del programa, 
eliminando el contenido presente en las estructuras de datos antes de proceder a una nueva lectura.

Conversión a: Permitirá seleccionar uno de los tres formatos siguientes: csv, json y xml. 
Posteriormente, pedirá un nombre para el fichero de salida, al que añadirá la extensión correspondiente. 
Finalmente, exportará la información contenida en las estructuras de datos mencionadas en el apartado anterior 
en el formato seleccionado. Esta opción solo se permitirá tras haber seleccionado un fichero.

Salir: Cierra el programa. */
public class Menu{
    public static void main (String[] args){ 
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            try {
                //Menú
                System.out.println("1. Seleccionar carpeta");
                System.out.println("2. Lectura de fichero");
                System.out.println("3. Convertir");
                System.out.println("4. Salir");
                System.out.println("Elige una opcion: ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        
                        break;
    
                    case 2:
                        
                        break;
    
                    case 3:
                        
                        break;
    
                    case 4:
                        System.out.println("Saliendo...");
                        System.exit(0);
                        break;
                
                    default:
                        System.out.println("Opción no valida, prueba otra vez");
                        break;
                }
                /*La interfaz mostrará, además del menú, la siguiente información:

                Ruta de la carpeta seleccionada.

                Contenido de la carpeta seleccionada.

                Fichero seleccionado. */
            
                //Información a mostrar (se muestra siempre)
                System.out.println("Ruta de la carpeta: " /*+ rutaCarpeta*/);
                System.out.println("Contenido de la carpeta: ");
                System.out.println(/*+ contenidoCarpeta*/);
                System.out.println("Fichero seleccionado: " /*+ fichero*/);
                
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.next();
            } finally {
                if (sc != null) {
                    try {
                        sc.close();
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }
        } while (true);
    }
}