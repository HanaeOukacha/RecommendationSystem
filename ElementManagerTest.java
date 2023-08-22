import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ElementManagerTest {
    private ElementManager elementManager;
    
    @BeforeEach
    public void setup() {
        elementManager = new ElementManager();
    }
    
    @Test
    public void addElementTest() {
        Element element = new Element("element1");
        elementManager.AddElement(element);
        assertTrue(elementManager.getElements().contains(element));
    }
    
    @Test
    public void findSimilarElementsTest() {
        Element element1 = new Element("element1");
        Element element2 = new Element("element2");
        
        element1.addEvaluation("user1", 4.0);
        element2.addEvaluation("user1", 3.0);
        
        elementManager.AddElement(element1);
        elementManager.AddElement(element2);
        
        List<Element> similarElements = elementManager.FindSimilarElements(element1, 1);
        
        assertEquals(1, similarElements.size());
        assertEquals("element2", similarElements.get(0).getIdElement());
    }
}

