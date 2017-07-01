package com.ponagayba.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagrams {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter a string of words:");
        String input = reader.readLine();
        char[] array = input.toCharArray();

        wordsAnagrams(array);

        System.out.println(array);
    }

    private static void wordsAnagrams(char[] array) {
        for (int start = 0, end; start < array.length; start++) {
            if (array[start] == ' ')
                continue;
            end = start;
            while (end != array.length-1 && array[end+1] != ' ')
                end++;
            for (int i = start, j = end; i <= (end+start)/2; i++, j--) {
                char temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
            start = end+1;
        }
    }
}
