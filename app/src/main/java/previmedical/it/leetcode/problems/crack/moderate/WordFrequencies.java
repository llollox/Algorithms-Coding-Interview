package previmedical.it.leetcode.problems.crack.moderate;

import java.util.HashMap;
import java.util.List;

public class WordFrequencies {

    /*
        Design a method to find the frequency of occurrences of any given word in a book.
        What if we were running this algorithm multiple times?
     */


    /*

        Solution 1.

        Creo una HashMap<String,Int> in cui la chiave è una stringa (la parola) e il valore è un Integer (il numero di occorrenze)
        Scorro tutte le parole del libro:
            - Se la parola è nella hashmap allora incremento di + il suo valore.
            - Se la parola non è nella hashmap allora inserisco nella mappa (word, 1)

        Time Complexity 1
        - Cercare / Inserire una parola nella hashmap O(1)
        - Incrementare il valore O(1)

        Questo è da ripetere n volte, dove n è il numero di word nel libro.

     */


    HashMap<String, Integer> prepareDictionary(List<String> book) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < book.size(); i++) {
            String word = book.get(i);

            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            }
            else {
                map.put(word, 1);
            }
        }
        return map;
    }

    int getNumOccurrences(HashMap<String, Integer> map, String word) {
        if (map == null || map.isEmpty()) {
            return 0;
        }

        if (map.containsKey(word)) {
            return map.get(word);
        }
        else {
            return 0;
        }
    }
}
