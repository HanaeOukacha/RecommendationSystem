
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class UserTest {
	private User user;
	 @BeforeEach
	 public void setup() {
		 user = new User("user 1");
	 }
	 @Test
	 public void addEvaluationTest() {
		 user.addEvaluation("element1", 4.2);
		 Map<String,Double> evaluation= user.getEvaluation();
		 assertEquals(1,evaluation.size());
		 assertFalse(evaluation.isEmpty());
		 assertEquals(4.2,evaluation.get("element1"));
	 }
	 @Test
	 public void getElementMarkTest() {
		 user.addEvaluation("element1", 4.2);
		 double mark = user.getElementMark("element1");
		 assertEquals(4.2,mark);
		 assertNull(user.getElementMark("element"));
	 }
	 @Test
	 public void getEvaluationTest() {
		 user.addEvaluation("element1", 4.2);
		 user.addEvaluation("element2",1.5);
		 Map<String,Double> expected = new HashMap<>();
		 expected.put("element1",4.2);
		 expected.put("element2",1.5);
		 
		 Map<String,Double> actual = user.getEvaluation();
		 assertEquals(expected,actual);
	 }
	 @Test
	 public void getIdUserTest() {
		 assertEquals("user 1",user.getIdUser());
	 }

}
