import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//classe permettant de gérer les elements
public class ElementManager {
//variables
	Map <String,Element> Elements;
	// carte associant l'element et son id
//methods
	public ElementManager() {
		this.Elements= new HashMap<>();
	}
	public void AddElement(Element element) {
		//ajout de nouveau element et son id
		Elements.put(element.getIdElement(), element);
	}
	public List<Element> FindSimilarElements(Element element1, int k) {
		//classe permettant de trouver les k elements similaire
		// avec une liste d'element contenant les elements similaire en retour
	    List<Element> SimilarElements = new ArrayList<>();

	    for (Element otherElement : Elements.values()) {
	    	//parcourir les elements de Elements avec une boucle pour calculer la similarté
	        if (!otherElement.getIdElement().equals(element1.getIdElement())) {
	        	//exclure l'element en cours 
	            double similarity = SimilarityMeasure.calculateElementsCosineSimilarity(element1, otherElement);
	            //calcule de similarité cosinus
	            otherElement.setSimilarity(similarity);
	            //mettre a jour la similarité calculé
	            SimilarElements.add(otherElement);
	            //ajouté l'element a la liste d'element similaire
	        }
	    }
	    //trier la liste en ordre decroissant
	    SimilarElements.sort((e1, e2) -> Double.compare(e2.getSimilarity(), e1.getSimilarity()));
        //selectionner les k elements
	    List<Element> RecommendedElements = SimilarElements.subList(0, Math.min(k, SimilarElements.size()));

	    return RecommendedElements;
	}
	 public Collection<Element> getElements() {
	        return Elements.values();
	    }
}
