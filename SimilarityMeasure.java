import java.util.*;
public class SimilarityMeasure {
	public static double calculateUsersCosineSimilarity(User user1, User user2) {
		Map<String , Double> evaluations1 = user1.getEvaluation();
		Map<String , Double> evaluations2 = user2.getEvaluation();
		double produit_scalaire = 0;
		double norme1 = 0;
		double norme2 = 0;
		
		for (String ElementId : evaluations1.keySet()) {
			if (evaluations2.containsKey(ElementId)) {
				double rating1 = evaluations1.get(ElementId);
				double rating2 = evaluations2.get(ElementId);
				
				produit_scalaire = produit_scalaire + rating1*rating2;
				norme1 = norme1 + Math.pow(rating1, 2);
				norme2 = norme2 + Math.pow(rating2, 2);
			}
		}
		if (norme1 == 0 || norme2 == 0 ) {
			return 0;//so that we don't divide by 0 
		}
		return produit_scalaire / (Math.sqrt(norme1))*(Math.sqrt(norme2));
	}
	public static double calculateElementsCosineSimilarity(Element element1, Element element2) {
		Map<String , Double> evaluations1 = element1.getEvaluation();
		Map<String , Double> evaluations2 = element2.getEvaluation();
		double produit_scalaire =0;
		double norme1 = 0;
		double norme2 = 0;
		
		for(String UserId : evaluations1.keySet()) {
			if(evaluations2.containsKey(UserId)){
				double rating1 = evaluations1.get(UserId);
				double rating2 = evaluations2.get(UserId);
				
				produit_scalaire = produit_scalaire + rating1*rating2;
				norme1 = norme1 + Math.pow(rating1, 2);
				norme2 = norme2 + Math.pow(rating2, 2);
			}
		}
		if (norme1 == 0 || norme2 == 0) {
			return 0;
		}
		double CS=produit_scalaire/ (Math.sqrt(norme1)*Math.sqrt(norme2));
		return CS;
	}
  
}
