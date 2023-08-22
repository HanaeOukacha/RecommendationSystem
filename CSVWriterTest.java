import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVWriterTest {
    private CSVWriter csvWriter;
    private List<Element> recommendations;

    @BeforeEach
    public void setUp() {
        csvWriter = new CSVWriter();
        recommendations = new ArrayList<>();
        Element element1 = new Element("Element1");
        element1.setSimilarity(0.85);
        Element element2 = new Element("Element2");
        element2.setSimilarity(0.72);
        Element element3 = new Element("Element3");
        element3.setSimilarity(0.91);
        recommendations.add(element1);
        recommendations.add(element2);
        recommendations.add(element3);
    }

    @Test
    public void testWriteRecommendationsToCSV() throws IOException {
        String testFileName = "recommendations.csv";

        csvWriter.writeRecommendationsToCSV(testFileName, recommendations);

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(testFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        assertEquals(4, lines.size()); // Inclure l'en tete
        assertEquals("Element ID,Similarity", lines.get(0));
        assertEquals("Element1,0.85", lines.get(1));
        assertEquals("Element2,0.72", lines.get(2));
        assertEquals("Element3,0.91", lines.get(3));
    }
}


