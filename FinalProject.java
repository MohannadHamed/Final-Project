import java.util.*;

public class FinalProject {

  // Arrays
  static Scanner input = new Scanner(System.in);
  static String[] ids = new String[100];
  static String[] usernames = new String[100];
  static String[] Emails = new String[100];
  static String[] phone_numbers = new String[100];
  static String[] passwords = new String[100];
  static long[] balance = new long[100];
  static String[] account_status = new String[100];

  static String currentemail = "";

  static boolean login_admin(String adminlog, String adminpass) {
    System.out.print("Enter Admin Login: ");
    adminlog = input.next();
    if (adminlog.equalsIgnoreCase("Admin")) {
      System.out.print("Enter Admin password: ");
      adminpass = input.next();
      if (adminpass.equals("Adminpass123")) {
        System.out.println("Your logged in");
        System.out.println();
        return true;
      } else {
        System.out.println("Wrong Password");
        return false;
      }
    }
    System.out.println("Invalid Admin login");
    return false;
  }

  static boolean login(String email, String password) { // LOGIN FEATURE
    System.out.print("Enter your Email: ");
    email = input.next();
    for (int i = 0; i < Emails.length; i++) {
      if (Emails[i] != null && Emails[i].equalsIgnoreCase(email)) {


        if(account_status[i] != null && account_status[i].equalsIgnoreCase("Blocked"))
        {
          System.out.println("This account is blocked");
          System.out.println();
          return false;
        }
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
        System.out.print("Your balance is: " + (double) balance[i] / 100 + " EGP");
        System.out.println();
        break;
      }
    }

  }

  static void viewProfile() {
    for (int i = 0; i < Emails.length; i++) {
      if (Emails[i] != null && Emails[i].equalsIgnoreCase(currentemail)) {
        System.out.println();
        System.out.println("ID: " + ids[i]);
        System.out.println("Username: " + usernames[i]);
        System.out.println("Email: " + Emails[i]);
        System.out.println("PhoneNumber: " + phone_numbers[i]);
        System.out.println("password: " + passwords[i]);
        System.out.println("Account status: " + account_status[i]);
        System.out.println();
        break;
      }
    }
  }

  static void updateProfile() {
    for (int i = 0; i < Emails.length; i++) {
      if (Emails[i] != null && Emails[i].equalsIgnoreCase(currentemail)) {
        System.out.println("What do u want to edit");
        System.out.println(" 1.Username\n 2.Email\n 3.PhoneNumber\n 4.password");
        System.out.println();
        System.out.print("Enter your choice: ");
        int edit = input.nextInt();
        switch (edit) {
          case 1:
            System.out.print("Enter your new Username: ");
            String new_Username = input.next();
            usernames[i] = new_Username;
            System.out.println("Your new Username is " + usernames[i]);
            System.out.println();
            break;

          case 2:
            System.out.print("Enter your new Email: ");
            String new_Email = input.next();
            Emails[i] = new_Email;
            System.out.println("Your new Email is " + Emails[i]);
            currentemail = Emails[i];
            System.out.println();
            break;
          case 3:
            System.out.print("Enter your new PhoneNumber: ");
            String new_phone_number = input.next();
            phone_numbers[i] = new_phone_number;
            System.out.println("Your new PhoneNumber is " + phone_numbers[i]);
            System.out.println();
            break;
          case 4:
            System.out.print("Enter your new Password: ");
            String new_password = input.next();
            passwords[i] = new_password;
            System.out.println("Your new password is " + passwords[i]);
            System.out.println();
            break;
          default:
            System.out.println("Invalid choice");
            break;
        }
        break;
      }
    }
  }

  public static boolean SignUp(String newEmail, String newPassword, String newPhonenumber, String newUserName) {
    boolean empty = false;
    int index = 0;
    for (int i = 0; i < Emails.length; i++) {
      if (Emails[i] == null) {
        empty = true;
        index = i;
        break;
      }
    }
    if (empty) {
      System.out.print("Enter your new Email: ");
      newEmail = input.next();

      for (int i = 0; i < Emails.length; i++) {
        if (Emails[i] != null && Emails[i].equalsIgnoreCase(newEmail)) {
          System.out.println("Email already registered!");
          System.out.println();
          return false;
        }
      }

      System.out.print("Enter your new UserName: ");
      newUserName = input.next();
      usernames[index] = newUserName;
      Emails[index] = newEmail;
      System.out.print("Enter your new PhoneNumber: ");
      newPhonenumber = input.next();
      phone_numbers[index] = newPhonenumber;
      System.out.print("Enter your new Password: ");
      newPassword = input.next();
      passwords[index] = newPassword;

      ids[index] = String.valueOf((int) (Math.random() * 900000) + 100000); // the range formula (maxNumber - minNumber
                                                                            // + 1)
      balance[index] = 0L;
      account_status[index] = "Unblocked";
      currentemail = newEmail;
      System.out.println("Account created succesfully! Your ID is " + ids[index]);
      System.out.println();
      return true;
    } else {
      System.out.println("System Full. Cannot register in the mean time");
      System.out.println();
      return false;
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
    String[] Emails_store = { "ahmed_mohamed@gmail.com", "amr_youssef@gmail.com", "joe_yasser@gmail.com",
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
    long[] balance_store = { 1596060L, 260015L, 150000L, 885050L, 2690000L, 1000020L };
    for (int i = 0; i < balance_store.length; i++) {
      balance[i] = balance_store[i];
    }
    String[] account_status_store = { "UnBlocked", "Blocked", "Blocked", "UnBlocked", "UnBlocked", "Blocked" };
    for (int i = 0; i < account_status_store.length; i++) {
      account_status[i] = account_status_store[i];
    }

    while (true) { // Running the program till user uses exit

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
          String adminlogin = "";
          String adminpassword = "";
          boolean adminloggedin = false;

          if (login_admin(adminlogin, adminpassword))
            adminloggedin = true;
          while (adminloggedin) {
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
                if (logout()) {
                  currentemail = "";
                  adminloggedin = false;
                }
                break;
            }
          }
          break;
        case 2:
          // user panel
          System.out.println("1.Login\n2.SignUp");
          System.out.println();
          System.out.print("Enter your choice: ");
          int signlog = input.nextInt();
          boolean stayloggedin = false;


          switch (signlog) {
            case 1:
              String email = "";
              String password = "";
              
              if (login(email, password))
                stayloggedin = true;
              break;
            case 2:
            String newEmail = "";
            String newPassword = "";
            String newPhonenumber = "";
            String newUserName = "";
            if(SignUp(newEmail, newPassword, newPhonenumber, newUserName))
              stayloggedin = true;
            break;

            default:
              System.out.println("Invalid choice");
              break;
          }


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
                viewProfile();
                break;
              case 9: // Update Profile
                updateProfile();
                break;
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
