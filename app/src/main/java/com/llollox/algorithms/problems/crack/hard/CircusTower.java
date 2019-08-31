package com.llollox.algorithms.problems.crack.hard;

import java.util.*;

public class CircusTower {

    /*
        A circus is designing a tower routine consisting of people standing atop one another's shoulders.
        For practical and aesthetic reasons, each person must be both shorter and lighter than the person below him or her.
        Given the heights and weights of each person in the circus,
        write a method to compute the largest possible number of people in such a tower.
     */


    /*
        P1 [189, 98]
        P2 [170, 100]
        P3 [198, 70]
        P4 [182, 78]
        P5 [200, 110]

        Sorted by height:
        P2 [170, 100]
        P4 [182, 78]
        P1 [189, 98]
        P3 [198, 70]
        P5 [200, 110]

        Sorted by weight:
        P3 [198, 70]
        P4 [182, 78]
        P1 [189, 98]
        P2 [170, 100]
        P5 [200, 110]

        Solution 1.
        Li ordino per altezza.

        A questo punto tutti gli elementi possono essere presi oppure no.


        Se l'elemento successivo del primo può essere preso solo se ha anche un peso maggiore.

        A questo punto ho due scelte:
            - lo prendo:
                - quello diventa la mia nuova base per i calcoli

            - non lo prendo: Ritorno il massimo tra:
                - La sequenza calcolata fin'ora
                - La sequenza che parte da me (compreso o non)


     */

    public List<Person> circusTowerExponential(List<Person> people) {
        if (people == null || people.isEmpty()) {
            return new ArrayList<>();
        }

        Collections.sort(people);
        ArrayList<Person> subsequence = new ArrayList<>();


        return longestIncreasingSeqHelper(people, subsequence, 0);
    }

    private List<Person> longestIncreasingSeqHelper(List<Person> people,
                                                    List<Person> subsequence,
                                                    int index) {
        if (index >= people.size()) {
            return subsequence;
        }
        else {
            Person person = people.get(index);

            // Case don't choose me
            ArrayList<Person> subWithoutMe = new ArrayList<>(longestIncreasingSeqHelper(people, subsequence, index + 1));


            // Case Choose me, if possible
            List<Person> subWithMe = null;
            if (this.canChoose(person, subsequence)) {
                subWithMe = new ArrayList<>(subsequence);
                subWithMe.add(person);
                subWithMe = longestIncreasingSeqHelper(people, subWithMe, index + 1);
            }

            return subWithMe != null && subWithMe.size() > subWithoutMe.size() ? subWithMe : subWithoutMe;
        }
    }


    private boolean canChoose(Person person, List<Person> subsequence) {
        Person last = subsequence.isEmpty() ? null : subsequence.get(subsequence.size() - 1);
        return last == null || last.weight <= person.weight;
    }


    // Approach 2 *****************************************************************************

    /*
        Sorted by weight:
        P3 [198, 70]
        P4 [182, 78]
        P1 [189, 98]
        P2 [170, 100]
        P5 [200, 110]

        L'idea è quella di considerare le persone fino a k.
        Viene creata una lista di liste in cui alla posizione i:
            lista[i] = la lista di lunghezza massima considerando fino alla i-esima persona.

        - Inizializzo un'arary di liste.
        - Scorro tutte le persone Time O(N), j = i + 1
            - Scorro tutte le liste precedenti per trovare quella di lunghezza massima in cui posso aggiungerlo Time O(N)
            - Aggiungo me a tale lista
            - lista[j] = Max tra:
                - la lista più lunga trovata con me
                - lista[j - 1]
        - ritorno lista[n - 1]
     */
    public List<Person> circusTowerNSquare(List<Person> people) {
        if (people == null || people.isEmpty()) {
            return new ArrayList<>();
        }
        Collections.sort(people);
        return circusTower(people);
    }

    private List<Person> circusTower(List<Person> people) {
        int n = people.size();
        ArrayList<ArrayList<Person>> subSequences = new ArrayList<>(n);

        for (int i=0; i<n; i++) {
            Person person = people.get(i);

            List<Person> longestWithMe = getLongestSubList(person.weight, i, subSequences);

            if (longestWithMe == null) {
                longestWithMe = new ArrayList<>();
            }

            List<Person> longest = i > 0 ? subSequences.get(i - 1) : new ArrayList<Person>();

            ArrayList<Person> newLongest;

            if (longestWithMe.size() + 1 >= longest.size()) {
                newLongest = new ArrayList<>(longestWithMe);
                newLongest.add(person);
            }
            else {
                newLongest = new ArrayList<>(longest);
            }

            subSequences.add(i, newLongest);
        }

        return subSequences.get(n - 1);
    }

    private List<Person> getLongestSubList(int minWeight, int maxIndex, ArrayList<ArrayList<Person>> subsequences) {
        List<Person> longest = null;
        for (int i=0; i<maxIndex; i++) {

            List<Person> subSequence = subsequences.get(i);

            if (canChoose(minWeight, subSequence) && (longest == null || longest.size() < subSequence.size())) {
                longest = subSequence;
            }
        }

        return longest;
    }

    private boolean canChoose(int minWeight, List<Person> subsequence) {
        Person last = subsequence.isEmpty() ? null : subsequence.get(subsequence.size() - 1);
        return last == null || last.weight <= minWeight;
    }



    // Data Model *************************************************************************
    public static class Person implements Comparable<Person> {
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }


        @Override
        public int compareTo(Person o) {
            return Integer.compare(this.height, o.height);
        }
    }
}
