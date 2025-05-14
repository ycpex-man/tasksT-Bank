package task6;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countEmployee = sc.nextInt();
        int totalDifference = 0;
        int[] heightArray = new int[countEmployee];
        for (int i = 0; i < countEmployee; i++) {
            heightArray[i] = sc.nextInt();
        }
        Arrays.sort(heightArray);
        for (int i = 0; i < countEmployee / 2; i++) {
            totalDifference += heightArray[countEmployee - 1 - i] - heightArray[i];
        }
        System.out.println(totalDifference);
    }
}
