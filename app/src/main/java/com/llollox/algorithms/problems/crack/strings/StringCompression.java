package com.llollox.algorithms.problems.crack.strings;

public class StringCompression {

    /*
        Implement a method to perform basic string compression using the counts of repeated characters.
        For example, the string aabcccccaaa would become a2b1c5a3.
        If the "compressed" string would not become smaller than the original string,
        your method should return the original string.
        You can assume the string has only uppercase and lowercase letters (a - z).

        Solution.

        First calculate the length of the compressed string.
        This has 2 advantages:

        1) If the string has a lot of unique characters,
        we can return immediately without wasting time to calculate a useless string.

        2) We can initialize the String Builder with its proper capacity, without wasting memory.
        Without this, StringBuilder will (behind the scenes) need to double its capacity every time it hits capacity.
        The capacity could be double what we ultimately need.

        This algorithm works in O(2*n), which is O(n).

     */


    public String compressedString(String s) {

        int compressedLength = this.countCompressedLength(s);
        if (compressedLength > s.length()) {
            return s;
        }


        StringBuilder sb = new StringBuilder(compressedLength);

        int i=0;

        while (i < s.length()) {
            char c = s.charAt(i);

            int j = i + 1;

            while (j < s.length() && s.charAt(j) == c) {
                j++;
            }

            int numOccurrences = j - i;
            sb.append(c);
            sb.append(numOccurrences);

            i = j;
        }

        return sb.toString();
    }

    public String compress(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int compressedLength = countCompressedLength(s);
        if (s.length() <= compressedLength) {
            return s;
        }

        StringBuilder sb = new StringBuilder(compressedLength);
        int numOccurrences = 1;

        for (int i=0; i<s.length(); i++) {
            if (i + 1 == s.length() || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(s.charAt(i));
                sb.append(numOccurrences);
                numOccurrences = 1;
            }
            else {
                numOccurrences += 1;
            }
        }

        return sb.toString();
    }


    public int countCompressedLength(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int compressedLength = 0;
        int numOccurrences = 1;
        for (int i=0; i<s.length(); i++) {
            if (i + 1 == s.length() || s.charAt(i) != s.charAt(i + 1)) {
                compressedLength += 1; // for the char
                compressedLength += String.valueOf(numOccurrences).length(); // for the occurrences
                numOccurrences = 1;
            }
            else {
                numOccurrences += 1;
            }
        }

        return compressedLength;
    }
}
