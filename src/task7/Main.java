package task7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение длины массива
        int n = scanner.nextInt();
        int[] array = new int[n];

        // Чтение элементов массива
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        long totalInterest = 0;

        // Перебор всех подмножеств
        for (int mask = 1; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
            long product = 1;
            int gcdValue = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(array[i]);
                    product = (product * array[i]) % MOD;
                    gcdValue = gcd(gcdValue, array[i]);
                }
            }

            // Проверяем условия
            if (gcdValue == 1 && isBeautiful(subset)) {
                totalInterest = (totalInterest + product) % MOD;
            }
        }

        // Вывод результата
        System.out.println(totalInterest);
    }

    // Функция для вычисления НОД двух чисел
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Проверка на красоту последовательности
    private static boolean isBeautiful(List<Integer> subset) {
        for (int i = 0; i < subset.size(); i++) {
            for (int j = i + 1; j < subset.size(); j++) {
                if (gcd(subset.get(i), subset.get(j)) != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
