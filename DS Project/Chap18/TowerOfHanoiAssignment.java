package Chap18;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TowerOfHanoiAssignment {
    /** Main method */
    public static void main(String[] args) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        boolean checkInput = false;
        Scanner input = new Scanner(System.in);


        while (!checkInput) {
            try {
                // Create a Scanner
                System.out.print("Enter number of disks (1~20): ");
                int n = input.nextInt();
                if (n >= 1 && n <= 20) {
                    checkInput = true;
                    // Find the solution recursively
                    count = moveDisks(n, '1', '3', '2', 0, sb);
                } else
                    System.out.println("Invalid Input Number (N: 1~20)\n");
            } catch (InputMismatchException ex) {
                input.nextLine();
                System.out.println("Input type is mismatched\n");

            }
        }
        System.out.println("Total moves: " + count);
        System.out.println(sb);
    }

    /** The method for finding the solution to move n disks from fromTower to toTower with auxTower */
    public static int moveDisks(int n, char fromTower, char toTower, char auxTower, int count, StringBuilder sb) {
        count++;
        if (n == 1) // Stopping condition
            sb = sb.append("From " + fromTower + " to " + toTower + "\n");
        else {
            count = moveDisks(n - 1, fromTower, auxTower, toTower, count, sb);
            sb = sb.append("From " + fromTower + " to " + toTower + "\n");
            count = moveDisks(n - 1, auxTower, toTower, fromTower, count, sb);
        }
        return count;
    }
}
