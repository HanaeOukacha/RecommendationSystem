import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    String nomFichier ="recommendation.csv" ;
    public void writeRecommendationsToCSV(String nomFichier, List<Element> recommendations) {
        try (FileWriter writer = new FileWriter(nomFichier)) {
            // Write the header row
            writer.write("Element ID,Similarity\n");

            // Write each recommendation as a row
            for (Element element : recommendations) {
                String row = element.getIdElement()  + "," + element.getSimilarity() + "\n";
                writer.write(row);
            }

            System.out.println("Recommendations written to " + nomFichier);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
