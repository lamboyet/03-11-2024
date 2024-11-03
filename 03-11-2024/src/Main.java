import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Please choose an option: ");
        System.out.println("1.Register");
        System.out.println("2.Login");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter Password: ");
        String password = scanner.nextLine();

        switch (choice)
        {
            case 1:
                Authentication.register(username,password);
                break;

            case 2:
                if(Authentication.login(username,password))
                {
                    System.out.println("Login succesful\n Hello " + username);
                }
                break;
            default:
                System.out.println("Invalid Choice");
        }

        scanner.close();
    }
}
