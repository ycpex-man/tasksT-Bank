package task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = scanner.nextInt();
        int[][] schedules = new int[numberOfLines][2];

        for (int i = 0; i < numberOfLines; i++) {
            schedules[i][0] = scanner.nextInt();
            schedules[i][1] = scanner.nextInt();
        }
        int numberOfQueries = scanner.nextInt();
        for (int i = 0; i < numberOfQueries; i++) {
            int line = scanner.nextInt() - 1;
            int arrivalTime = scanner.nextInt();

            int firstTrain = schedules[line][0];
            int interval = schedules[line][1];

            if (arrivalTime <= firstTrain) {
                System.out.println(firstTrain);
            } else {
                int nextTrain = firstTrain + ((arrivalTime - firstTrain + interval - 1) / interval) * interval;
                System.out.println(nextTrain);
            }
        }

        scanner.close();
    }
}