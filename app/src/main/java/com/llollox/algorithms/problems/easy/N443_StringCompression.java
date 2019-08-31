package com.llollox.algorithms.problems.easy;

import android.util.Log;

public class N443_StringCompression {

    /*

        Given an array of characters, compress it in-place.
        The length after compression must always be smaller than or equal to the original array.

        Every element of the array should be a character (not int) of length 1.
        After you are done modifying the input array in-place, return the new length of the array.

        Follow up:
        Could you solve it using only O(1) extra space?

        Example 1:
        Input: ["a","a","b","b","c","c","c"]
        Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
        Explanation:"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".

        Example 2:
        Input:["a"]
        Output:Return 1, and the first 1 characters of the input array should be: ["a"]
        Explanation: Nothing is replaced.

        Example 3:
        Input: ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
        Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
        Explanation: Since the character "a" does not repeat, it is not compressed.
        "bbbbbbbbbbbb" is replaced by "b12".
        Notice each digit has it's own entry in the array.

     */


    // Se l'array e' lungo 1 allora ritorno 1.
    // Scorro l'array contanto quanti sono i caratteri uguali.
    // Appena cambia il carattere, scrivo la sostituzione nell'array.

    // Time: O(n)
    // Space: O(1)

    public int compress(char[] chars) {

        if (chars.length == 0) {
            return 0;
        }
        else if (chars.length == 1) {
            return 1;
        }

        int index = 0;
        int indexOfWritten = 0;

        while (index < chars.length) {

            Character c = chars[index];
            int occurrences = 1;
            int indexOfEqual = index + 1;

            while (indexOfEqual < chars.length && c == chars[indexOfEqual]) {
                indexOfEqual++;
                occurrences++;
            }

            chars[indexOfWritten] = c;

            if (occurrences > 1) {
                String occurrencesString = "" + occurrences;
                for (int j=0; j<occurrencesString.length(); j++) {
                    indexOfWritten++;
                    chars[indexOfWritten] = occurrencesString.charAt(j);
                }
            }

            index = indexOfEqual;
            indexOfWritten++;
        }

        return indexOfWritten;
    }


    public void test() {

        char[] array1 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int output1 = this.compress(array1);
        Log.w("TEST", output1 + " ==? 6");

        char[] array2 = {'a'};
        int output2 = this.compress(array2);
        Log.w("TEST", output2 + " ==? 1");

        char[] array3 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int output3 = this.compress(array3);
        Log.w("TEST", output3 + " ==? 4");

        char[] array4 = {'a','b','c'};
        int output4 = this.compress(array4);
        Log.w("TEST", output4 + " ==? 3");
    }
}
