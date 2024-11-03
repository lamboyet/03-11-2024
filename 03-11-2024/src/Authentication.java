import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Authentication {
    private static String hashPassword(String password)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();

            for(byte b:hash)
            {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length()==1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public static void register(String username, String password)
    {
        List<User> users = FileHandler.loadUsers();
        for(User user:users)
        {
            if(user.getUsername().equals(username))
            {
                System.out.println("Username already exists. Please choose a different one.");
                return;
            }
        }
        String hashedPassword = hashPassword(password);
        User newUser = new User(username,hashedPassword);
        FileHandler.saveUser(newUser);
        System.out.println("User registered succesfully ");
    }

    public static boolean login(String username, String password )
    {
        List<User> users = FileHandler.loadUsers();
        String hashedPassword = hashPassword(password);
        for(User user : users)
        {
            if(user.getUsername().equals(username) && user.getPassword().equals(hashedPassword))
            {
                return true;
            }
        }
        System.out.println("Invalid username or password");
        return false;
    }


}
