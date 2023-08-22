import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimilarityMeasureTest {
	User user1;
	User user2;
	Element element1;
	Element element2;
	
	@BeforeEach
	void setup() {
	    user1 = new User("user1");
	    user2 = new User("user2");
	    element1 = new Element("element1");
	    element2 = new Element("element2");
	}

	@Test
	void CalculateUserCosineSimilarityTest() {
		user1.addEvaluation("element1", 5.0);
		user1.addEvaluation("element2", 4.0);
		user1.addEvaluation("element3", 3.0);
		
		user2.addEvaluation("element1", 4.0);
		user2.addEvaluation("element2", 2.0);
		user2.addEvaluation("element3", 5.0);
		
		double actualsimilarityvalue=SimilarityMeasure.calculateUsersCosineSimilarity(user1, user2);
		double expectedsimilarityvalue=(5.0 * 4.0 + 4.0 * 2.0 + 3.0 * 5.0) /(Math.sqrt(5.0 * 5.0 + 4.0 * 4.0 + 3.0 * 3.0) * Math.sqrt(4.0 * 4.0 + 2.0 * 2.0 + 5.0 * 5.0));
		double similarityThreshold = 1e-6;
		assertEquals(expectedsimilarityvalue,actualsimilarityvalue,similarityThreshold);
	}
	@Test
	void CalculateElementCosineSimilarityTest() {
		element1.addEvaluation("user1", 5.0);
		element1.addEvaluation("user2", 4.0);
		element1.addEvaluation("user3", 3.0);
		
		element2.addEvaluation("user1", 4.0);
		element2.addEvaluation("user2", 2.0);
		element2.addEvaluation("user3", 5.0);
		
		double actualsimilarityvalue=SimilarityMeasure.calculateElementsCosineSimilarity(element1, element2);
		double expectedsimilarityvalue=(5.0 * 4.0 + 4.0 * 2.0 + 3.0 * 5.0) /(Math.sqrt(5.0 * 5.0 + 4.0 * 4.0 + 3.0 * 3.0) * Math.sqrt(4.0 * 4.0 + 2.0 * 2.0 + 5.0 * 5.0));
		double similarityThreshold = 1e-6;
		assertEquals(expectedsimilarityvalue,actualsimilarityvalue,similarityThreshold);
	}

}
