import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperadorJSON {
    public static void leerJSON(File fichero, List<Map<String, String>> datos) {
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            StringBuilder contenidoJSON = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                contenidoJSON.append(linea);
            }
            //coñazo histórico si se me permite la grosería -Lucas.
            String jsonAString = contenidoJSON.toString().replace("[", "").replace("]", "").trim();
            String[] objetos = jsonAString.split("},");
            for (String objeto : objetos) {
                objeto = objeto.replace("{", "").replace("}", "").trim();
                Map<String, String> fila = new HashMap<>();
                String[] parejasAtributos = objeto.split(",");
                for (String pareja : parejasAtributos) {
                    String[] clave = pareja.split(":");
                    fila.put(clave[0].trim().replace("\"", ""), clave[1].trim().replace("\"", ""));
                }
                datos.add(fila);
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo JSON.");
        }
    }

    public static void escribirJSON(File fichero, List<Map<String, String>> datos) {
        try (PrintWriter pw = new PrintWriter(fichero)) {
            pw.println("[");
            for (int i = 0; i < datos.size(); i++) {
                pw.print("  {");
                Map<String, String> fila = datos.get(i);
                int contador = 0;
                for (Map.Entry<String, String> entrada : fila.entrySet()) {
                    pw.print("\"" + entrada.getKey() + "\": \"" + entrada.getValue() + "\"");
                    if (++contador < fila.size()) pw.print(", ");
                }
                pw.println("}" + (i < datos.size() - 1 ? "," : ""));
            }
            pw.println("]");
        } catch (IOException e) {
            System.out.println("Error guardando el archivo JSON.");
        }
    }
}
