import java.util.Map;

public class SimilarityMeasure {
	//classe permettant le calcule de la similarité en utilisant la methode similarité cosinus
	public static double calculateUsersCosineSimilarity(User user1, User user2) {
		//calcule de similarité entre deux utilisateurs 
		Map<String , Double> evaluations1 = user1.getEvaluation();
		//carte contenant les evaluations de user1 
		Map<String , Double> evaluations2 = user2.getEvaluation();
		//carte contenant les evaluations de user2
		//initialisation des variables utilisées dans le calcule de similarité 
		double produit_scalaire = 0;
		double norme1 = 0;
		double norme2 = 0;
		//calcule de produit scalaire et des normes des utilisés
		for (String ElementId : evaluations1.keySet()) {
			if (evaluations2.containsKey(ElementId)) {
				double rating1 = evaluations1.get(ElementId);
				double rating2 = evaluations2.get(ElementId);
				//mise a jour du produit scalaire
				produit_scalaire = produit_scalaire + rating1*rating2;
				//mise a jour de la norme du vecteur de premier element
				norme1 = norme1 + Math.pow(rating1, 2);
				//mise a jour de la norme du vecteur de deuxieme element
				norme2 = norme2 + Math.pow(rating2, 2);
			}
		}
		if (norme1 == 0 || norme2 == 0 ) {
			//condition pour ne pas diviser par 0
			return 0; 
		}
		//formule de calcule de similarité
		double CS = produit_scalaire / (Math.sqrt(norme1)*Math.sqrt(norme2));
		return CS;
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
