import java.util.*;
public class Element {
//variables
	private String idElement ;
	Map<String, Double> evaluation ;
//methods
	public Element (String idElement) {
		this.idElement = idElement;
		this.evaluation=new HashMap<>();
	}
	public void addEvaluation(String idUser, double note) {
		evaluation.put(idUser, note);
	}
	public Double getUserMark(String idUser) {
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
		return idElement;
	}
	
}
