import java.util.Scanner;

public class ComputeFactorialTailRecursion {
    /** Main method */
    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a nonnegative integer: ");
        int n = input.nextInt();

        // Display factorial
        System.out.println("Factorial of " + n + " is " + factorialTail(n));
    }

    /** Return the factorial for a specified number */
    public static long factorialTail(int n) {
        return factorialTail(n, 1); // Call auxiliary method
    }

    /** Auxiliary tail-recursive method for factorial */
    private static long factorialTail(int n, int result) {
        if (n == 0)
            return result;
        else
            return factorialTail(n - 1, n * result); // Recursive call
    }
}
