import java.util.Scanner;
public class lab2
{
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        //calculateTips();
        //computingBMI();
        //hiIntegers();
        sortIntegers();
    }

    static void calculateTips()
    {
        // Read in the subtotal and gratuity rate
        System.out.println("Enter the subtotal: ");
        double subtotal = input.nextDouble();
        System.out.println("Enter the gratuity rate: ");
        double gratuityRate = input.nextDouble();

        // Calculate the gratuity by multiplying it by the subtotal but also dividing by 100 to convert it from percentage 
        double gratuity = gratuityRate * subtotal / 100;
        double total = gratuity + subtotal;

        // Displays the gratuity along with the total
        System.out.println("Gratuity: $" + gratuity);
        System.out.println("Total: $" + total);
    }

    static void computingBMI()
    {
        // Reads in the weight in pounds and heights in inches
        System.out.println("Enter weight in pounds: ");
        double weightInPounds = input.nextDouble();
        System.out.println("Enter height in feet followed by inches: ");
        // Converts the feet into inches
        int feet = input.nextInt() * 12;
        // Adds on the feet in inches to the "leftover" inches to get total height
        double heightInInches = input.nextDouble() + feet;
        
        // Converts weight and height into metric measurements
        double weightInKg = weightInPounds * 0.45359237;
        double heightInMeters = heightInInches * 0.0254;
        // Calculates the bmi by dividing the weight by the root of the height
        double bmi = weightInKg / heightInMeters / heightInMeters;
        // Displays the bmi with 2 decimal spaces
        System.out.println("BMI: " + String.format("double : %.2f", bmi));
    }

    static void hiIntegers()
    {
        // Read in the users integer
        System.out.println("Enter an integer: ");
        int integer = input.nextInt();

        // If the input is cleanly divisible by 5 then displays HiFive
        if(integer % 5 == 0)
            System.out.println("HiFive");

        // If the input is clearnly divisible by 2 then displays HiEven
        if(integer % 2 == 0)
            System.out.println("HiEven");

    }

    static void sortIntegers()
    {
        // Instantiates the ranking of the ints
        int highest, middle, lowest;
        // Reads in the first two ints
        System.out.println("Enter integer 1: ");
        int int1 = input.nextInt();
        System.out.println("Enter integer 2: ");
        int int2 = input.nextInt();
        // Assigns highest to the int that is greater than the other
        // Also assigns lowest to the other int
        if(int1 > int2)
        {
            highest = int1;
            lowest = int2;
        }
        else
        {
            highest = int2;
            lowest = int1;
        }
        // Reads in the final int
        System.out.println("Enter integer 3: ");
        int int3 = input.nextInt();
        // If int3 is greater than the current highest it is now the highest and the previous highest is now the middle
        if(int3 > highest)
        {    
            middle = highest;
            highest = int3;
        }
        // If int3 is lower than the current lowest it is now the lowest and the previous lowest is now the middle
        else if(int3 < lowest)
        {    
            middle = lowest;
            lowest = int3;
        }
        // If int3 is not higher than the greatest nor less than the lowest then it can only be the middle
        // No need to re-assign the others as they are already in the correct spots
        else
        {    
            middle = int3;
        }

        // Display the given ints in increasing order
        System.out.println(lowest + " " + middle + " " + highest);
    }
}