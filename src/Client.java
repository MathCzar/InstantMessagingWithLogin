import java.io.*;
import java.util.Scanner;

public class Client {

    //imports the scanner
    Scanner scanner = new Scanner(System.in);

    public Client() {

        //creates a variable important to logging in
        boolean loginPass;

        loginPass = false;

        while (!loginPass) {

            //creates a variables to tell if the user has answered the question correctly
            String hasUsernameAnswer;

            //variables to the questions about login information
            String passwordAnswer;
            String usernameAnswer;

            //asks the user if they already have an account with the email company
            System.out.println("Do you already have an account with us? (y/n)");
            hasUsernameAnswer = scanner.nextLine();

            //checks to see if the answer is "y"
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

                        //checks to see if the user wants to go back
                        if(usernameAnswer.equals("back")) {

                            continue;

                        }
                        else {


                            try {
                                //checks if the file is already there
                                BufferedReader reader = new BufferedReader(new FileReader(usernameAnswer + passwordAnswer + ".txt"));

                                //if the file is there the file will not be creates again
                                System.out.println("Your username is already taken!");
                            } catch (IOException e) {
                                //if the file is not there it creates the file
                                FileWriter fw = new FileWriter(usernameAnswer + passwordAnswer + ".txt");
                                fw.close();
                                System.out.println("You have registered successfully!");
                                loginPass = true;
                            }



                        }

                    }

                } catch (IOException e) { loginPass = false; }

            }
            //checks to see if the answer is "n"
            else if (hasUsernameAnswer.equals("n")) {

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

                                loginPass = true;

                            }

                        }

                    BufferedReader reader = new BufferedReader(new FileReader(usernameAnswer + passwordAnswer + ".txt"));

                } catch (FileNotFoundException e) { loginPass = false; }



            }
            //loops back and asks the user again if they have an account
            else {

                System.out.println("That is not an answer.");

            }
        }

    }

}
