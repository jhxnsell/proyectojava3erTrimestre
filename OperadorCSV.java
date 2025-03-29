import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperadorCSV {
    public static void leerCSV(File fichero, List<Map<String, String>> datos) {
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String[] encabezados = br.readLine().split(",");
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(",");
                Map<String, String> fila = new HashMap<>();
                for (int i = 0; i < encabezados.length; i++) {
                    fila.put(encabezados[i], valores[i]);
                }
                datos.add(fila);
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo CSV.");
        }
    }

    public static void escribirCSV(File fichero, List<Map<String, String>> datos) {
        try (PrintWriter pw = new PrintWriter(fichero)) {
            List<String> encabezados = new ArrayList<>(datos.get(0).keySet());
            pw.println(String.join(",", encabezados));
            for (Map<String, String> fila : datos) {
                List<String> valores = new ArrayList<>();
                for (String encabezado : encabezados) valores.add(fila.get(encabezado));
                pw.println(String.join(",", valores));
            }
        } catch (IOException e) {
            System.out.println("Error guardando el archivo CSV.");
        }
    }
}