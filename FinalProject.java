import java.util.*;

public class FinalProject {

  // Arrays
  static Scanner input = new Scanner(System.in);
  static String[] ids = new String[100];
  static String[] usernames = new String[100];
  static String[] Emails = new String[100];
  static String[] phone_numbers = new String[100];
  static String[] passwords = new String[100];
  static double[] balance = new double[100];
  static String[] account_status = new String[100];

  static String currentemail = "";

  static boolean login(String email, String password) { // LOGIN FEATURE
    System.out.print("Enter your Email: ");
    email = input.next();
    for (int i = 0; i < Emails.length; i++) {
      if (Emails[i] != null && Emails[i].equalsIgnoreCase(email)) {
        System.out.print("Enter your password: ");
        password = input.next();
        if (passwords[i].equals(password)) {
          System.out.println("Your logged in");
          System.out.println();
          currentemail = email;
          return true;
        } else {
          System.out.println("Wrong password");
          return false;
        }
      }
    }
    System.out.println("Invalid Email");
    return false;
  }

  static boolean logout() { // LOGOUT FEATURE
    System.out.print("Are you sure u want to logout (Y/N): ");
    String choice = input.next();
    if (choice.equalsIgnoreCase("Y")) {
      return true;
    } else {
      return false;
    }
  }

  static void showBalance(String email) {
    for (int i = 0; i < Emails.length; i++) {
      if (Emails[i] != null && Emails[i].equalsIgnoreCase(email)) {
        System.out.print("Your balance is: " + balance[i]);
        System.out.println();
        break;
      }
    }

  }

  public static void main(String[] args) {
    // Filling Arrays
    String[] ids_store = { "753489", "992931", "758737", "333943", "841524", "395337" };
    for (int i = 0; i < ids_store.length; i++) {
      ids[i] = ids_store[i];
    }
    String[] usernames_store = { "ahmed012", "amr_78", "joe818", "aly72", "hesham98", "abdo88" };
    for (int i = 0; i < usernames_store.length; i++) {
      usernames[i] = usernames_store[i];
    }
    String[] Emails_store = { "ahmed_mohamed@gmail.com", "amr_youssed@gmail.com", "joe_yasser@gmail.com",
        "aly_osama@gmail.com", "hesham_ahmed@gmail.com", "abdelrahman_yasser@gmail.com" };
    for (int i = 0; i < Emails_store.length; i++) {
      Emails[i] = Emails_store[i];
    }
    String[] phone_numbers_store = { "01036794460", "01182173694", "01266433666", "01267049359", "01528060153",
        "01245151486" };
    for (int i = 0; i < phone_numbers_store.length; i++) {
      phone_numbers[i] = phone_numbers_store[i];
    }
    String[] passwords_store = { "Ahmed#2026!", "Amr_7890$", "JoePass@99", "Aly!Secret12", "Hesham#456*",
        "Abdo_2026#" };
    for (int i = 0; i < passwords_store.length; i++) {
      passwords[i] = passwords_store[i];
    }
    double[] balance_store = { 15960.6, 2600.15, 1500, 8850.5, 26900, 10000.2 };
    for (int i = 0; i < ids_store.length; i++) {
      balance[i] = balance_store[i];
    }
    while (true) {

      System.out.println("========== QUICK PAY ==========");
      System.out.println("1. Login as Admin");
      System.out.println("2. Login as User");
      System.out.println("3. Exit");
      System.out.print("Choose an option: ");
      int x = input.nextInt();
      System.out.println();
      switch (x) {
        case 1:
          // admin panel
          System.out.println("========== ADMIN PANEL ==========");
          System.out.println("1. Show Statistics");
          System.out.println("2. Search user");
          System.out.println("3. View All Users");
          System.out.println("4. Update User");
          System.out.println("5. View All Transactions");
          System.out.println("6. Block Account");
          System.out.println("7. Unblock Account");
          System.out.println("8. View User Details");
          System.out.println("9. Logout");
          System.out.print("Choose an option: ");
          int y = input.nextInt();
          switch (y) {
            case 1: // Show Statistics

            case 2: // Search User

            case 3: // View All Users

            case 4: // Update user

            case 5: // View All Transactions

            case 6: // Block account

            case 7: // Unblock account

            case 8: // View User Details

            case 9: // Logout

            default:
              break;
          }
          break;
        case 2:
          // user panel
          String email = "";
          String password = "";
          boolean stayloggedin = false;
          if (login(email, password))
            stayloggedin = true;
          while (stayloggedin) {
            System.out.println("========== USER PANEL ==========");
            System.out.println("1. Show Balance");
            System.out.println("2. Transfer Money");
            System.out.println("3. Transaction History");
            System.out.println("4. Show Favorites");
            System.out.println("5. Add Favorite");
            System.out.println("6. Remove Favorite");
            System.out.println("7. Search Recipient");
            System.out.println("8. View Profile");
            System.out.println("9. Update profile");
            System.out.println("10. Logout");
            System.out.print("Choose an option: ");
            int z = input.nextInt();
            switch (z) {
              case 1: // Show Balance
                System.out.println();
                showBalance(currentemail);
                System.out.println();
                break;
              case 2: // Transfer Money

              case 3: // Transaction History

              case 4: // Show Favorites

              case 5: // Add Favorites

              case 6: // Remove Favorites

              case 7: // Search Recipient

              case 8: // View Profile

              case 9: // Update Profile

              case 10: // Logout
                if (logout()) {
                  currentemail = "";
                  stayloggedin = false;
                }
                break;
              default:
                break;

            }
          }

          break;
        case 3:
          // exit option
          System.out.println("Thank you for using our app");
          return;

        default:
          break;
      }

    }
  }
}
