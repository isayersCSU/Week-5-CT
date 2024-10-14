package temptracker;

import java.util.Scanner;

public class TempTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

// Sample monthly average temperatures
        
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        double[] temperatures = {32, 35, 42, 55, 68, 75, 80, 78, 65, 50, 40, 35};

        System.out.print("Enter a month or 'Year' to view data: ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("Year")) {

// Calculate yearly average, highest, and lowest
            double total = 0;
            double highest = Double.MIN_VALUE;
            double lowest = Double.MAX_VALUE;

            for (double temp : temperatures) {
                total += temp;
                highest = Math.max(highest, temp);
                lowest = Math.min(lowest, temp);
            }

            double average = total / months.length;

// Print yearly data
            System.out.println("Yearly Average Temperature: " + average);
            System.out.println("Highest Temperature: " + highest);
            System.out.println("Lowest Temperature: " + lowest);

// Print monthly data
            for (int i = 0; i < months.length; i++) {
                System.out.println(months[i] + ": " + temperatures[i]);
            }
        } else {
// Find the index of the entered month, correct for case sensitivity
            int index = -1;
            for (int i = 0; i < months.length; i++) {
                if (input.equalsIgnoreCase(months[i])) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
// Print the temperature for the specified month
                System.out.println(months[index] + ": " + temperatures[index]);
            } else {
                System.out.println("Invalid month entered.");
            }
        }
    }
}