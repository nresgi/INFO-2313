import java.util.Scanner;
public class lab3
{
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        //System.out.println(leapYear());
        //cityComparison();
        //convertHexadecimal();
        //intSum();
        integersFactor();
    }

    /* Adriel Adasa
    INFO 2313 
    Simily Joseph
    Sep 27, 2023
    Checks whether the year the user enters is a leap year
    Uses conditional operators */
    static boolean leapYear()
    {
        // Read in the desired year to check
        System.out.println("Enter the year to check: ");
        int year = input.nextInt();
        // Instantiate the boolean to return
        boolean returnval;
        // Returns true if the year is divisible by 4, does not end in x000 or it does end in x400
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
        {
            returnval = true;
        }
        else
        {
            returnval = false;
        }
        // Alternate method of returning
        // return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
        return returnval;
    }

    /* Adriel Adasa
    INFO 2313 
    Simily Joseph
    Sep 27, 2023
    Displays two cities entered by a user in alphabetical order
    Uses conditional operators and string class methods */
    static void cityComparison()
    {
        // Read in each city
        System.out.println("Enter the first city: ");
        String city1 = input.nextLine();
        System.out.println("Enter the second city: ");
        String city2 = input.nextLine();

        // If the value of city1 is larger than city2 then print city1 first
        // Makes both lowercase so capitalization does not affect order
        if(city1.toLowerCase().compareTo(city2.toLowerCase()) < 0)
        {
            System.out.println(city1 + " " + city2);
        }
        // If city1 is not larger than city2 then city2 is printed first
        else
        {
            System.out.println(city2 + " " + city1);
        }
    }

    /* Adriel Adasa
    INFO 2313 
    Simily Joseph
    Sep 27, 2023
    Converts a hexadecimal value to decimal
    Uses chars and its class methods. Also uses recursion if needed */
    static void convertHexadecimal()
    {
        System.out.println("Enter the hexadecimal to be converted: ");
        String hexa = input.nextLine();

        // Check if the hex string has exactly one character
        if (hexa.length() != 1) 
        {
            System.out.println("You must enter exactly one character");
            return;
        }
        
        // Display decimal value for the hex digit
        // Convert the entered value to uppercase so that it will have the same value if a lowercase value was entered
        char ch = Character.toUpperCase(hexa.charAt(0));
        if ('A' <= ch && ch <= 'F') 
        {
            int value = ch - 'A' + 10;
            System.out.println("The decimal value for hex digit " 
            + ch + " is " + value);
        }
        else if (Character.isDigit(ch)) 
        {
            // Displays the hexadecimal as it is if it is already a digit
            System.out.println("The decimal value for hex digit " 
            + ch + " is " + ch);
        }
        else 
        {
            // If the entered value is not in the format of a hexadecimal then re-call method to re-do
            System.out.println(ch + " is an invalid input");
            System.out.println("Try again");
            convertHexadecimal();
        }
    }

    /* Adriel Adasa
    INFO 2313 
    Simily Joseph
    Sep 27, 2023
    Calculates the sum of a number of unspecified integers
    Uses while loop */
    static void intSum()
    {
        // Instantialize the total as 0 then read in the first int to be summed
        int total = 0;
        System.out.println("Enter int: ");
        int x = input.nextInt();
        total += x;
        // While the entered value is not 0 continue adding the value to the total
        while(x != 0)
        {
            System.out.println("Enter int: ");
            x = input.nextInt();
            total += x;
        }
        // Display the total sum
        System.out.println("The total of all ints is " + total);
    }

    /* Adriel Adasa
    INFO 2313 
    Simily Joseph
    Sep 27, 2023
    Displays the factors of an integer in increasing order
    Uses while loop and conditional statements */
    static void integersFactor()
    {
        // Read in the integer 
        System.out.println("Enter an integer: ");
        int val = input.nextInt();
        // The value that will be acting as a factor
        int x = 2;

        // Keep checking for factors while the value given is not equal to the value of the factor
        while(val / x != 1)
        {
            // If the integer is cleanly divisible by the factor then print out the factor and divide the integer
            if(val % x == 0)
            {
                System.out.print(x + ", ");
                val /= x;
            }
            // If the number is not a factor then increase of the value of the factor
            else
            {
                x++;
            }
        }
        System.out.println(val + ".");
    }
}