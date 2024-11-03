import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String FILE_NAME = "users.txt";

    public static void saveUser( User user)
    {
        try(FileWriter writer = new FileWriter(FILE_NAME, true))
        {
            writer.write(user.toString() + "\n");

        }catch (IOException e)
        {
            System.out.println("Error saving user: " + e.getMessage());
        }
    }

    public static List<User> loadUsers()
    {
        List<User> users = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME)))
        {
            String line;
            while((line = reader.readLine()) !=null)
                users.add(User.fromString(line));

        }
    catch (IOException e)
    {
        System.out.println("Error loading users: " + e.getMessage());
    }
        return users;

}}
