import java.io.File;

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
