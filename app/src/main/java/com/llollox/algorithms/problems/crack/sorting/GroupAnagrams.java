package com.llollox.algorithms.problems.crack.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class GroupAnagrams {

    public ArrayList<String> sortAnagrams(ArrayList<String> input) {
        if (input == null || input.isEmpty()) return input;

        HashMap<String, ArrayList<String>> groups = new HashMap<>();
        // N
        for (String s : input) {
            TreeMap<Character, Integer> freqMap = buildFreqMap(s); // M
            String key = buildJson(freqMap);
            ArrayList<String> group = groups.getOrDefault(key, new ArrayList<String>());
            group.add(s);
            groups.put(key, group);
        }

        ArrayList<String> result = new ArrayList<>(); // N
        for (ArrayList<String> group : groups.values()) {
            result.addAll(group);
        }

        return result;
    }

    // {‘a’:1, ‘b’: 2}
    private String buildJson(TreeMap<Character, Integer> map) {
        StringBuilder sb  = new StringBuilder();
        for (TreeMap.Entry<Character, Integer> entry: map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(":");
            sb.append(entry.getValue());
            sb.append(",");
        }
        return sb.toString();
    }

    private TreeMap<Character, Integer> buildFreqMap(String s) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i =0; i<s.length(); i++) {
            char c = s.charAt(i);
            int occ = map.getOrDefault(c, 0) + 1;
            map.put(c, occ);
        }
        return map;
    }
}
