import java.io.File;
import java.util.Scanner;
public class GestorArchivos{
    Scanner sc = new Scanner(System.in);
    public void seleccionarArchivo(boolean existe){
        System.out.println("Introduce la ruta del archivo");
        String ruta = sc.nextLine();
        File fichero = new File(ruta);
            if (fichero.exists()) {
                existe = true;
            } else {
                System.out.println("La ruta seleccionada no existe");
                existe = false;
            }
    }

}