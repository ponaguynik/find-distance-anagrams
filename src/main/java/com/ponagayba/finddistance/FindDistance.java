package com.ponagayba.finddistance;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class FindDistance {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int[] numbers = toIntArray(input);
        int minIndex1 = minIndex(numbers);
        int minIndex2 = minIndex(numbers, minIndex1);
        System.out.format("The smallest numbers are %d and %d. Distance between them is %d.",
                numbers[minIndex1], numbers[minIndex2], Math.abs(minIndex1 - minIndex2));
    }

    public static int[] toIntArray(String str) {
        return Arrays.stream(str.split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    public static int minIndex(int[] numbers) {
        int minIndex = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[minIndex])
                minIndex = i;
        }
        return minIndex;
    }

    public static int minIndex(int[] numbers, int exceptIndex) {
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        numbersCopy[exceptIndex] = Integer.MAX_VALUE;
        return minIndex(numbersCopy);
    }
}