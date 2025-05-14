package task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int count = 0;
        for (int l = 0; l < n; l++) {
            for (int r = l + 2; r < n; r++) {
                for (int i = l; i <= r - 2; i++) {
                    for (int j = i + 1; j <= r - 1; j++) {
                        for (int k = j + 1; k <= r; k++) {
                            if (array[j] - array[i] == array[k] - array[j]) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}

