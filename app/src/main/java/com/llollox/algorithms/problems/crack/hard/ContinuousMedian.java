package com.llollox.algorithms.problems.crack.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ContinuousMedian {

    /*
        Numbers are randomly generated and passed to a method.
        Write a program to find and maintain the median value as new values are generated.
        La mediana è il valore che occupa il valore centrale
     */

    /*
        APPROACH 1: Time O(N^2) Space (N)
        - Tengo in memoria un array ordinato degli elementi ricevuti
        - Per ogni elemento che arriva alla funzione: O(n)
            - Applico binary search per trovare la posizione del nuovo elemento O(log n)
            - Lo inserisco O(N)
            - Rispondo in output il valore mediano dell'array O(1)


        [1, 2, 3, 3, 3, 4, 5]
        APPROACH 2:
        - Tenere due strutture dati:
            - una max heap con tutti i valori minori del mediano
            - una min heap con tutti i valori maggiori o uguali del mediano

        - Per ottenere il mediano: O(1)
            - se max.size == min.size -> media dei due top
            - se max.size > min.size ? max.top : min.top

        - Per aggiungere un nuovo elemento, val O(log n)
            - If val >= mediano allora push in max-heap
            - altrimenti push in min-heap

            - se max/min.size - min/max.size >= 2
                prendo il top di quello con piu elemento e lo puhso in quello con meno elemnti
     */


    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer i1, Integer i2) {
            return Integer.compare(i1, i2);
        }
    });

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer i1, Integer i2) {
            return Integer.compare(i2, i1);
        }
    });


    public void addValue(int val) {
        int median = this.getMedian();
        if (val >= median) {
            this.minHeap.add(val);
            this.balance(this.minHeap, this.maxHeap);
        }
        else {
            this.maxHeap.add(val);
            this.balance(this.maxHeap, this.minHeap);
        }
    }

    private void balance(PriorityQueue<Integer> longer, PriorityQueue<Integer> shorter) {
        if ((longer.size() - shorter.size()) == 2) {
            shorter.add(longer.poll());
        }
    }

    public int getMedian() {
        int minHeapPeek = getPeek(this.minHeap);
        int maxHeapPeek = getPeek(this.maxHeap);

        if (this.minHeap.size() == this.maxHeap.size()) {
            return (minHeapPeek + maxHeapPeek) / 2;
        }
        else {
            return this.minHeap.size() > this.maxHeap.size() ? minHeapPeek : maxHeapPeek;
        }
    }

    private int getPeek(PriorityQueue<Integer> heap) {
        return heap.size() == 0 ? 0 : heap.peek();
    }
}
