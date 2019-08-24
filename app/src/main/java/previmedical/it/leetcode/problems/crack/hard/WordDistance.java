package previmedical.it.leetcode.problems.crack.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordDistance {

    /*
        You have a large text file containing words.
        Given any two words, find the shortest distance (in terms of number of words) between them in the file.

        If the operation will be repeated many times for the same file (but different pairs of words),
        can you optimize your solution?


        ASSUMPTIONS
        - Are words repeated in a file? Let's assume yes.
        - Words are separated by \s

        HOW TO CALCULATE MINIMUM DISTANCE BETWEEN TWO WORDS
        - Splitted: String[] = Split the text by \s
        - Scan all words of the text
        - When I find A:
            - Min distance = Integer.MAX_VALUE
            - Init distance = 1
            - Aindex = indice della parola A
            - Check if splitted[Aindex - distance] == B || text[Aindex + distance] == B
            - Se non va a buon fine, ripeto aumentando la distanza di 1.
            - Quando questo si verifica salvo la distanza

        HOW TO CALCULATE MINIMUM DISTANCE BETWEEN TWO WORDS
        - Get a list of all distinct words Time O(n) Space O(n)
        - Create HashMap<String, List<Integer>> with, for each word the indexes where that word starts  Time O(n) Space O(n)
        - Given two pairs of words:
            - get both list of indexes. Time O(1)
            - Assume both indexes are sorted
            - Find the minimum distance between the two elements one of the first list and one from the second. O(n + m)


        FIND MINIMUM DISTANCE BETWEEN TWO INDEXES  Time O(n + m)   Space O(1)
        l1 [1, 3, 10, 24]  l1[1]
        l2 [5, 9, 15, 20]  l2[0]
        - Inizio con due indici all'inizio di entrambi gli array
        - int diff = Math.abs(a1[i1] - l2[i2])
        - if (a1[i1 + 1] < a2[i2 + 1]) i1 += 1 else i2 += 1;


        LOOKUP OPTIMIZATION
        - Creo una hashmap che per ogni coppia di nodi mi risponde che la distanza minima.
          In questo modo il lookup costa O(1)
     */


    private HashMap<String, List<Integer>> createIndexesMap(String[] words) {
        HashMap<String, List<Integer>> map = new HashMap<>();

        for (int i=0; i<words.length; i++) {
            String word = words[i];
            List<Integer> indexes = map.get(word);
            if (indexes == null) {
                indexes = new ArrayList<>();
                map.put(word, indexes);
            }
            indexes.add(i);
        }

        return map;
    }


//    public int wordDistanceOptmial(String[] words) {
//        HashMap<String, List<Integer>> map = this.createIndexesMap(words);
//
//
//    }
//
//    private int findMinDifference(List<Integer> a, List<Integer> b) {
//
//    }


    public int wordDistance(String[] words, String a, String b) {
        if (words == null || a == null || b == null) {
            return -1;
        }

        int locationA = -1;
        int locationB = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i=0; i<words.length; i++) {

            String word = words[i];

            if (word.equals(a)) {
                locationA = i;
                minDistance = getNewMinDistance(minDistance, locationA, locationB);
            }
            else if (word.equals(b)) {
                locationB = i;
                minDistance = getNewMinDistance(minDistance, locationA, locationB);
            }
        }

        if (a.equals(b)) {
            return locationA >= 0 ? 0 : -1;
        }

        return minDistance;
    }

    private int getNewMinDistance(int minDistance, int locationA, int locationB) {
        if (locationA == - 1 || locationB == -1) {
            return minDistance;
        }
        else {
            return Math.min(minDistance, Math.abs(locationA - locationB));
        }
    }

}
