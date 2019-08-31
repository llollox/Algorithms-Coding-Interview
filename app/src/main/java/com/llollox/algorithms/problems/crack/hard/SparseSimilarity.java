package com.llollox.algorithms.problems.crack.hard;

import java.util.*;

public class SparseSimilarity {

    /*
        The similarity of two documents (each with distinct words)
        is defined to be the size of the intersection divided by the size of the union.
        For example, if the documents consist of integers,
        the similarity of {1, 5, 3} and {1, 7, 2, 3} is 0. 4,
        because the intersection has size 2 and the union has size 5.

        We have a long list of documents (with distinct values and each with an associated ID)
        where the similarity is believed to be "sparse:'
        That is, any two arbitrarily selected documents are very likely
        to have similarity O.

        Design an algorithm that returns a list of pairs of document IDs and the associated similarity.
        Print only the pairs with similarity greater than 0.
        Empty documents should not be printed at all.
        For simplicity, you may assume each document is represented as an array of distinct integers.

        Input
        13: {14, 15, 100, 9, 3}
        16: {32, 1, 9, 3, 5}
        19: {15, 29, 2, 6, 8, 7}
        24: {7, 10}

        Output
        ID1, ID2 SIMILARITY
        13, 19 0.1
        13, 16 0.25
        19, 24 0.14285714285714285

     */

    /*
        Questions
        - Does the list of documents fit in memory? Yes

        Approach 3
        Creo una HashMap<Integer, List<Integer>> in cui ad ogni intero corrisponde la lista di documenti che hanno quell’intero. Time O(N * S) Space O(N * S)
        Scorro tutti i documenti: Time O(N)
        Per ogni valore: Time O(S)
        Inserisco nella map[valore] .add(id)

        Calcolo la similarità di ogni coppia di documenti:
        Time O(N * (S + N))  = O (N2 + N * S) Space O(N * S)
        Per ogni documento O(N)
        Calcolo la lista di documenti simili a quello: Time O(S)  Space O(N)
        Istanzio un set
        Per ogni intero nel documento, aggiungo tutti gli elementi della lista nel set.
        Rimuovo me stesso.
        Per ogni elemento simile O(N)
        Calcolo la similarità O(S)
     */

    public static class Result {
        public int id1;
        public int id2;
        public double similarity;

        public Result(int id1, int id2, double similarity) {
            this.id1 = id1;
            this.id2 = id2;
            this.similarity = similarity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Result result = (Result) o;
            return id1 == result.id1 &&
                    id2 == result.id2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id1, id2);
        }
    }

    public List<Result> sparseSimilarity(HashMap<Integer, List<Integer>> documents) {
        HashMap<Integer, HashSet<Integer>> valueRelatedIdsMap = this.getValueRelatedIdsMap(documents);
        ArrayList<Result> results = new ArrayList<>();

        for (HashMap.Entry<Integer, List<Integer>> entry: documents.entrySet()) {
            int documentId = entry.getKey();
            List<Integer> values = entry.getValue();
            if (values == null || values.isEmpty()) {
                continue;
            }

            HashMap<Integer, Integer> idFrequenciesMap = this.buildIdFrequencyMap(documentId, values, valueRelatedIdsMap);

            for (HashMap.Entry<Integer, Integer> entry1 : idFrequenciesMap.entrySet()) {

                int relatedId = entry1.getKey();

                if (relatedId == documentId) {
                    continue;
                }

                if (results.contains(new Result(relatedId, documentId, 0))) {
                    continue;
                }

                int intersection = entry1.getValue();
                double union = values.size() + documents.get(relatedId).size() - intersection;
                double similarity = intersection / union;

                Result result = new Result(documentId, relatedId, similarity);
                results.add(result);
            }
        }

        return results;
    }

    private HashMap<Integer, Integer> buildIdFrequencyMap(int docId, List<Integer> values, HashMap<Integer, HashSet<Integer>> valueIdsMap) {
        HashMap<Integer, Integer> idFrequenciesMap = new HashMap<>();

        for (int value : values) {

            for (int documentId : valueIdsMap.get(value)) {
                if (docId == documentId) {
                    continue;
                }

                Integer frequency = idFrequenciesMap.get(documentId);
                if (frequency == null) {
                    frequency = 0;
                }
                frequency += 1;
                idFrequenciesMap.put(documentId, frequency);
            }
        }

        return idFrequenciesMap;
    }

    private HashMap<Integer, HashSet<Integer>> getValueRelatedIdsMap(HashMap<Integer, List<Integer>> documents) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (HashMap.Entry<Integer, List<Integer>> entry: documents.entrySet()) {

            int id = entry.getKey();
            List<Integer> values = entry.getValue();

            for (int value : values) {
                HashSet<Integer> ids = map.get(value);
                if (ids == null) {
                    ids = new HashSet<>();
                }
                ids.add(id);
                map.put(value, ids);
            }
        }

        return map;
    }



}
