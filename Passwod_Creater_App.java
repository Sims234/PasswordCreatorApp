package Projects;

import java.util.Random;
import java.util.Scanner;

public class Passwod_Creater_App {

    public static void main(String[] args) {
        // Call the intro function to display the purpose of the program
        intro();
        
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for a string that will be used to create a password
        System.out.print("\nEnter a sentence to create a password: ");
        String sentence = scanner.nextLine();
        
        // Generate the password
        String password = createPassword(sentence);
        
        // Display the correct password to the user with a random 4-digit number
        System.out.println("Your new password is: " + password);
        
        // Close the scanner
        scanner.close();
    }

    // display the purpose of the program
    public static void intro() {
        System.out.println("Welcome to the Password Creator Program!");
        System.out.println("\nThis program will create a password based on the sentence you provide.");
        System.out.println("The password will consist of the first letter of each word in the sentence,");
        System.out.println("followed by a random 4-digit number. The password will also include at least one uppercase");
        System.out.println("and one lowercase letter.");
    }

    // Function to create the password
    public static String createPassword(String sentence) {
        // Split the sentence into words
        String[] words = sentence.split("\\s+");
        
        // Initialize an empty StringBuilder for the password
        StringBuilder passwordBuilder = new StringBuilder();
        
        // Append the first letter of each word
        for (String word : words) {
            if (word.length() > 0) {
                passwordBuilder.append(word.charAt(0));
            }
        }
        
        // Ensure at least one uppercase and one lowercase letter
        String password = passwordBuilder.toString();
        if (!password.matches(".*[a-z].*")) {
            password += "a"; // Add lowercase letter if missing
        }
        if (!password.matches(".*[A-Z].*")) {
            password += "A"; // Add uppercase letter if missing
        }
        
        // Generate a random 4-digit number
        Random random = new Random();
        int randomNumber = random.nextInt(9000) + 1000; // Random number between 1000 and 9999
        
        // Append the random number to the password
        password += randomNumber;
        
        return password;
    }
}

