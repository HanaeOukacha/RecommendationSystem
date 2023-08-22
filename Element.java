import java.util.HashMap;
import java.util.Map;
//Cette classe est un modele de données representant les elements
public class Element {
//variables
	private String idElement ;
	Map<String, Double> evaluation ;
//carte associant l'id des utilisateurs et la note donnée a chaque element
	private double similarity;
//methods
	public Element (String idElement) {
		this.idElement = idElement;
		this.evaluation=new HashMap<>();
	}
	public void addEvaluation(String idUser, double note) {
		//ajout de la note donée par l'utilisateur
		evaluation.put(idUser, note);
	}
	public Double getUserMark(String idUser) {
		//boucle permetant de parcourir la carte
		//et obtention de note donné par l'utilisateur
		if (evaluation.containsKey(idUser)) {
			return evaluation.get(idUser);
		}else {
			return null;
		}	
	}
	public Map<String,Double> getEvaluation(){
		return evaluation;
	}
	public String getIdElement() {
		return idElement;}
	//getters et setters de similarité
		public void setSimilarity(double similarity) {
	        this.similarity = similarity;
	    }
	    
		public double getSimilarity() {
			
			return similarity;
		
	}
	
}
