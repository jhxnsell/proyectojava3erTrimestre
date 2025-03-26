import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CSVtoJSON {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String inputFile = "coches.csv";
        String outputFile = "coches.json";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
                FileWriter fileWriter = new FileWriter(outputFile)) {
                
                    String linea = br.nextLine();
                    List<String> headers = Arrays.asList(linea.split(","));

                    
        }
    }
}
