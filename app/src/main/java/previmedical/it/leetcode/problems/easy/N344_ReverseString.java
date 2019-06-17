package previmedical.it.leetcode.problems.easy;

public class N344_ReverseString {

    /*

    Write a function that reverses a string.
    The input string is given as an array of characters char[].

    Do not allocate extra space for another array,
    you must do this by modifying the input array in-place with O(1) extra memory.

    You may assume all the characters consist of printable ascii characters.

    Example 1:

    Input: ["h","e","l","l","o"]
    Output: ["o","l","l","e","h"]
    Example 2:

    Input: ["H","a","n","n","a","h"]
    Output: ["h","a","n","n","a","H"]

     */


    /*
        Per i che va da 0 a n/2.
        Swappo il carattere in posizione i con il carattere in posizione length -1 -i (l'ultimo)
     */

    public void reverseString(char[] s) {

        for (int i=0; i<s.length/2; i++) {
            int reversePosition = (s.length - 1) -i;
            char temp = s[i];
            s[i] = s[reversePosition];
            s[reversePosition] = temp;
        }
    }
}
