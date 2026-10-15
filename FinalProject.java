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

  static long[] amounts = new long[100];
  static String[] transaction_senders = new String[100];
  static String[] transaction_receivers = new String[100];
  static String[] transaction_status = new String[100];

  static int totaltransactions = 0;
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

        if (account_status[i] != null && account_status[i].equalsIgnoreCase("Blocked")) {
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
            int emailcheck = Find_User_Email_OR_Phone(new_Email);
            if (emailcheck == -1 || emailcheck == i) {
              Emails[i] = new_Email;
              System.out.println("Your new Email is " + Emails[i]);
              currentemail = Emails[i];
              System.out.println();
              break;
            } else
              System.out.println("This Email is already registered");
            break;

          case 3:
            System.out.print("Enter your new PhoneNumber: ");
            String new_phone_number = input.next();
            int phonenumbercheck = Find_User_Email_OR_Phone(new_phone_number);
            if (phonenumbercheck == -1 || phonenumbercheck == i) {
              phone_numbers[i] = new_phone_number;
              System.out.println("Your new PhoneNumber is " + phone_numbers[i]);
              System.out.println();
              break;
            } else
              System.out.println("This PhoneNumber is already registered");
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
      account_status[index] = "Active";
      currentemail = newEmail;
      System.out.println("Account created succesfully! Your ID is " + ids[index]);
      System.out.println();
      if (index >= userCount)
        userCount = index + 1;
      return true;
    } else {
      System.out.println("System Full. Cannot register in the mean time");
      System.out.println();
      return false;
    }
  }

  // Malak
  // Searches for a user and displays the result
  static void SearchUser() {
    int index = Find_User_From_Prompt();
    if (index == -1) {
      System.out.println("User Not Found");
    } else {
      printUser(index);

    }
  }

  // Searches for a user by ID.
  // We return the user's index, or -1 if the user is not found.
  static int userCount = 6;

  static int Find_User_By_id(String id) {
    for (int i = 0; i < userCount; i++) {
      if (ids[i] != null && ids[i].equals(id)) {
        return i;
      }
    }
    return -1;
  }

  // Searches for a user by username.
  static int Find_User_By_Name(String name) {
    for (int i = 0; i < userCount; i++) {
      if (usernames[i] != null && usernames[i].equalsIgnoreCase(name)) {
        return i;
      }
    }
    return -1;
  }

  // Searches for a user by email or phone number
  static int Find_User_Email_OR_Phone(String value) {
    for (int i = 0; i < userCount; i++) {
      if (Emails[i] != null && Emails[i].equalsIgnoreCase(value)
          || phone_numbers[i] != null && phone_numbers[i].equals(value)) {
        return i;
      }
    }
    return -1;
  }

  // Prompts the admin to enter a User ID, username, email, or phone number
  static int Find_User_From_Prompt() {
    System.out.print("Enter user ID, username, email, or phone: ");
    System.out.println();
    String User = input.nextLine();
    int index = Find_User_By_id(User);

    if (index == -1) {
      index = Find_User_By_Name(User);
    }

    if (index == -1) {
      index = Find_User_Email_OR_Phone(User);
    }
    return index;
  }

  // Displays all information
  static void printUser(int index) {
    System.out.println("User ID: " + ids[index]);
    System.out.println("Username: " + usernames[index]);
    System.out.println("Email: " + Emails[index]);
    System.out.println("Phone: " + phone_numbers[index]);
    System.out.println("Balance: " + (double) balance[index] / 100 + " EGP");
    System.out.println("Account Status: " + account_status[index]);
    System.out.println();
  }

  static void updateUser() {
    int index = Find_User_From_Prompt();

    if (index == -1) {
      System.out.println("User not found.");
      return;
    }

    System.out.print("Enter new username (or press Enter to skip): ");
    String New_Name = input.nextLine();

    System.out.print("Enter new email (or press Enter to skip): ");
    String New_Email = input.nextLine();

    System.out.print("Enter new phone (or press Enter to skip): ");
    String New_Phone = input.nextLine();

    if (!New_Name.isEmpty()) {
      usernames[index] = New_Name;
    }

    if (!New_Email.isEmpty()) {
      int Check_Index = Find_User_Email_OR_Phone(New_Email);

      if (Check_Index == -1 || Check_Index == index) {
        Emails[index] = New_Email;
      } else {
        System.out.println("Email already used; unchanged.");
      }
    }

    if (!New_Phone.isEmpty()) {
      int Check_Index = Find_User_Email_OR_Phone(New_Phone);

      if (Check_Index == -1 || Check_Index == index) {
        phone_numbers[index] = New_Phone;
      } else {
        System.out.println("Phone already used; unchanged.");
      }
    }

    System.out.println("User update finished.");
    printUser(index);
    System.out.println();
  }

  // Displays all registered users
  static void viewAllUsers() {
    if (userCount == 0) {
      System.out.println("No users found.");
      return;
    }

    for (int i = 0; i < userCount; i++) {
      System.out.println("========================================================");
      printUser(i);
    }
  }

  // Reactivates a blocked account
  static void BlockAccount() {
    int index = Find_User_From_Prompt();

    if (index == -1) {
      System.out.println("User not found.");
      return;
    }

    if (account_status[index].equals("Blocked")) {
      System.out.println("Account is already blocked.");
      return;
    }

    account_status[index] = "Blocked";
    System.out.println("Account blocked successfully.");
  }

  static void unblockAccount() {
    int index = Find_User_From_Prompt();

    if (index == -1) {
      System.out.println("User not found.");
      return;
    }

    if (account_status[index].equalsIgnoreCase("ACTIVE")) {
      System.out.println("Account is already active.");
      return;
    }

    account_status[index] = "ACTIVE";
    System.out.println("Account unblocked successfully.");
  }

  // Displays the details of a selected user
  static void viewUserDetails() {
    int index = Find_User_From_Prompt();

    if (index == -1) {
      System.out.println("User not found.");
      return;
    }

    System.out.println("=== USER DETAILS ===");
    printUser(index);
  }

  // method to transfer money from user to another user using phone number
  static void transferMoney(int senderIndex) {
    if (totaltransactions >= 100) {
      System.out.println("System transactions log is full. Cannot process transfer.");
      System.out.println();
      return;
    }
    System.out.println("--- Transfer Money ---");
    System.out.print("Enter receiver's phone number: ");
    String receiverInput = input.next();
    int receiverIndex = -1;

    for (int i = 0; i < phone_numbers.length; i++) {
      if (phone_numbers[i] != null && phone_numbers[i].equals(receiverInput)) {
        receiverIndex = i;
        break;
      }
    }
    if (receiverIndex == -1) {
      System.out.println("receiver not found ");
      System.out.println();
      return;
    }
    if (receiverIndex == senderIndex) {
      System.out.println("You can't transfer money to yourself.");
      System.out.println();
      return;
    }
    if (account_status[receiverIndex] != null && account_status[receiverIndex].equalsIgnoreCase("Blocked")) {
      System.out.println("Transaction declined: Reciever account is blocked.");
      System.out.println();
      return;
    }
    System.out.print("Enter amount: ");
    double amount = input.nextDouble();
    input.nextLine();

    if (amount <= 0) {
      System.out.println("Amount must be greater than zero ");
      System.out.println();
      return;
    }
    long amountaslong = (long) (amount * 100);
    if (balance[senderIndex] < amountaslong) {
      System.out.println("declined transaction: Insufficient balance");
      System.out.println();
      transaction_senders[totaltransactions] = usernames[senderIndex];
      transaction_receivers[totaltransactions] = usernames[receiverIndex];
      amounts[totaltransactions] = amountaslong;
      transaction_status[totaltransactions] = "Declined";
      totaltransactions++;
      return;
    } else {
      balance[senderIndex] -= amountaslong;
      balance[receiverIndex] += amountaslong;
      System.out.println(" approved transaction " + amount + " is transfered successufully ");
      System.out.println();
      transaction_senders[totaltransactions] = usernames[senderIndex];
      transaction_receivers[totaltransactions] = usernames[receiverIndex];
      amounts[totaltransactions] = amountaslong;
      transaction_status[totaltransactions] = "Approved";
      totaltransactions++;
    }
  }

  // method to display transaction history
  static void TransactionHistory(String currentUsername) {
    System.out.println("--- Transaction History ---");

    if (totaltransactions == 0) {
      System.out.println("There is no transactions found ");
      System.out.println();
      return;
    }
    boolean found = false;
    for (int i = 0; i < totaltransactions; i++) {
      if ((transaction_senders[i] != null && transaction_senders[i].equalsIgnoreCase(currentUsername))
          || (transaction_receivers[i] != null && transaction_receivers[i].equalsIgnoreCase(currentUsername))) {
        System.out.println("Transaction " + (i + 1) + ":");
        System.out.println("Sender username: " + transaction_senders[i]);
        System.out.println("Receiver username: " + transaction_receivers[i]);
        System.out.println("Amount: " + (double) amounts[i] / 100 + " EGP");
        System.out.println("Status: " + transaction_status[i]);
        System.out.println();
        found = true;
      }
    }
    if (!found)
      System.out.println("There is no transaction history for this account.");
  }

  // method to search for a recipient by phone number
  static void searchRecipient() {
    System.out.println("--- Search Recipient ---");
    System.out.print("Enter recipient's phone number: ");

    String phonenumber = input.next();
    int searchindex = -1;

    for (int i = 0; i < phone_numbers.length; i++) {
      if (phone_numbers[i] != null && phone_numbers[i].equals(phonenumber)) {
        searchindex = i;
        break;
      }
    }
    if (searchindex >= 0) {
      System.out.println("Recipient Found");
      System.out.println("Username: " + usernames[searchindex]);
      System.out.println("Phone: " + phone_numbers[searchindex]);
      System.out.println();
    } else {
      System.out.println("No user found with this PhoneNumber.");
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
    String[] account_status_store = { "Active", "Blocked", "Blocked", "Active", "Active", "Blocked" };
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
            input.nextLine();
            switch (y) {
              case 1: // Show Statistics
                showstatistics();
                break;
              case 2:
                SearchUser();
                break;

              case 3:
                viewusers();
                break;

              case 4:
                updateUser();
                break;

              case 5:// Transaction History
                transactionhistory();
                break;
              case 6:
                BlockAccount();
                break;

              case 7:
                unblockAccount();
                break;

              case 8:
                viewUserDetails();
                break;

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
              if (SignUp(newEmail, newPassword, newPhonenumber, newUserName))
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
                int senderindex = -1;
                for (int i = 0; i < Emails.length; i++) {
                  if (Emails[i] != null && Emails[i].equalsIgnoreCase(currentemail)) {
                    senderindex = i;
                    break;
                  }
                }
                if (senderindex != -1) {
                  transferMoney(senderindex);
                }
                break;
              case 3: // Transaction History
                String loggedInUser = "";
                for (int i = 0; i < Emails.length; i++) {
                  if (Emails[i] != null && Emails[i].equalsIgnoreCase(currentemail)) {
                    loggedInUser = usernames[i];
                    break;
                  }
                }
                TransactionHistory(loggedInUser);
                break;
              case 4: // Show Favorites
                showfav();
                break;
              case 5: // Add Favorites
                addfav();
                break;
              case 6: // Remove Favorites
                removefav();
                break;
              case 7: // Search Recipient
                searchRecipient();
                break;
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
  // the following is made by Hla
  // Admin panel

  static void showstatistics() {
    int totalusers = userCount;
    String[] status = { "Active", "Active", "Blocked", "Active", "Blocked", "Active" };
    int active = 0;
    int blocked = 0;
    for (int i = 0; i < status.length; i++) {
      if (status[i].equals("Active")) {
        active++;
      } else if (status[i].equals("Blocked")) {
        blocked++;
      }
    }
    String[] transactionstatus = { "SUCCESS", "FAILED", "SUCCESS", "SUCCESS", "FAILED", "FAILED" };
    double[] transactionamount = { 1000, 5600, 300, 1870, 2500, 200 };
    int successful = 0;
    int failed = 0;
    double totaltransfers = 0;
    for (int i = 0; i < transactionstatus.length; i++) {
      if (transactionstatus[i].equals("SUCCESS")) {
        successful++;
        totaltransfers += transactionamount[i];
      } else if (transactionstatus[i].equals("FAILED")) {
        failed++;
      }
    }
    System.out.println("=========ADMIN STATISTICS=========");
    System.out.println("Total number of registered users : " + totalusers);
    System.out.println("Active users : " + active);
    System.out.println("Blocked users : " + blocked);
    System.out.println("Successful Transactions : " + successful);
    System.out.println("Failed Transactions : " + failed);
    System.out.println("Total successful Transfers : " + totaltransfers);
  }

  static void viewusers() {
    System.out.println("=========ALL USERS=========");
    for (int i = 0; i < userCount; i++) {
      System.out.println("Username :" + usernames[i]);
      System.out.println("User ID :" + ids[i]);
      System.out.println("Email address :" + Emails[i]);
      System.out.println("Phone number :" + phone_numbers[i]);
      System.out.println("Current Balance :" + balance[i]);
      System.out.println("User Status: " + account_status[i]);
    }
  }

  static String[] transactionids = { "TR-001", "TR-002", "TR-003", "TR-004", "TR-005", "TR-006" };
  static String[] senders = { "ahmed012", "amr_78", "joe818", "aly72", "hesham98", "abdo88" };
  static String[] receivers = { "amr_78", "joe818", "aly72", "hesham98", "abdo88", "ahmed012" };
  static String[] transactionstatus = { "Successful", "Successful", "Failed", "Successful", "Successful",
      "Successful" };

  static void transactionhistory() {
    if (totaltransactions == 0) {
      System.out.println("No transactions found!");
      return;
    }
    System.out.println("=========ALL TRANSACTIONS=========");
    for (int i = 0; i < totaltransactions; i++) {
      System.out.println("Transaction ID : " + transactionids[i]);
      System.out.println("Transaction Sender : " + senders[i]);
      System.out.println("Transaction Receiver : " + receivers[i]);
      System.out.println("Transaction Status : " + transactionstatus[i]);
    }

    // user panel
  }

  static String[] favourits = new String[10];
  static int countfav = 0;

  static void addfav() {
    System.out.println("=========ADD FAVOURITES=========");
    if (countfav >= 10) {
      System.out.println("Your Favourites list is completely filled !");
      return;
    }

    System.out.println("Enter the username to add to your favourites list : ");
    String name = input.nextLine();

    for (int i = 0; i < countfav; i++) {
      if (favourits[i].equals(name)) {
        System.out.println("This username is already in your favourites list ! ");
        return;
      }
    }
    favourits[countfav] = name;
    countfav++;
    System.out.println(name + " Is Successfully added to your favourits list !");
  }

  static void removefav() {
    System.out.println("=========REMOVE FAVOURITES=========");
    if (countfav == 0) {
      System.out.println("There is no Favourites to remove !");
      return;
    }
    System.out.println("Enter the username to remove from your favourits list : ");
    String name = input.nextLine();
    boolean found = false;
    int remove = -1;
    for (int i = 0; i < countfav; i++) {
      if (favourits[i].equalsIgnoreCase(name)) {
        remove = i;
        found = true;
        break;
      }
    }
  }

  static void showfav() {
    System.out.println("=========YOUR FAVOURITES=========");
    if (countfav == 0) {
      System.out.println("There is no favourites to show !");
      return;
    }
    for (int i = 0; i < countfav; i++) {
      System.out.println((i + 1) + favourits[i]);
    }
  }
  //
}
