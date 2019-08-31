package com.llollox.algorithms.problems.crack.strings;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

    /*
        Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
        A palindrome is a word or phrase that is the same forwards and backwards.
        A permutation is a rearrangement of letters.
        The palindrome does not need to be limited to just dictionary words.

        EXAMPLE
        Input: Tact Coa  -> Taco cat
        Output: True (permutations: "taco cat'; "atco eta·; etc.)
     */

    public boolean palindromePermutation(String input) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<input.length(); i++) {
            char c = input.charAt(i);

            int occurrences = map.get(c) == null ? 0 : map.get(c);
            map.put(c, occurrences + 1);
        }

        boolean oddFound = false;
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                if (!oddFound) {
                    oddFound = true;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean palindromePermutationBitVector(String input) {
        int bitVector = this.createBitVector(input);
        return bitVector == 0 || this.checkExactlyOnBitSet(bitVector);
    }

    private int createBitVector(String input) {

        int bitVector = 0;

        for (char c: input.toCharArray()) {
            int index = this.getCharNumber(c);
            bitVector = this.toggle(bitVector, index);
        }

        return bitVector;
    }

    private int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);

        if (a <= val && val <= z) {
            return val - a;
        }
        else {
            return -1;
        }

    }

    // Toggle i-th bit into the bitVector
    // bit vector [0 0 1 0 0 0 0 1]
    // mask       [0 0 1 0 0 0 0 0]
    private int toggle(int bitVector, int index) {
        if (index < 0) {
            return bitVector;
        }

        int mask = 1 << index;

        if ((bitVector & mask) == 0) {

            // the i-th value is 0
            // 0 || 1 => 1
            bitVector |= mask;
        }
        else {

            // the i-th value is 1
            // 1 & 0 => 0
            bitVector &= ~mask;
        }

        return bitVector;
    }

    private boolean checkExactlyOnBitSet(int bitVector) {
        return (bitVector & bitVector -1) == 0;
    }


    public void test() {
        String input = "Tact Coa";
        boolean output = this.palindromePermutation(input);
        Log.w("TEST", output + " ==? true");
    }
}
