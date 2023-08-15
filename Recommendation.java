import java.util.*;

public class Recommendation {
    private UserManager userManager;
    private ElementManager elementManager;

    public Recommendation(UserManager userManager, ElementManager elementManager) {
        this.userManager = userManager;
        this.elementManager = elementManager;
    }

    public List<Element> RecommendElements(User user, int k) {
        List<User> similarUsers = userManager.FindSimilarUsers(user, k);

        // Calculate weighted recommendations based on user similarity and element ratings
        Map<Element, Double> elementScores = new HashMap<>();
        for (User similarUser : similarUsers) {
            for (Element element : elementManager.getElements()) {
                if (!user.getEvaluation().containsKey(element.getIdElement())) {
                    double similarity = similarUser.getSimilarity();
                    double rating = similarUser.getEvaluation().getOrDefault(element.getIdElement(), 0.0);
                    elementScores.put(element, elementScores.getOrDefault(element, 0.0) + similarity * rating);
                }
            }
        }

        // Sort and return the top k recommended elements
        List<Element> recommendedElements = new ArrayList<>(elementScores.keySet());
        recommendedElements.sort((e1, e2) -> Double.compare(elementScores.get(e2), elementScores.get(e1)));

        return recommendedElements.subList(0, Math.min(k, recommendedElements.size()));
    }

    public List<Element> RecommendPersonalizedElements(User user, int k) {
        List<User> similarUsers = userManager.FindSimilarUsers(user, k);

        // Calculate personalized recommendations based on user similarity and past evaluations
        Map<Element, Double> elementScores = new HashMap<>();
        for (User similarUser : similarUsers) {
            for (Element element : elementManager.getElements()) {
                if (!user.getEvaluation().containsKey(element.getIdElement())) {
                    double similarity = similarUser.getSimilarity();
                    double rating = similarUser.getEvaluation().getOrDefault(element.getIdElement(), 0.0);
                    elementScores.put(element, elementScores.getOrDefault(element, 0.0) + similarity * rating);
                }
            }
        }

        // Sort and return the top k personalized recommended elements
        List<Element> recommendedElements = new ArrayList<>(elementScores.keySet());
        recommendedElements.sort((e1, e2) -> Double.compare(elementScores.get(e2), elementScores.get(e1)));

        return recommendedElements.subList(0, Math.min(k, recommendedElements.size()));
    }
}




