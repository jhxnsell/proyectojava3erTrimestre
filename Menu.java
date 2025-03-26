import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Menu{
    private static Scanner sc = new Scanner(System.in);
    private static String rutaCarpeta = "";
    private static String ficheroSeleccionado = "";

    public static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Seleccionar carpeta");
        System.out.println("2. Lectura de fichero");
        System.out.println("3. Conversión");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        System.out.println("");
        
        //Información a mostrar (se muestra siempre)
        System.out.println("Carpeta seleccionada: " + rutaCarpeta);
        System.out.println("Contenido de la carpeta: " /*+ contenidoCarpeta*/);
        System.out.println("Fichero seleccionado: " + ficheroSeleccionado);
    }

    public static void seleccionarCarpeta() {
        System.out.print("Ingrese la ruta de la carpeta: ");
        String ruta = sc.nextLine();
        if (Files.isDirectory(Paths.get(ruta))) {
            rutaCarpeta = ruta;
            System.out.println("Carpeta seleccionada: " + rutaCarpeta);
        } else {
            System.out.println("La carpeta no existe.");
        }
    }

    public static void main (String[] args){ 
        Scanner sc = new Scanner(System.in);
        while (true) {
            mostrarMenu();
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1: seleccionarCarpeta(); break;
                case 2: /*leerFichero()*/; break;
                case 3: /*convertirFichero()*/; break;
                case 4: sc.close(); System.exit(0);
                default: System.out.println("Opción inválida, prueba otra vez");
            }
        }
    }
}