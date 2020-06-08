package com.llollox.algorithms.datastructure.trie;

import java.util.List;

public class Trie {

    // Private class attributes ****************************************************************************************
    private TrieNode root;


    // Constructor *****************************************************************************************************
    public Trie(List<String> list) {
        this.root = new TrieNode();
        for (String word : list) {
            this.root.addWord(word);
        }
    }

    public Trie(String[] array) {
        this.root = new TrieNode();
        for (String word : array) {
            this.root.addWord(word);
        }
    }

    public TrieNode getRoot() {
        return root;
    }

    // Checks whether this trie contains a string with the prefix passed in as argument.
    public boolean contains(String prefix, boolean exact) {

        TrieNode node = this.root;

        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            node = node.getChild(c);
            if (node == null) {
                return false;
            }
        }

        return !exact || node.isTerminates();
    }
}
