import java.util.*;

public class UserManager {
//variables
	Map <String,User> Users ;
//methods
	public UserManager() {
		this.Users=new HashMap<>();
	}
	public void AddUser(User user) {
		Users.put(user.getIdUser(), user);
	}
	public List<User> FindSimilarUsers(User user1, int k) {
	    List<User> SimilarUsers = new ArrayList<>();

	    for (User otherUser : Users.values()) {
	        if (!otherUser.getIdUser().equals(user1.getIdUser())) {
	            double similarity = SimilarityMeasure.calculateUsersCosineSimilarity(user1, otherUser);
	            otherUser.setSimilarity(similarity);
	            SimilarUsers.add(otherUser);
	        }
	    }

	    SimilarUsers.sort((u1, u2) -> Double.compare(u2.getSimilarity(), u1.getSimilarity()));

	    List<User> RecommendedUsers = SimilarUsers.subList(0, Math.min(k, SimilarUsers.size()));

	    return RecommendedUsers;
	}


}