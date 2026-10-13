import java.util.*;
public class FinalProject {

static Scanner input = new Scanner(System.in);
static int[] ids = {753489, 992931, 758737, 333943, 841524, 395337};
static String [] usernames = {"ahmed012", "amr_78", "joe818", "aly72", "hesham98","abdo88" };
static String [] Emails = {"ahmed_mohamed@gmail.com", "amr_youssed@gmail.com","joe_yasser@gmail.com", "aly_osama@gmail.com", "hesham_ahmed@gmail.com", "abdelrahman_yasser@gmail.com"};
static String [] phone_numbers = { "01036794460","01182173694", "01266433666", "01267049359", "01528060153", "01245151486" };
static String [] passwords = {"Ahmed#2026!", "Amr_7890$", "JoePass@99", "Aly!Secret12", "Hesham#456*", "Abdo_2026#"};
static int[] balance = {15960, 2600, 1500, 8850, 26900, 10000};
static String [] account_status = {};





    public static void main(String[] args) {
    
      System.out.println("========== QUICK PAY ==========");
      System.out.println("1. Login as Admin");
      System.out.println("2. Login as User");
      System.out.println("3. Exit");
      System.out.print("Choose an option: ");
      int x = input.nextInt();
      System.out.println();
      switch (x) {
        case 1:
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
            case 1:
              
            case 2:

            case 3:

            case 4:

            case 5:

            case 6:

            case 7:

            case 8:

            case 9:


          
            default:
              break;
          }

        case 2:
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
            case 1:
              
            case 2:

            case 3:

            case 4:

            case 5:

            case 6:

            case 7:

            case 8:

            case 9:

            case 10:            
          
            default:
              break;
          }
          case 3:
          System.out.println("Thank you for using our app");
          break;



        default:
          break;
      }
      


      input.close();
    }
}
