package basics;

/*
 * Sum from a lowerbound to an upperbound using a while-loop
 */
public class RunningNumberSum {  // Save as "RunningNumberSum.java"
    public static void main(String[] args) {
        int lowerbound = 1;      // Store the lowerbound
        int upperbound = 1000;   // Store the upperbound
        int sum =0, sum2 = 0;   // Declare an int variable "sum" to accumulate the numbers
        // Set the initial sum to 0
        // Use a while-loop to repeatedly sum from the lowerbound to the upperbound
        int number = lowerbound;
        while (number <= upperbound) {
            sum += number;  // Accumulate number into sum
            ++number;            // Next number
        }
        // Print the result
        System.out.println("The sum from " + lowerbound + " to " + upperbound + " is " + sum);

        for (int number2 = lowerbound; number2 <= upperbound; ++number2) {
            sum2 += number2;  // Accumulate number into sum
        }
        // Print the result
        System.out.println("The sum from " + lowerbound + " to " + upperbound + " is " + sum2);

    }
}