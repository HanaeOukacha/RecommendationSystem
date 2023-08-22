import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.HashMap;
import java.util.Map;

class ElementTest {
	private Element element;
	
	@BeforeEach
	void setup() {
		element = new Element("element1");
	}
	@Test
	void addEvaluationTest() {
		element.addEvaluation("user1", 2.2);
		Map<String,Double> evaluation = element.getEvaluation();
		assertEquals(1,evaluation.size());
		assertFalse(evaluation.isEmpty());
		assertEquals(2.2,evaluation.get("user1"));
	}
	@Test
	void getUserMarkTest() {
		element.addEvaluation("user1",2.2);
		double mark = element.getUserMark("user1");
		assertEquals(2.2,mark);
		assertNull(element.getUserMark("user"));
	}
	@Test
	void getEvaluationTest() {
		Map <String,Double> expected = new HashMap<>();
		expected.put("user1", 2.2);
		expected.put("user2", 1.2);
		element.addEvaluation("user1",2.2);
		element.addEvaluation("user2", 1.2);
		Map<String,Double> actual= element.getEvaluation();
		assertEquals(expected,actual);
	}

}
