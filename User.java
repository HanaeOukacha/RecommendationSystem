import java.util.HashMap;
import java.util.Map;
//Cette classe est un modele de données representant les utilisateurs 
public class User {
//variables
	private String idUser;
	private double similarity;
	Map<String, Double> evaluation ;//carte associant l'id des elements et sa note
//methods
	public User(String idUser) {
		this.idUser= idUser;
		this.evaluation = new HashMap<>();
	}
	public void addEvaluation(String idElement, double note) {
		//ajouter les notes que donne l'utilisateur
		// a l'element en parametre
		evaluation.put(idElement, note);
	}
    public Double getElementMark(String idElement) {
    	//utilisation d'une boucle pour parcourire la carte
    	// et obtention de note de chaque element
		if ( evaluation.containsKey(idElement)) {
			return evaluation.get(idElement);
		}else {
			return null;
		}
	}
    public Map<String,Double> getEvaluation(){
    	return evaluation;
    }
    public String getIdUser() {
    	return idUser;
    }
    //getters et setters pour la similarité 
    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }
    
	public double getSimilarity() {
		
		return similarity;
	}
}
