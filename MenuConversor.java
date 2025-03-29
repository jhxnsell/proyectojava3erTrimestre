import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuConversor {
    private static Scanner sc = new Scanner(System.in);
    private static String carpetaSeleccionada = "";
    private static List<Map<String, String>> data = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1: seleccionarCarpeta(); break;
                case 2: GestorArchivos.readFile(carpetaSeleccionada, data); break;
                case 3: GestorArchivos.convertFile(carpetaSeleccionada, data); break;
                case 4: System.exit(0);
                default: System.out.println("Opción inválida.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Seleccionar carpeta");
        System.out.println("2. Seleccionar archivo");
        System.out.println("3. Convertir archivo");
        System.out.println("4. Salir");
        System.out.println("Carpeta seleccionada: " + carpetaSeleccionada);
        System.out.print("Seleccione una opción: ");
    }

    private static void seleccionarCarpeta() {
        System.out.print("Ingrese la ruta de la carpeta: ");
        String ruta = sc.nextLine();
        if (Files.isDirectory(Paths.get(ruta))) {
            carpetaSeleccionada = ruta;
            System.out.println("Carpeta seleccionada: " + carpetaSeleccionada);
        } else {
            System.out.println("La carpeta no existe.");
        }
    }
}