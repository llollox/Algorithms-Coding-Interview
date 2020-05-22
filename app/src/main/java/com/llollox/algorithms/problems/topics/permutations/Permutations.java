package com.llollox.algorithms.problems.topics.permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations {

    /*
        Al primo passo scelgo il primo elemento ed ho n-1 scelte da poter fare al prossimo giro
        ...
        Set degli elementi che possono essere ancora scelti
        Scorro tutti gli elementi dell'array, e per ogni elemento che può essere ancora scelto:


        HashSet<Integer> elementi scelti


        Creo una Lista lunga n
        Per ogni passo ho k possibilita di scelta.
            - Aggiungo l'elemento al set dei selezionati
            - Quindi creo un nuovo array con la copia dei primi m elementi fin'ora
            - Appendo l'elemento scelto fino a quel momento
            - Vado avanti con la ricorsione
            - Rimuovo l'elemento dal set dei selezionati
     */

    List<List<Integer>> permutations(int[] array) {

        HashSet<Integer> chosen = new HashSet<>();
        List<List<Integer>> solutions = new ArrayList<>();
        permutationsRec(chosen, array, new ArrayList<Integer>(), solutions);
        return solutions;
    }

    private void permutationsRec(HashSet<Integer> chosen, int[] array, List<Integer> solution, List<List<Integer>> solutions) {
        if (solution.size() == array.length) {
            solutions.add(solution);
        }
        else {

            for (int v : array) {
                if (!chosen.contains(v)) {
                    chosen.add(v);
                    List<Integer> copySolution = new ArrayList<>(solution);
                    copySolution.add(v);
                    permutationsRec(chosen, array, copySolution, solutions);
                    chosen.remove(v);
                }
            }
        }
    }
}
