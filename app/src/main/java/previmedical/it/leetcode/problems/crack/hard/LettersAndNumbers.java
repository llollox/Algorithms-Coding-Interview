package previmedical.it.leetcode.problems.crack.hard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LettersAndNumbers {

    /*
        Given an array filled with letters and numbers,
        find the longest subarray with an equal number of letters and numbers.
     */

    public char[] lettersAndNumbers(char[] array) {
        if (array == null || array.length < 2) {
            return new char[] {};
        }

        int start = 0;
        int end = array.length - 1;

        int numNumbers = this.getSumOfNumbers(array);
        int numLetters = array.length - numNumbers;

        while (start < end && numLetters != numNumbers && numLetters > 0 && numNumbers > 0) {
            char startChar = array[start];
            char endChar = array[end];

            if (numLetters > numNumbers) {

                // Letters are greater than numbers
                if (isLetter(startChar)) {
                    start += 1;
                    numLetters -= 1;
                }
                else if (isLetter(endChar)) {
                    end -= 1;
                    numLetters -= 1;
                }
                else {
                    start += 1;
                    numNumbers -= 1;
                }
            }
            else {

                // Numbers are greater than letters
                if (isNumber(startChar)) {
                    start += 1;
                    numNumbers -= 1;
                }
                else if (isNumber(endChar)) {
                    end -= 1;
                    numNumbers -= 1;
                }
                else {
                    start += 1;
                    numLetters -= 1;
                }
            }
        }

        if (numLetters == numNumbers) {
            return extract(array, start, end);
        }
        else {
            return new char[] {};
        }
    }

    private char[] extract(char[] array, int start, int end) {
        int numItems = (end - start) + 1;
        char[] subset = new char[numItems];

        for (int i=start; i<=end; i++) {
            subset[i - start] = array[i];
        }

        return subset;
    }

    private int getSumOfNumbers(char[] array) {
        int sum = 0;
        for (char c : array) {
            if (isNumber(c)) {
                sum += 1;
            }
        }
        return sum;
    }

    private boolean isLetter(char c) {
        Pattern pattern = Pattern.compile("[A-Za-z]");
        Matcher match = pattern.matcher("" + c);
        return match.find();
    }

    private boolean isNumber(char c) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher match = pattern.matcher("" + c);
        return match.find();
    }

}
