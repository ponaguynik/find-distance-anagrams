package com.ponagayba.finddistance;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindDistance {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a row of integers:");
        int[] numbers;
        while (true) {
            try {
                String input = reader.readLine();
                if (input == null || input.isEmpty())
                    throw new NumberFormatException();
                numbers = toIntArray(input);
                if (numbers.length < 2)
                    throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input. Try again:");
                continue;
            }
            break;
        }
        int[] twoMinIndexes = twoMinIndexes(numbers);
        System.out.format("The smallest numbers are %d and %d. Distance between them is %d.%n",
                numbers[twoMinIndexes[0]],
                numbers[twoMinIndexes[1]],
                Math.abs(twoMinIndexes[0] - twoMinIndexes[1]));
    }

    private static int[] toIntArray(String str) throws NumberFormatException {
        String[] strArr = str.split(" ");
        int[] result = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++)
            result[i] = Integer.parseInt(strArr[i]);
        return result;
    }

    private static int[] twoMinIndexes(int[] numbers) {
        int[] result = new int[2];
        int minIndex1 = 0, minIndex2 = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[minIndex1])
                minIndex1 = i;
        }
        if (minIndex1 == 0)
            minIndex2 = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[minIndex2] && i != minIndex1)
                minIndex2 = i;
        }
        result[0] = minIndex1;
        result[1] = minIndex2;
        return result;
    }
}