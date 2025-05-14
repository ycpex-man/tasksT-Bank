package task3;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 1 && n < 2 * Math.pow(10, 5)){
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int number = sc.nextInt();
                int count = n;
                while (count > 0){
                if (!uniqueElements.contains(number)){
                    uniqueElements.add(number);
                    number /= 2;
                    count--;
                }
                else break;
                }
            }
            System.out.println(uniqueElements.size());
        }
        else
            System.out.println("Введите другую размерность");

    }
}
