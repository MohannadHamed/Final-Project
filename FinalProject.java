import java.util.*;
public class FinalProject {

static Scanner input = new Scanner(System.in);

       static String[] questions = {
        "What is java?",
        "Which keyword is used to create class?" ,
        "Which loop run atleast once? "};

       static String[][] choices = {
        {"A) Programming language",
         "B) Datahase",
         "C) Browser",
         "D) Operating systems"
        },
        {"A) Function",
         "B) Class",
         "C) New",
         "D) Object"
        },
        {"A) For",
         "B) While",
         "C) do-while",
         "D) for-each"
        }
       };
       static String[] answers ={"A", "B", "C"};
       static String answer = "";
       static int score = 0;



       static void printquestions ()
       {

        for(int i = 0; i < questions.length; i++)
        {
                System.out.println("Question " + (i + 1) + ": " + questions[i] + "\n");
                for(int j = 0; j <= choices.length;j++)
                {
                 System.out.println(choices[i][j]);
                }
                System.out.print("\nEnter your answer: ");
                answer = input.next();
                takeanswer(answer, i);
                System.out.println("----------------------------------\n");
        }
       }




       static void takeanswer(String a, int i)
       {

                    if(a.equalsIgnoreCase(answers[i]))
                    {
                        System.out.println("\nCorrect answer.");
                        score++;
                        System.out.println("Your score is " + score + "/3");
                    }
                    else
                    {
                        System.out.println("Wrong answer.");
                        System.out.println("Your score is " + score + "/3");

                    }
       }



    public static void main(String[] args) {

      
      

System.out.println("Welcome to the Java quiz game.");
        System.out.println("To start press [1]");
        System.out.println("To exit press [0]");
        System.out.print("Enter your choice: ");
        int x = input.nextInt();
        switch (x) {
            case 0:
                System.out.println("Thank you for playing.");
                break;
        
            case 1:
                while (true) {
                    printquestions();
                    System.out.println("Do you want to play again? (Yes/no)");
                    String Retry = input.next();
                    if(Retry.equalsIgnoreCase("Yes"))
                    {
                        score = 0;
                        continue;
                    }
                    else
                    {
                        System.out.println("\nThank you for playing.");
                        break;
                    }
                }

        }


      input.close();
    }
}
