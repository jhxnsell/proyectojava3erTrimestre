import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GestorArchivos {
    public static void readFile(String rutaCarpeta, List<Map<String, String>> datos) {
        Scanner sc = new Scanner(System.in);
        if (rutaCarpeta.isEmpty()) {
            System.out.println("Primero seleccione una carpeta.");
            return;
        }

        System.out.print("Ingrese el nombre del fichero: ");
        String nombreFichero = sc.nextLine();
        File fichero = new File(rutaCarpeta, nombreFichero);
        if (!fichero.exists()) {
            System.out.println("El archivo no existe.");
            return;
        }

        datos.clear();
        if (nombreFichero.endsWith(".csv")) OperadorCSV.leerCSV(fichero, datos);
        else if (nombreFichero.endsWith(".json")) OperadorJSON.leerJSON(fichero, datos);
        else if (nombreFichero.endsWith(".xml")) OperadorXML.leerXML(fichero, datos);
        else {
            System.out.println("Formato no soportado.");
            return;
        }

        System.out.println("Archivo leído con éxito. Registros cargados: " + datos.size());
    }

    public static void convertFile(String rutaCarpeta, List<Map<String, String>> datos) {
        if (datos.isEmpty()) {
            System.out.println("No hay datos para convertir.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Seleccione formato de salida (csv/json/xml): ");
        String tipoArchivo = sc.nextLine();
        System.out.print("Ingrese el nombre del archivo de salida: ");
        String nombreFinal = sc.nextLine();
        File ficheroResultado = new File(rutaCarpeta, nombreFinal + "." + tipoArchivo);

        switch (tipoArchivo) {
            case "csv": OperadorCSV.escribirCSV(ficheroResultado, datos); break;
            case "json": OperadorJSON.escribirJSON(ficheroResultado, datos); break;
            case "xml": OperadorXML.escribirXML(ficheroResultado, datos); break;
            default: System.out.println("Formato no soportado.");
        }
    }
}