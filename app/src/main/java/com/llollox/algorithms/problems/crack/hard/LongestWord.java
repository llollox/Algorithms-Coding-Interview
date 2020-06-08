package com.llollox.algorithms.problems.crack.hard;

import com.llollox.algorithms.datastructure.trie.Trie;
import com.llollox.algorithms.datastructure.trie.TrieNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class LongestWord {
    /*
    Given a list of words, write a program to find the longest word made of other words in the list.'
     */

    public String longestWord(Set<String> words) {
        if (words == null || words.isEmpty()) {
            return "";
        }

        ArrayList<String> strings = new ArrayList<>(words);
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s2.length(), s1.length());
            }
        });

        for (String s : strings) {
            words.remove(s);
            if (canBeBuilt(s, words)) {
                return s;
            }
            words.add(s);
        }

        return "";
    }


    public boolean canBeBuilt(String s, Set<String> words) {
        if (s == null || s.isEmpty() || words.isEmpty()) {
            return false;
        }

        return canBeBuilt(s, 0, words);
    }

    private boolean canBeBuilt(String s, int i, Set<String> words) {
        if (i == s.length()) {
            return true;
        }

        StringBuilder word = new StringBuilder();

        for (; i < s.length(); i++) {
            word.append(s.charAt(i));

            if (words.contains(word.toString())) {
                boolean taking = canBeBuilt(s, i + 1, words);
                if (taking) {
                    return true;
                }
            }
        }

        return false;
    }


    // Trie approach *******************************************************************************
    String longestWord(String[] strings) {
        if (strings == null || strings.length == 0) {
            return null;
        }

        // sort by length asc
//        Arrays.sort(string, new Comparator<String>() {
//            @Override
//            public int compareTo(String s1, String s2) {
//                return Integer.compare(s2.length, s1.length);
//            }
//        });

        Trie trie = new Trie(strings);
        TrieNode root = trie;

        for (String s : strings) {
            if (isWithinTrie(root, s)) {
                return s;
            }
        }

        return null;
    }

    private boolean isWithinTrie(TrieNode root, String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            node = node.getChild(c);
            if (node == null) {
                return false;
            }

            if (node.isTerminates()) {
                node = root;
            }
        }
        return true;
    }
}
