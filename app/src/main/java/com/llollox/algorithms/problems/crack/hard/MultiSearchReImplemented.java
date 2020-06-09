package com.llollox.algorithms.problems.crack.hard;

import com.llollox.algorithms.datastructure.trie.Trie;
import com.llollox.algorithms.datastructure.trie.TrieNode;

import java.util.ArrayList;
import java.util.HashMap;

public class MultiSearchReImplemented {

    HashMap<String, ArrayList<Integer>> multiSearch(String b, String[] T) {
        HashMap<String, ArrayList<Integer>> result = new HashMap<>();
        if (b == null || b.length() == 0 || T == null || T.length == 0) {
            return result;
        }

        Trie trie = new Trie(T);
        TrieNode root = trie.getRoot();

        for (int start=0; start < b.length(); start++) {
            TrieNode node = root;
            int index = start;

            while(node != null && index < b.length()) {
                char c = b.charAt(index);
                node = node.getChild(c);

                if (node != null && node.isTerminates()) {
                    String word = b.substring(start, index + 1);
                    addResult(result, word, start);
                }

                index++;
            }
        }

        return result;
    }

    private void addResult(HashMap<String, ArrayList<Integer>> result, String word, int index) {
        ArrayList<Integer> occurrences = result.getOrDefault(word, new ArrayList<Integer>());
        occurrences.add(index);
        result.put(word, occurrences);
    }
}
