import java.util.*;
public class ElementManager {
//variables
	Map <String,Element> Elements;
//methods
	public ElementManager() {
		this.Elements= new HashMap<>();
	}
	public void AddElement(Element element) {
		Elements.put(element.getIdElement(), element);
	}
	public List<Element> FindSimilarElements(Element element1, int k) {
	    List<Element> SimilarElements = new ArrayList<>();

	    for (Element otherElement : Elements.values()) {
	        if (!otherElement.getIdElement().equals(element1.getIdElement())) {
	            double similarity = SimilarityMeasure.calculateElementsCosineSimilarity(element1, otherElement);
	            otherElement.setSimilarity(similarity);
	            SimilarElements.add(otherElement);
	        }
	    }

	    SimilarElements.sort((e1, e2) -> Double.compare(e2.getSimilarity(), e1.getSimilarity()));

	    List<Element> RecommendedElements = SimilarElements.subList(0, Math.min(k, SimilarElements.size()));

	    return RecommendedElements;
	}
	 public Collection<Element> getElements() {
	        return Elements.values();
	    }
}
