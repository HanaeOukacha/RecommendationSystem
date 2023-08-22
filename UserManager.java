import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//classe permettant de gerer les utilisateurs
public class UserManager {
//variables
	Map <String,User> Users ;
//methods
	public UserManager() {
		this.Users=new HashMap<>();
	}
	public void AddUser(User user) {
		//ajout de nouveau utilisateurs
		Users.put(user.getIdUser(), user);
	}
	public List<User> FindSimilarUsers(User user1, int k) {
		//classe permettant de trouver les k utilisateurs similaire
		// avec une liste d'utilisateurs contenant les utilisateurs similaire en retour
	    List<User> SimilarUsers = new ArrayList<>();

	    for (User otherUser : Users.values()) {
	    //parcourir les utilisateurs de Users avec une boucle pour calculer la similarté
	        if (!otherUser.getIdUser().equals(user1.getIdUser())) {
	        	//exclure l'utilisateurs en cours 
	            double similarity = SimilarityMeasure.calculateUsersCosineSimilarity(user1, otherUser);
	            //calcule de similarité cosinus
	            otherUser.setSimilarity(similarity);
	            //mettre a jour la similarité
	            SimilarUsers.add(otherUser);
	            //ajout d'utilisateur similaire a la liste 
	        }
	    }
        //Trier la liste en ordre decroissant
	    SimilarUsers.sort((u1, u2) -> Double.compare(u1.getSimilarity(), u2.getSimilarity()));
        //selectionner les k utilisateurs
	    List<User> RecommendedUsers = SimilarUsers.subList(0, Math.min(k, SimilarUsers.size()));

	    return RecommendedUsers;
	}
	 public Collection<User> getUsers() {
	        return Users.values();
	    }


}
