import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Login registeredUser = null;
    static String registeredFirstName = "";
    static String registeredLastName = "";

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMainMenu();
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1" -> showRegistrationScreen();
                case "2" -> showLoginScreen();
                case "3" -> {
                    System.out.println("\nGoodbye!");
                    running = false;
                }
                default -> System.out.println("\n  Invalid option. Please enter 1, 2, or 3.\n");
            }
        }
    }

    static void showMainMenu() {
        System.out.println("========================================");
        System.out.println("           CHAT APP - MAIN MENU         ");
        System.out.println("========================================");
        System.out.println("  1. Register");
        System.out.println("  2. Login");
        System.out.println("  3. Exit");
        System.out.println("========================================");
        System.out.print("  Select an option: ");
    }

    static void showRegistrationScreen() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("             REGISTRATION               ");
        System.out.println("========================================");

        System.out.print("  First Name    : ");
        String firstName = sc.nextLine().trim();

        System.out.print("  Last Name     : ");
        String lastName = sc.nextLine().trim();

        System.out.println();
        System.out.println("  Username must contain an underscore (_)");
        System.out.println("  and be no more than 5 characters long.");
        System.out.print("  Username      : ");
        String username = sc.nextLine().trim();

        System.out.println();
        System.out.println("  Password must be at least 8 characters,");
        System.out.println("  with a capital letter, number, and symbol.");
        System.out.print("  Password      : ");
        String password = sc.nextLine().trim();

        System.out.println();
        System.out.println("  Cell phone must include international code");
        System.out.println("  e.g. +27831234567");
        System.out.print("  Cell Phone    : ");
        String cellPhone = sc.nextLine().trim();

        System.out.println();
        System.out.println("----------------------------------------");

        Login user = new Login(firstName, lastName, username, password, cellPhone);
        String result = user.registerUser();

        if (result.contains("Username successfully")) {
            registeredUser = user;
            registeredFirstName = firstName;
            registeredLastName = lastName;
            System.out.println("  Username successfully captured.");
            System.out.println("  Password successfully captured.");
            System.out.println("  Cell phone number successfully added.");
            System.out.println("  Registration complete!");
        } else {
            System.out.println("  " + result.replace("\n", "\n  "));
            System.out.println("  Registration failed. Please try again.");
        }

        System.out.println("========================================");
        System.out.println();
    }

    static void showLoginScreen() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("                 LOGIN                  ");
        System.out.println("========================================");

        if (registeredUser == null) {
            System.out.println("  No account found. Please register first.");
            System.out.println("========================================");
            System.out.println();
            return;
        }

        System.out.print("  Username : ");
        String username = sc.nextLine().trim();

        System.out.print("  Password : ");
        String password = sc.nextLine().trim();

        System.out.println();
        System.out.println("----------------------------------------");

        String status = registeredUser.returnLoginStatus(username, password);
        System.out.println("  " + status);

        System.out.println("========================================");
        System.out.println();
    }
}
