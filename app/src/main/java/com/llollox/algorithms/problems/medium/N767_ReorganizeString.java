package com.llollox.algorithms.problems.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class N767_ReorganizeString {

    /*

        Given a string S, check if the letters can be rearranged
        so that two characters that are adjacent to each other are not the same.

        If possible, output any possible result.
        If not possible, return the empty string.

        Example 1:
        Input: S = "aab"
        Output: "aba"

        Example 2:
        Input: S = "aaab"
        Output: ""

        Note:
        S will consist of lowercase letters and have length in range [1, 500].
     */

    /*
        Questions:
            - Does s fit in memory? Yes
            - What if s is null or empty? return ""

        Note:
            - If len is odd:
                - If a character occurs more than half + 1 of the length of s,
                there are no way to re arrange it.
            - If len is even:
                - If a character occurs more than half of the length of s,
                there are no way to re arrange it.


        aaabbbbbccc
        b: 5 1
        a: 3 1
        c: 3 1
        babcbabcabc


        Approach 1: Time O(n^2) Space O(n)
            - Scorro tutti i caratteri della stringa: Time O(n) Space O(n)
                - Creo una Mappa<Char, Integer> con le occorrenze di ogni carattere
                - Se trovo un carattere che eccede il numero massimo ritorno ""

            - Inizializzo uno StringBuilder

            - Finchè la mappa non è vuota: Time O(n^2) Space O(n)
                - Prendo il carattere che occorre più volte, diverso dal precedente
                - Lo appendo allo string builder

        Approach 2: Time O(n) Space O(n)
            - Scorro tutti i caratteri della stringa: Time O(n) Space O(n)
                - Creo una Mappa<Char, Integer> con le occorrenze di ogni carattere
                - Se trovo un carattere che eccede il numero massimo ritorno ""

            - Inizializzo uno StringBuilder

            - Finchè la mappa non è vuota: Time O(n) Space O(n)
                - Prendo il carattere che occorre più volte, diverso dal precedente.
                    - Che non è altro che l'ultimo carattere, o il penultimo O(1)
                - Lo appendo allo string builder

        Approach 3: Time O(n) Space O(n)
            - Scorro tutti i caratteri della stringa: Time O(n) Space O(n)
                - Creo una Mappa<Char, Integer> con le occorrenze di ogni carattere
                - Se trovo un carattere che eccede il numero massimo ritorno ""

            - Inizializzo uno StringBuilder
            - Creo un PriorityQueue con gli elementi ordinati per frequenza

            - Finchè la pq non è vuota: Time O(n) Space O(n)
                - Prendo il carattere che occorre più volte, diverso dal precedente.
                    - Che non è altro che l'ultimo carattere, o il penultimo O(1)
                - Lo appendo allo string builder
     */

    public String reorganizeString(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int n = s.length();
        int maxOccurrences = n % 2 == 0 ? n / 2 : (n / 2) + 1;

        HashMap<Character, Integer> occurrencesMap = this.createOccurrencesMap(s, maxOccurrences);
        if (occurrencesMap == null) {
            return "";
        }

        return buildOrganizedString(occurrencesMap);
    }

    private String buildOrganizedString(HashMap<Character, Integer> map) {
        StringBuilder sb = new StringBuilder();
        char prev = '0';

        while (!map.isEmpty()) {

            char mostRecurrentChar = getMostRecurrentChar(map, prev);

            sb.append(mostRecurrentChar);
            prev = mostRecurrentChar;

            int occurrences = map.get(mostRecurrentChar);
            if (occurrences == 1) {
                map.remove(mostRecurrentChar);
            }
            else {
                map.put(mostRecurrentChar, occurrences - 1);
            }
        }

        return sb.toString();
    }

    private char getMostRecurrentChar(HashMap<Character, Integer> map, char skippedChar) {
        int max = Integer.MIN_VALUE;
        char mostRecurrentChar = '0';

        for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int occurrences = entry.getValue();

            if (c != skippedChar && occurrences > max) {
                mostRecurrentChar = c;
                max = occurrences;
            }
        }

        return mostRecurrentChar;
    }

    private HashMap<Character, Integer> createOccurrencesMap(String s, int maxOccurrences) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer occurrences = map.get(c);
            if (occurrences == null) {
                occurrences = 0;
            }

            occurrences += 1;
            if (occurrences > maxOccurrences) {
                return null;
            }

            map.put(c, occurrences);
        }

        return map;
    }


    // *****************************************************************************************************************
    public String reorganizeStringPriorityQueue(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int n = s.length();
        int maxOccurrences = n % 2 == 0 ? n / 2 : (n / 2) + 1;

        HashMap<Character, Integer> occurrencesMap = this.createOccurrencesMap(s, maxOccurrences);
        if (occurrencesMap == null) {
            return "";
        }

        PriorityQueue<CharOccurrences> queue = this.createOccurrencesPQ(occurrencesMap);
        return this.buildOrganizedString(queue);
    }

    private String buildOrganizedString(PriorityQueue<CharOccurrences> queue) {
        StringBuilder sb = new StringBuilder();
        char prev = '0';

        while (!queue.isEmpty()) {

            CharOccurrences peek = queue.poll();

            if (peek.c == prev) {

                CharOccurrences prevPeek = queue.poll();

                sb.append(prevPeek.c);
                prev = prevPeek.c;

                if (prevPeek.occurrences > 1) {
                    prevPeek.occurrences = prevPeek.occurrences - 1;
                    queue.add(prevPeek);
                }

                queue.add(peek);
            }
            else {
                sb.append(peek.c);
                prev = peek.c;

                if (peek.occurrences > 1) {
                    peek.occurrences = peek.occurrences - 1;
                    queue.add(peek);
                }
            }
        }

        return sb.toString();
    }

    private static class CharOccurrences {
        char c;
        int occurrences;

        public CharOccurrences(char c, int occurrences) {
            this.c = c;
            this.occurrences = occurrences;
        }
    }

    private PriorityQueue<CharOccurrences> createOccurrencesPQ(HashMap<Character, Integer> map) {
        PriorityQueue<CharOccurrences> queue = new PriorityQueue<>(new Comparator<CharOccurrences>() {
            @Override
            public int compare(CharOccurrences o1, CharOccurrences o2) {
                return Integer.compare(o2.occurrences, o1.occurrences);
            }
        });

        for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(new CharOccurrences(entry.getKey(), entry.getValue()));
        }

        return queue;
    }
}
