// Imports the scanner
import java.util.Scanner;
/* Adriel Adasa
INFO 2313
Simily Joseph
13/10/23 */
public class adriel_string_permutation {
    // Instantiate the input scanner 
    static Scanner input = new Scanner(System.in);
    public static void main(String args[])
    {
        // Ask the user to input a string and read it in
        System.out.print("Enter a string: ");
        String s = input.nextLine();

        System.out.println("The permutations are ");
        // Calls the function to display all the permutations
        displayPermutation(s);
    }

    // Function to display the permutation of a singular string
    public static void displayPermutation(String s)
    {
        // Calls the other displayPermutation function with the first string being a blank and second string being the string it started with to start
        // Initiates the permutation process
        displayPermutation("", s);
    }

    // Function to display the permutation with two string inputs
    public static void displayPermutation(String s1, String s2)
    {
        // This is the base case
        // When all of s2 is moved to s1 then print out the permutation
        if(s2.length() == 0)
        {
            System.out.println(s1);
        }
        // If length of s2 is not zero then continue the function call
        else
        {
            // s1 is the current permutation being constructed
            // With each call s2 will be appended to s1
            // Once s2 is empty then the if statement above will occur, when this happens it will switch to the next character by backtracking
            for(int i = 0; i < s2.length(); i++)
            {
                displayPermutation(s1 + s2.charAt(i), s2.substring(0, i) + s2.substring(i + 1));
            }
        }
    }
}
