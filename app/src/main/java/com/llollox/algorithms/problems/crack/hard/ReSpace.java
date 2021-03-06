package com.llollox.algorithms.problems.crack.hard;

import com.llollox.algorithms.datastructure.trie.Trie;
import com.llollox.algorithms.datastructure.trie.TrieNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ReSpace {

    /*
    Oh, no! You have accidentally removed all spaces, punctuation, and capitalization in a lengthy document.
    A sentence like "I reset the computer. It still didn't boot!"
    became "iresetthe c omputeritstilldidntboot''.

    You'll deal with the punctuation and capi­ talization later;
    right now you need to re-insert the spaces.
    Most of the words are in a dictionary but a few are not.

    Given a dictionary (a list of strings) and the document (a string),
    design an algorithm to unconcatenate the document in a way that minimizes the
    number of unrecognized characters.

    EXAMPLE
    Input “jesslookedjustliketimherbrother”, [“looked”, “just”, “like”, “her”, “brother”]
    Output: jess looked just like tim her brother (7unrecognizedcharacters)
     */


    /*
       Questions:
        Does the string or dictionary fit in memory? Yes
        What if the string is null or empty? return null
        What if the dictionary is null or empty? return the string;
        Return type? The result class

        N is the number of characters
        K the number of words in the dictionary
        S the length of the longest word into the dictionary

     */

    public static class Result {
        public List<String> strings;
        public int numUnrecognizedCharacters;

        public Result(List<String> strings, int numUnrecognizedCharacters) {
            this.strings = strings;
            this.numUnrecognizedCharacters = numUnrecognizedCharacters;
        }
    }

    /*
        Approach 2: Applicare memoization per salvarsi il modo migliore in cui
        splittare una porzione della stringa originale.

        memo[substring] = Result il modo migliore per spezzare la sottostringa.

        Provo a spezzare la string in ogni punto.
        Se il risultato lo trovo in memo allora lo utilizzo direttamente
        Altrimenti chiamo ricorsivamente la funzione
        Provo tutte le combinazioni di spezzamenti e cerco di trovare quello
        che minimizza i caratteri non riconosciuti.
     */

    public Result reSpace(String s, HashSet<String> dictionary) {
        if (s == null || s.length() == 0) {
            return null;
        }
        if (dictionary == null || dictionary.isEmpty()) {
            ArrayList<String> strings = new ArrayList<>();
            strings.add(s);
            return new Result(strings, s.length());
        }

        HashMap<String, Result> memo = new HashMap<>();
        Result r = reSpace(s, dictionary, memo);
        return r;
    }

    private Result reSpace(String s, HashSet<String> dictionary, HashMap<String, Result> memo) {
        if (s == null || s.length() == 0) {
            return new Result(new ArrayList<String>(), 0);
        }

        if (s.length() == 1) {
            ArrayList<String> strings = new ArrayList<>();
            strings.add(s);
            return new Result(strings, dictionary.contains(s) ? 0 : 1);
        }

        if (dictionary.contains(s)) {
            ArrayList<String> strings = new ArrayList<>();
            strings.add(s);
            return new Result(strings, 0);
        }

        Result minUnrecResult = null;

        for (int i = 1; i < s.length(); i++) {
            String part1 = s.substring(0, i);
            Result part1Result = memo.get(part1);
            if (part1Result == null) {
                part1Result = reSpace(part1, dictionary, memo);
                memo.put(part1, part1Result);
            }

            String part2 = s.substring(i);
            Result part2Result = memo.get(part2);
            if (part2Result == null) {
                part2Result = reSpace(part2, dictionary, memo);
                memo.put(part2, part2Result);
            }

            int numUnrecChars = part1Result.numUnrecognizedCharacters + part2Result.numUnrecognizedCharacters;
            if (minUnrecResult == null || minUnrecResult.numUnrecognizedCharacters > numUnrecChars) {
                ArrayList<String> strings = new ArrayList<>();
                strings.addAll(part1Result.strings);
                strings.addAll(part2Result.strings);
                minUnrecResult = new Result(strings, numUnrecChars);
            }
        }

        return minUnrecResult;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public static class MyResult {
        String res;
        int unknownChars;

        public MyResult(String res, int unknownChars) {
            this.res = res;
            this.unknownChars = unknownChars;
        }
    }

    public MyResult reSpaceTrie(String s, List<String> dictionary) {
        Trie trie = new Trie(dictionary);
        MyResult[] memo = new MyResult[s.length()];
        return reSpace(s, 0, trie.getRoot(), memo);
    }

    private MyResult reSpace(String s, int start, TrieNode trie, MyResult[] memo) {
        if (start >= s.length()) {
            return new MyResult("", 0);
        }

        MyResult without = reSpace(s, start + 1, trie, memo);
        MyResult min = new MyResult( s.charAt(start) + without.res, without.unknownChars + 1);

        int i = start;
        TrieNode node = trie;
        while (i < s.length() && node.getChild(s.charAt(i)) != null) {
            node = node.getChild(s.charAt(i));
            if (node.isTerminates()) {

                MyResult result = i < s.length() - 1 ? memo[i + 1] : null;
                if (result == null) {
                    result = reSpace(s, i + 1, trie, memo);
                }

                String word = s.substring(start, i + 1);
                if (min.unknownChars > result.unknownChars) {
                    min = new MyResult(word + " " + result.res, result.unknownChars);
                }
            }
            i++;
        }

        memo[start] = min;
        return min;
    }
}
