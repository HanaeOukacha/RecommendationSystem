import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recommendation {
//cette classe permet la recommandation des elements basés sur la similarité des utilisateurs
    private UserManager userManager;
    private ElementManager elementManager;

    public Recommendation(UserManager userManager, ElementManager elementManager) {
        this.userManager = userManager;
        this.elementManager = elementManager;
    }

    public List<Element> RecommendElements(User user, int k) {
//trouver les utilisateurs similaires
        List<User> similarUsers = userManager.FindSimilarUsers(user, k);
//calcule des scores de recommandation pour les elements non evalués
        Map<Element, Double> elementScores = new HashMap<>();
        for (User similarUser : similarUsers) {
            for (Element element : elementManager.getElements()) {
                if (!user.getEvaluation().containsKey(element.getIdElement())) {
                    double similarity = similarUser.getSimilarity();
                    double rating = user.getEvaluation().getOrDefault(element.getIdElement(), 0.0); // Use user's evaluation here
                    elementScores.put(element, elementScores.getOrDefault(element, 0.0) + similarity * rating);
                }
            }
        }
//trier les elements en fct de leurs scores        
        List<Element> recommendedElements = new ArrayList<>(elementScores.keySet());
        recommendedElements.sort((e1, e2) -> Double.compare(elementScores.get(e2), elementScores.get(e1)));
// Écrire les recommandations dans un fichier CSV
        CSVWriter csvWriter = new CSVWriter();
        csvWriter.writeRecommendationsToCSV("recommendations.csv", recommendedElements);
//obtention des recommandations
        return recommendedElements.subList(0, Math.min(k, recommendedElements.size()));
    }

}