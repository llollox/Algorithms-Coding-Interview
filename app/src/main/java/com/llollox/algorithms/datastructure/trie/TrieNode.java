package com.llollox.algorithms.datastructure.trie;

import java.util.HashMap;

public class TrieNode {


    // Private class attributes ****************************************************************************************
    private char character; // The character stored in this node as data
    private HashMap<Character, TrieNode> children; // The children of this node in the trie
    private boolean terminates = false;


    // Constructors ****************************************************************************************************
    /* Constructs an empty trie node and initializes the list of its children to an
     * empty hash map. Used only to construct the root node of the trie. */
    public TrieNode() {
        this.children= new HashMap<>();
    }

    /* Constructs a trie node and stores this character as the node's value.
     * Initializes the list of child nodes of this node to an empty hash map. */
    public TrieNode(char character) {
        this();
        this.character = character;
    }


    // Class functions *************************************************************************************************
    /* Add this word to the trie, and recursively create the child nodes. */
    public void addWord(String word) {

        if (word == null || word.isEmpty()) {
            return;
        }

        char firstCharacter = word.charAt(0);
        TrieNode child = this.getChild(firstCharacter);

        if (child == null) {
            child = new TrieNode(firstCharacter);
            this.children.put(firstCharacter, child);
        }

        if (word.length() > 1) {
            child.addWord(word.substring(1));
        }
        else {
            child.setTerminates(true);
        }
    }

    public char getCharacter() {
        return character;
    }

    /* Find a child node of this node that has the char argument as its data.
       Return null if no such child node is present in the trie. */
    public TrieNode getChild(char character) {
        return this.children.get(character);
    }

    public boolean isTerminates() {
        return terminates;
    }

    public void setTerminates(boolean terminates) {
        this.terminates = terminates;
    }
}
