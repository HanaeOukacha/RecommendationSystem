import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class RecommendationTest {

    private Recommendation recommendation;
    private UserManager userManager;
    private ElementManager elementManager;

    @BeforeEach
    public void setUp() {
        userManager = new UserManager();
        elementManager = new ElementManager();
        recommendation = new Recommendation(userManager, elementManager);
    }

    @Test
    public void testRecommendElements() {
        User user1 = new User("User1");
        user1.addEvaluation("Element1", 4.0);
        userManager.AddUser(user1);

        User user2 = new User("User2");
        user2.addEvaluation("Element1", 3.0);
        user2.addEvaluation("Element2", 4.5);
        user2.addEvaluation("Element4", 2.0);
        userManager.AddUser(user2);

        Element element1 = new Element("Element1");
        Element element2 = new Element("Element2");
        Element element3 = new Element("Element3");
        Element element4 = new Element("Element4");
        Element element5 = new Element("Element5");
        Element element6 = new Element("Element6");
        Element element7 = new Element("Element7");
        elementManager.AddElement(element1);
        elementManager.AddElement(element2);
        elementManager.AddElement(element3);
        elementManager.AddElement(element4);
        elementManager.AddElement(element5);
        elementManager.AddElement(element6);
        elementManager.AddElement(element7);

        int k = 3;

        List<Element> recommendedElements = recommendation.RecommendElements(user1, k);

        assertNotNull(recommendedElements);
        assertEquals(k, recommendedElements.size()); 
        for (Element recommendedElement : recommendedElements) {
            assertFalse(user1.getEvaluation().containsKey(recommendedElement.getIdElement()));
        }
    }
}


