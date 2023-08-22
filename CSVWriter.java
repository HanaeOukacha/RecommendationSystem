import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVWriter {
    public void writeRecommendationsToCSV(String nomFichier, List<Element> recommendations) {
        try (FileWriter writer = new FileWriter(nomFichier)) {
            // Ecrire l'en tete
            writer.write("Element ID,Similarity\n");

            // ecrire chaque recommandation en une ligne
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

