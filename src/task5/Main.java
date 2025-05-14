package task5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read inputs for the necessary parameters
        System.out.print("Enter values for n (cost of opening), m (cost of closing), and k (sticky notes): ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        System.out.print("Enter the sequence of parentheses: ");
        String sequence = scanner.nextLine();

        int openNeeded = 0;
        int closeNeeded = 0;
        int balance = 0;

        // Processing the parentheses sequence
        for (char charInSeq : sequence.toCharArray()) {
            if (charInSeq == '(') {
                balance++;  // Increase balance for an open parenthesis
            } else {
                balance--;  // Decrease balance for a close parenthesis
            }

            // If balance goes negative, we have an unmatched closing parenthesis
            if (balance < 0) {
                closeNeeded++;  // Need one more open parenthesis
                balance = 0;    // Reset balance
            }
        }

        // If we finish with a positive balance, it indicates unmatched open parentheses
        openNeeded = balance;

        // Calculating total coins needed
        int coinsNeeded = (closeNeeded * m) + (openNeeded * n);

        // Using sticky notes (k) to reduce the required coins
        if (k >= closeNeeded) {
            coinsNeeded -= closeNeeded; // Can balance all unmatched closings
            k -= closeNeeded;
        } else {
            coinsNeeded -= k; // Use all available sticky notes
            k = 0;
        }

        // If we have remaining sticky notes, we can use them to reduce the need for opening parentheses
        if (k > 0) {
            coinsNeeded -= Math.min(k, openNeeded);
        }

        // The final result should not be negative
        coinsNeeded = Math.max(coinsNeeded, 0);

        // Output the result
        System.out.println("Total coins needed: " + coinsNeeded);

        scanner.close();
    }
}
