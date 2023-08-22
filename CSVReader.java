import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
//lire les données a partie d'un fichier csv
	String filePath;
    public static List<User> readUsers(String filePath) throws IOException {
// // Lire les données des utilisateurs à partir d'un fichier csv et creer une liste d'objets User
        List<User> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean headerSkipped = false; // Skip the header line
            while ((line = reader.readLine()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue;
                }
                String[] parts = line.split(",");
                String idUser = parts[0];
                String idElement = parts[1];
                double note = Double.parseDouble(parts[2]);
// Trouver ou créer l'utilisateur
                User user = getUserById(users, idUser);
                if (user == null) {
                    user = new User(idUser);
                    users.add(user);
                }
//ajout d'evaluation
                user.addEvaluation(idElement, note);
            }
        }

        return users;
    }

    public static List<Element> readElements(String filePath) throws IOException {
 // Lire les données des éléments à partir d'un fichier CSV et créer une liste d'objets Element
        List<Element> elements = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean headerSkipped = false; //ignoer l'en tete
            while ((line = reader.readLine()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue;
                }
                String[] parts = line.split(",");
                String idUser = parts[0];
                String idElement = parts[1];
                double note = Double.parseDouble(parts[2]);
//trouver ou creer l'elemeng
                Element element = getElementById(elements, idElement);
                if (element == null) {
                    element = new Element(idElement);
                    elements.add(element);
                }
//ajouter l'evaluation
                element.addEvaluation(idUser, note);
            }
        }

        return elements;
    }
//trouver un objet user par son id
//methode auxilliaire
    private static User getUserById(List<User> users, String idUser) {
        for (User user : users) {
            if (user.getIdUser().equals(idUser)) {
                return user;
            }
        }
        return null;
    }
//trouver l'element par id
//methode auxilliaire
    private static Element getElementById(List<Element> elements, String idElement) {
        for (Element element : elements) {
            if (element.getIdElement().equals(idElement)) {
                return element;
            }
        }
        return null;
    }

}

