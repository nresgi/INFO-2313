// Imports the scanner 
import java.util.Scanner;
/* Adriel Adasa
INFO 2313
Simily Joseph
13/10/23 */
public class adriel_password_check{
    // Instantiate the scanner for reading in user input
    static Scanner input = new Scanner(System.in);
    public static void main(String args[])
    {
        // Instantiate the password to the result of a call to the getPassword() function
        String password = getPassword();
        // Checks if the password entered is valid based on the return of the isPasswordValid(password) function call
        // Prints out if the password is valid or invalid
        if(isPasswordValid(password))
        {
            System.out.print("Valid Password");
        }
        else
        {
            System.out.print("Invalid Password");
        }
    }

    // Function to get the user input for password
    static String getPassword()
    {
        // Asks for the input
        System.out.println("Enter a password: ");

        // Assigns the string password to the entered password
        String password = input.nextLine();
        // Returns the password as a string as the call in main will assign the password to it's own variable for password
        return password;
    }

    // Function to check if the password is valid by testing all three conditions to pass
    static boolean isPasswordValid(String password)
    {
        // Instantiates the min password length and min digits for the password to be valid
        int passLength = 10;
        int minDigits = 3;

        // Assigns a boolean to the result of the three checks the password has to pass
        boolean isValid = ((password.length() >= passLength) && isOnlyLettersAndDigits(password) && hasMinDigits(password, minDigits));
        // Returns true if the password is valid else it will return false
        return isValid;
    }

    // Function to check if the password is made of only letters and digits
    static boolean isOnlyLettersAndDigits(String password)
    {
        // Checks each character in the string 
        for(int i = 0; i < password.length(); i++)
        {
            // If any character in the string is not a letter or digit then return false
            if(!Character.isLetterOrDigit(password.charAt(i)))
            {
                return false;
            }
        }
        // If no characters fail the check then it must only have letters and digits
        return true;
    }

    // Function to check if the password has the minimum number of digits required
    static boolean hasMinDigits(String password, int x)
    {
        // Instantiates the number of digits in the password
        int digits = 0;
        // Checks each character in the password
        for(int i = 0; i < password.length(); i++)
        {
            // Increments the number of digits found in the password
            if(Character.isDigit(password.charAt(i)))
                digits++;
            // Stops the loop once enough digits are found in the password by returning true this will lower run time
            if(digits >= x)
                return true;
        }
        // If the loop never returns true then it must not have enough digits
        return false;
    }
}