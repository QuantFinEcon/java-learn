package basics;

/*
 * Print the area and circumference of a circle, given its radius.
*/
public class CircleComputation {  // Saved as "CircleComputation.java"
    public static void main(String[] args) {
        // Declare double (real-number) variables to hold radius, area and circumference
        double radius, area, circumference;
        // Declare a constant for PI
        final double PI = 3.14159265;

        // Assign a value to radius
        radius = 1.2;
        // Compute area and circumference
        area = radius * radius * PI;
        circumference = 2.0 * radius * PI;

        // Print results
        System.out.print("The radius is ");  // Print description
        System.out.println(radius);          // Print the value stored in the variable
        System.out.print("The area is ");
        System.out.println(area);
        System.out.print("The circumference is ");
        System.out.println(circumference);
    }
}