package com.llollox.algorithms.problems.crack.hard;

import com.llollox.algorithms.datastructure.trie.Trie;
import com.llollox.algorithms.datastructure.trie.TrieNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
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
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o2.length(), o1.length());
            }
        });

        Trie trie = new Trie(strings);
        TrieNode root = trie.getRoot();

        for (String s : strings) {
            if (isWithinTrie(root, s)) {
                return s;
            }
        }

        return null;
    }

    private boolean isWithinTrie(TrieNode root, String s) {
        TrieNode node = root;
        boolean passedThroughOtherWords = false;

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            node = node.getChild(c);
            if (node == null) {
                return false;
            }

            if (node.isTerminates()) {
                node = root;
                if (i < s.length() - 1) {
                    passedThroughOtherWords = true;
                }
            }
        }

        return passedThroughOtherWords;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Re implemented
    // Ordino l'array per lunghezza stringa
    // Creo un set di stringhe per avere lookup in O(1)
    // Scorro le stringhe dalla piu lunga alla piu corta e per ognuna provo tutti i tagli possibili per vedere se riesco a costruire la stessa parola componendo altre parole.
    // Non devo considerare il caso in cui non ci siano tagli (parola intera)
    String longestWordReImplemented(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o2.length(), o1.length());
            }
        });

        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        for (String s : words) {
            if (canBeComposed(s, set)) {
                return s;
            }
        }

        return null;
    }


    // Se posso prendere un elemento lo prendo
    // Verifico anche il caso in cui non lo prendo
    boolean canBeComposed(String s, HashSet<String> words) {
        return canBeComposed(s, words, 0);
    }

    boolean canBeComposed(String s, HashSet<String> words, int start) {
        if (start >= s.length()) {
            return true;
        }

        for (int i=start + 1; i<=s.length(); i++) {
            String subString = s.substring(start, i);
            if (!subString.equals(s)
                    && words.contains(subString)
                    && canBeComposed(s, words, i)) {
                return true;
            }
        }

        return false;
    }
}
