package com.llollox.algorithms.problems.crack.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MultiSearch {

    /*

       Given a string b and an array of smaller strings T,
   design a method to search b for each small string in T.

   Return all the location at which start each small word in b.

   T = {"is", "ppi", "hi", "sis", "i", "ssippi"} num words = K
   b = "mississippi" N = LEN OF B
   S is the length of the longest word in T

   return {
       "is": [1, 4],
       "ppi": [8],
       "hi": [],
       "sis": [3],
       "i": [1, 4, 7, 10],
       "ssippi": [5]
   }

   NOTES
   - Does b fits in memory? Yes
   - What if b is empty or null? For each word return []
   - What if a word is longer than b? return [] for that word

   APPROACH NAIVE O(K * N * S)
   - for each word: O(K)
       - search all the locations in b  O(N)
       - If I found a location, add it to an array list
         In order to find it is a good location, O(S)
         scan b starting from that location and see if each character matches the word

   APPROACH IMPROVED 1  O(K * S + N * S)  = O(S * (K + N))

   T = {"is", "ppi", "hi", "sis", "i", "ssippi"} num words = K
   b = "mississippi" N = LEN OF B

    Create a Trie of T       Time  O(K * S)    Space O(K * S)
    Scan character by character in b:  O(N * S)
    Find m: since it doesn’t have any occurrence in the Trie, go to the next one
    Find i: scan next character until I can traverse the trie
    For each word I find add a location at position

     */


    public HashMap<String, List<Integer>> multiSearch(String bigger, List<String> smallWords) {
        Trie trie = new Trie();
        for (String s : smallWords) {
            trie.addWord(s);
        }

        HashMap<String, List<Integer>> frequencies = new HashMap<>();
        StringBuilder sb = new StringBuilder(bigger);
        for (int i = 0; i< bigger.length(); i++) {
            scan(frequencies, sb, i, i, trie.root);
        }

        return frequencies;
    }

    public void scan(HashMap<String, List<Integer>> frequencies,
                     StringBuilder sb,
                     int startIndex,
                     int index,
                     TrieNode node) {

        if (node.hasTerminationChild()) {
            String word = sb.substring(startIndex, index);
            add(word, frequencies, startIndex);
        }

        if (index == sb.length()) {
            return;
        }

        char c = sb.charAt(index);
        TrieNode child = node.getChild(c);

        if (child == null) {
            return;
        }

        scan(frequencies, sb, startIndex, index + 1, child);
    }

    private void add(String word, HashMap<String, List<Integer>> frequencies, int location) {
        List<Integer> locations = frequencies.get(word);
        if (locations == null) {
            locations = new ArrayList<>();
        }

        locations.add(location);

        frequencies.put(word, locations);
    }



    public static class Trie {
        public TrieNode root;

        public Trie() {
            this.root = new TrieNode();
            this.root.children = new ArrayList<>();
            this.root.isTermination = false;
        }

        public void addWord(String word) {
            this.addWord(word, 0, this.root);
        }

        public boolean contains(String word) {
            return this.contains(word, 0, this.root);
        }

        private boolean contains(String word, int index, TrieNode node) {
            if (index == word.length() && node.hasTerminationChild()) {
                return true;
            }

            char c = word.charAt(index);
            TrieNode child = node.getChild(c);

            if (child != null) {
                return contains(word, index + 1, child);
            }
            else {
                return false;
            }
        }

        private void addWord(String s, int index, TrieNode node) {
            if (index < s.length()) {

                char c = s.charAt(index);
                TrieNode child = node.getChild(c);

                if (child == null) {
                    child = new TrieNode(c);
                    node.children.add(child);
                }

                this.addWord(s, index + 1, child);
            }
            else {
               if (!node.isTermination) {
                   node.children.add(new TrieNode());
               }
            }
        }
    }

    public static class TrieNode {
        char c;
        List<TrieNode> children;
        boolean isTermination;

        public TrieNode() {
            this.isTermination = true;
        }

        public TrieNode(char c) {
            this.c = c;
            this.children = new ArrayList<>();
            this.isTermination = false;
        }

        public boolean hasTerminationChild() {
            if (this.children == null) {
                return false;
            }

            for (TrieNode child : this.children) {
                if (child.isTermination) {
                    return true;
                }
            }

            return false;
        }

        public TrieNode getChild(char c) {
            if (this.children == null) {
                return null;
            }

            for (TrieNode node : this.children) {
                if (node.c == c) {
                    return node;
                }
            }

            // Node not found
            return null;
        }
    }

}
