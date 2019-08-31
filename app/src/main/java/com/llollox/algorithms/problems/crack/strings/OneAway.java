package com.llollox.algorithms.problems.crack.strings;

import android.util.Log;

public class OneAway {

    /*
        There are three types of edits that can be performed on strings: insert a character,
        remove a character, or replace a character.
        Given two strings, write a function to check if they are one edit (or zero edits) away.

        EXAMPLE
        pale, ple -> true
        pales, pale -> true
        pale, bale -> true
        pale, bae -> false
     */

    public boolean oneAway(String s, String pattern) {
        int diff = Math.abs(s.length() - pattern.length());

        if (diff > 1) {
            return false;
        }

        if (s.length() == pattern.length()) {
            return this.isOneReplacement(s, pattern);
        }
        else if (s.length() < pattern.length()) {
            return this.isOneCharacterAdded(s, pattern);
        }
        else {
            return this.isOneCharacterAdded(pattern, s);
        }
    }

    private boolean isOneReplacement(String s, String pattern) {
        boolean differentFound = false;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != pattern.charAt(i)) {
                if (differentFound) {
                    return false;
                }

                differentFound = true;
            }
        }
        return true;
    }

    private boolean isOneCharacterAdded(String shortest, String longest) {
        boolean addedFound = false;
        int i=0;
        int j=0;
        while (i < shortest.length() && j < longest.length()) {
            if (shortest.charAt(i) != longest.charAt(j)) {
                if (addedFound) {
                    return false;
                }

                addedFound = true;
                j++;
            }

            i++;
            j++;
        }

        return true;
    }

    public void test() {
        Log.w("TEST", this.oneAway("pale", "ple") + " ==? true");
        Log.w("TEST", this.oneAway("pales", "pale") + " ==? true");
        Log.w("TEST", this.oneAway("pale", "bale") + " ==? true");
        Log.w("TEST", this.oneAway("pale", "bae") + " ==? false");
    }
}
