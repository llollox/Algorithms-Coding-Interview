package previmedical.it.leetcode.problems.crack.moderate;

import java.util.HashMap;

public class MasterMind {

    /*
        The computer has four slots, and each slot will contain a ball that is red (R), yellow (Y), green (G) or blue (B).
        For example, the computer might have RGGB (Slot #1 is red, Slots #2 and #3 are green, Slot #4 is blue).
        You, the user, are trying to guess the solution. You might, for example, guess YRGB.
        When you guess the correct color for the correct slot, you get a "hit:'.
        If you guess a color that exists but is in the wrong slot, you get a "pseudo-hit:'
        Note that a slot that is a hit can never count as a pseudo-hit.
        For example, if the actual solution is RGBY and you guess GGRR , you have one hit and one pseudo­ hit
        Write a method that, given a guess and a solution, returns the number of hits and pseudo-hits.
     */


    /*
        Solution: T: O(3 * n) = T: O(n), S: O(n)
     */

    public class Result {
        public int numHits;
        public int numPseudoHits;

        // Constructor
        public Result(int numHits, int numPseudoHits) {
            this.numHits = numHits;
            this.numPseudoHits = numPseudoHits;
        }
    }

    public Result countHits(char[] pattern, char[] solution) {
        // Corner cases
        if (pattern == null || solution == null || pattern.length != solution.length) {
            return null;
        }

        // Count number of occurrences for each character
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : pattern) {
            map.put(c, numOccurrences(map, c) + 1);
        }

        // Count hits
        int numHits = 0;
        for (int i=0; i<pattern.length; i++) {

            char solutionChar = solution[i];

            if (pattern[i] == solutionChar) {
                numHits += 1;
                map.put(solutionChar, numOccurrences(map, solutionChar) - 1);
            }
        }

        // Count pseudo hits
        int numPseudoHits = 0;
        for (char c : solution) {

            int numOccurrences = numOccurrences(map, c);
            if (numOccurrences > 0) {
                numPseudoHits += 1;
                map.put(c, numOccurrences - 1);
            }
        }

        return new Result(numHits, numPseudoHits);
    }

    private int numOccurrences(HashMap<Character, Integer> map, char c) {
        return map.get(c) != null ? map.get(c) : 0;
    }
}
