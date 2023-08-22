import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	String filePath;
    public static List<User> readUsers(String filePath) throws IOException {
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

                User user = getUserById(users, idUser);
                if (user == null) {
                    user = new User(idUser);
                    users.add(user);
                }
                user.addEvaluation(idElement, note);
            }
        }

        return users;
    }

    public static List<Element> readElements(String filePath) throws IOException {
        List<Element> elements = new ArrayList<>();

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

                Element element = getElementById(elements, idElement);
                if (element == null) {
                    element = new Element(idElement);
                    elements.add(element);
                }
                element.addEvaluation(idUser, note);
            }
        }

        return elements;
    }

    private static User getUserById(List<User> users, String idUser) {
        for (User user : users) {
            if (user.getIdUser().equals(idUser)) {
                return user;
            }
        }
        return null;
    }

    private static Element getElementById(List<Element> elements, String idElement) {
        for (Element element : elements) {
            if (element.getIdElement().equals(idElement)) {
                return element;
            }
        }
        return null;
    }

}

