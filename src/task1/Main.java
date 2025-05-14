package task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        if (isAlmostPalindrome(input)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isAlmostPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            String modifiedString = s.substring(0, i) + s.substring(i + 1);
            if (isPalindrome(modifiedString)) {
                return true;
            }
        }
        return false;
    }
}
