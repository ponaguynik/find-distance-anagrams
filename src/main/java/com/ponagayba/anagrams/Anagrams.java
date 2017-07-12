package com.ponagayba.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagrams {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a string of words:");
        String input = reader.readLine();
        printWordsAnagrams(input, input.length()-1);
    }

    public static void printWordsAnagrams(String str, int end) {
        if (end < 0)
            return;
        int length = 0, endNext = end;
        while (endNext >= 0 && str.charAt(endNext) != ' ') {
            length++;
            endNext--;
        }
        printWordsAnagrams(str, --endNext);
        for (int i = 0; i < length; i++, end--)
            System.out.print(str.charAt(end));
        System.out.print(" ");
    }
}
