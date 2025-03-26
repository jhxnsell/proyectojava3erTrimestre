import java.io.File;
/*Lectura de fichero: Permitirá la entrada por teclado de un nombre de un fichero dentro de la carpeta seleccionada. 
Deberá comprobarse la existencia o no del archivo. El programa entenderá el formato del fichero mediante la extensión del mismo. 
Tras su lectura, el programa deberá tener almacenado en las estructuras de datos correspondientes la información del fichero. 
Debe ser posible seleccionar esta opción múltiples veces durante una misma ejecución del programa, eliminando el contenido 
presente en las estructuras de datos antes de proceder a una nueva lectura. */
public class LectorArchivos {
    public String lecturaFichero(String extension){
        if (existe.isTrue()){
            System.out.println("Introduce nombre del fichero");
            String nombreFich = sc.nextLine();
            File fichero1 = new File(nombreFich);
            if (!fichero1.exists()){
                System.out.println("El fichero" + fichero1 + "no existe");
            } else {
                extensionArchivo(nombreFich);
                if (nombreFich.equals(".csv")){

                }
            }
        }
    }
    private static String extensionArchivo(String linea) {
        String[] partes = linea.split(" ");
        return (partes.length > 1) ? partes[1].replace(".", "") : "Desconocido";
    }
}
