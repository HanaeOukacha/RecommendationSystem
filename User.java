import java.util.*;
public class User {
//variables
	private String idUser;
	private double similarity;
	Map<String, Double> evaluation ;
//methods
	public User(String idUser) {
		this.idUser= idUser;
		this.evaluation = new HashMap<>();
	}
	public void addEvaluation(String idElement, double note) {
		evaluation.put(idElement, note);
		
	}
    public Double getElementMark(String idElement) {
		if ( evaluation.containsKey(idElement)) {
			return evaluation.get(idElement);
		}else {
			return null;
		}
	}
    public Map<String,Double> getEvaluation(){
    	return evaluation;
    }
    public void setSimilarity(double similarity) {
        this.similarity = similarity;
    }
    public String getIdUser() {
    	return idUser;
    }
	public double getSimilarity() {
		
		return similarity;
	}
}
