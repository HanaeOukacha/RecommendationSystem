import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserManagerTest {
    private UserManager userManager;
    
    @BeforeEach
    public void setup() {
        userManager = new UserManager();
    }
    
    @Test
    public void addUserTest() {
        User user = new User("user1");
        userManager.AddUser(user);
        assertTrue(userManager.getUsers().contains(user));
    }
    
    @Test
    public void findSimilarUsersTest() {
        User user1 = new User("user1");
        User user2 = new User("user2");
        
        user1.addEvaluation("element1", 4.0);
        user2.addEvaluation("element1", 3.0);
        
        userManager.AddUser(user1);
        userManager.AddUser(user2);
        
        List<User> similarUsers = userManager.FindSimilarUsers(user1, 1);
        
        assertEquals(1, similarUsers.size());
        assertEquals("user2", similarUsers.get(0).getIdUser());
    }
}

