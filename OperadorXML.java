import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperadorXML {
    public static void leerXML(File fichero, List<Map<String, String>> datos) {
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            Map<String, String> fila = new HashMap<>();
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains("<") && linea.contains(">") && !linea.contains("</")) {
                    String clave = linea.substring(linea.indexOf("<") + 1, linea.indexOf(">"));
                    String valor = linea.substring(linea.indexOf(">") + 1, linea.lastIndexOf("<"));
                    fila.put(clave, valor);
                }
            }
            if (!fila.isEmpty()) {
                datos.add(fila);
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo XML.");
        }
    }

    public static void escribirXML(File fichero, List<Map<String, String>> datos) {
        try (PrintWriter pw = new PrintWriter(fichero)) {
            pw.println("<root>");
            for (Map<String, String> fila : datos) {
                pw.println("  <record>");
                for (Map.Entry<String, String> entrada : fila.entrySet()) {
                    pw.println("    <" + entrada.getKey() + ">" + entrada.getValue() + "</" + entrada.getKey() + ">");
                }
                pw.println("  </record>");
            }
            pw.println("</root>");
        } catch (IOException e) {
            System.out.println("Error guardando el archivo XML.");
        }
    }
}
