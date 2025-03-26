import java.util.Scanner;
/*Se tratará de una aplicación cuya interfaz de usuario se realizará por consola.

Mostrará un menú por consola con las siguientes opciones:

Seleccionar carpeta: Permitirá la entrada por teclado de una ruta a una carpeta en el sistema de ficheros. 
Deberá controlarse la existencia de la ruta dada.

Conversión a: Permitirá seleccionar uno de los tres formatos siguientes: csv, json y xml. 
Posteriormente, pedirá un nombre para el fichero de salida, al que añadirá la extensión correspondiente. 
Finalmente, exportará la información contenida en las estructuras de datos mencionadas en el apartado anterior en el 
formato seleccionado. Esta opción solo se permitirá tras haber seleccionado un fichero. */
public class GestorArchivos{

    public String ruta;
        public GestorArchivos(){
            String ruta = "";
            File fichero = new File(ruta);
        }
    

    public String getRuta() {
        return this.ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
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