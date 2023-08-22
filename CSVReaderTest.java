import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CSVReaderTest {

    @Test
    public void testReadUsers() throws IOException {
        String filePath = "C:\\Users\\hanae\\desktop\\Systeme de recommandation/src/data.csv";

        List<User> users = CSVReader.readUsers(filePath);

        assertNotNull(users);
        assertEquals(3, users.size());

        User user1 = users.get(0);
        assertEquals("user1", user1.getIdUser());
        assertEquals(2, user1.getEvaluation().size());

        User user2 = users.get(1);
        assertEquals("user2", user2.getIdUser());
        assertEquals(2, user2.getEvaluation().size());
    }

    @Test
    public void testReadElements() throws IOException {
        String filePath = "C:\\Users\\hanae\\desktop\\Systeme de recommandation/src/data.csv";

        List<Element> elements = CSVReader.readElements(filePath);

        assertNotNull(elements);
        assertEquals(3, elements.size());

        Element element1 = elements.get(0);
        assertEquals("element1", element1.getIdElement());
        assertEquals(3, element1.getEvaluation().size());

        Element element2 = elements.get(1);
        assertEquals("element2", element2.getIdElement());
        assertEquals(1, element2.getEvaluation().size());
    }
    }

