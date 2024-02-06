import java.util.Scanner;
public class Main
{
    /* Adriel Adasa
    INFO 2313
    Simily Joseph
    18/09/23
    Lab 1 
    All exercises in one program because I did not want to create multiple files*/
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        // calls the circle function
       //circle();
       //speed();
       //computeExpression();
       populationProjection();
       //check();
    }

    // displays the area and perimeter of a circle
    public static void circle()
    {
        // Assign  radius variable
        double radius = 6.5;
        // Assign pi, perimeter, and area to their respective variables
        // Using MATH.PI as it is much more accurate than just using 3.14159
        double perimeter = 2 * radius * Math.PI;
        double area = radius * radius * Math.PI;
        // Print out both perimeter and area on their own lines
        System.out.println("Perimeter: " + perimeter);
        System.out.println("Area: " + area);
    }

    public static void speed()
    {
        /* 24 miles
        1 hour 40 mins 35 seconds
        1 mile = 1.6 km
        display average speed km/hour*/

        // Instantiate miles to 24
        double miles = 24;
        // Convert the time into hours
        double time = 1 + (40.0 / 60)  +  (35.0 / 3600);
        // Convert the miles to kilometers by multiplying miles by 1.60934
        double km = miles * 1.60934;
        // Obtain the average speeds in their respective units by dividing the distance by time
        double avgMiles = miles / time;
        double avgKm = km / time;

        // Displays the average speeds
        System.out.println("Average speed in miles: " + avgMiles);
        System.out.println("Average speed in kilometers: " + avgKm);
    }

    public static void computeExpression()
    {
        // Calculate the top and bottom separately then divide as the final step
        System.out.println((7.5 * 6.5 - 4.5 * 3) / (47.5 - 5.5));
    }

    public static void populationProjection()
    {
        /* one birth every 7 seconds
        one death every 13 seconds
        one new immigrant every 45 seconds
        curr population = 312 032 486
        one year = 365 displaysdisplay population for each of the next 5 years */
        
        // Instantiates current population
        double currPopulation = 312032486;
        // Converts year to seconds by multiplying days by hours then by minutes then by seconds
        double secondsInAYear = 365 * 24 * 60 * 60;
        // Calulates birth, death, and immigration rates by dividing seconds in a year by the rate of growth or decline of each
        double birthRate = secondsInAYear / 7.0;
        double deathRate = secondsInAYear / 13.0;
        double immigrationRate = secondsInAYear / 45.0;

        // Calulates population for the next 5 years
        for(int i = 1; i <= 5; i++)
        {
            // Add the births and immigrants each year subtracted by the deaths 
            currPopulation += birthRate - deathRate + immigrationRate;
            // display the population of each year
            System.out.println("Year " + i + ": " + (int)currPopulation);
        }
    }

    public static void check(){
    double birthRateInSeconds = 7.0;
        double deathRateInSeconds = 13.0;
        double newImmigrantInSeconds = 45.0;



        double currentPopulation = 312032486;

        double secondsInYears = 60 * 60 * 24 * 365;

        double numBirths = secondsInYears / birthRateInSeconds;
        double numDeaths = secondsInYears / deathRateInSeconds;
        double numImmigrants = secondsInYears / newImmigrantInSeconds;

        for (int i = 1; i <= 5; i++) {
            currentPopulation += numBirths + numImmigrants - numDeaths;
            System.out.println("Year " + i + " = " + (int)currentPopulation);

        }}
}