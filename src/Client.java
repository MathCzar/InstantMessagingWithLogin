import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Client {

    //imports the scanner
    Scanner scanner = new Scanner(System.in);

    public Client() {

        //creates a variable important to logging in
        boolean loginPass;

        loginPass = false;

        while (!loginPass) {

            //creates a variable to tell if the user has answered the question correctly
            String hasUsernameAnswer;
            String passwordAnswer;
            String usernameAnswer;

            System.out.println("Do you already have an account with us? (y/n)");
            hasUsernameAnswer = scanner.nextLine();

            if (hasUsernameAnswer.equals("y")) {

                try {

                    //asks the user what there password is
                    System.out.println("What is your username? (Type 'back' to go back)");
                    usernameAnswer = scanner.nextLine();
                    //if the string is called "back", then the process will ask the user if they have an account or not
                    if(usernameAnswer.equals("back")) {

                        continue;

                    }
                    else {

                        System.out.println("What is your password? (Type 'back' to go back)");
                        passwordAnswer = scanner.nextLine();

                        if(usernameAnswer.equals("back")) {

                            continue;

                        }
                        else {



                        }

                    }


                    BufferedReader reader = new BufferedReader(new FileReader(usernameAnswer + passwordAnswer + ".txt"));
                } catch (FileNotFoundException e) { loginPass = false; }

                loginPass = true;

            } else if (hasUsernameAnswer.equals("n")) {

                try {

                    String userAnswer = scanner.nextLine();

                    BufferedReader reader = new BufferedReader(new FileReader(userAnswer + ".txt"));
                    loginPass = true;
                } catch (FileNotFoundException e) { loginPass = false; }



            } else {

                System.out.println("That is not an answer");

            }
        }

    }

}
