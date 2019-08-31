package com.llollox.algorithms.problems.crack.hard;

public class VolumeOfHistogram {
    /*
        Imagine a histogram (bar graph).
        Design an algorithm to compute the volume of water it could hold
        if someone poured water across the top.
        You can assume that each histogram bar has width 1.

        EXAMPLE
        Input [0,0,4,0,0,6,0,0, 3,0, 5,0,1,0,0,0]
        Output 26
     */


    /*
        APPROACH 1: Time O(n) Space O(n)
        - È come se si dovesse calcolare l'ammontare di acqua che ci sta all'interno dell'istogramma
        - L'idea è quella di creare un metodo che per ogni indice mi calcoli:
            - l'altezza della barra più alta precedente
            - l'altezza della barra più alta successiva
            - il volume di acqua per quel punto diventa:
                h = Min(hsucc, hprec)
                Math.max(0. h - array[i])
     */


    public int volumeHistogram(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int[] maxPred = this.buildMaxPredecessors(array);
        int[] maxSucc = this.buildMaxSuccessors(array);

        int sum = 0;
        for (int i=0; i< array.length; i++) {
            int h = Math.min(maxPred[i], maxSucc[i]);
            int water = Math.max(0, h - array[i]);
            sum += water;
        }

        return sum;
    }

    private int[] buildMaxPredecessors(int[] array) {
        int[] result = new int[array.length];

        int maxPred = 0;
        for (int i = 0; i < array.length; i++) {
            result[i] = maxPred;

            if (array[i] > maxPred) {
                maxPred = array[i];
            }
        }

        return result;
    }

    private int[] buildMaxSuccessors(int[] array) {
        int[] result = new int[array.length];

        int maxSucc = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            result[i] = maxSucc;

            if (array[i] > maxSucc) {
                maxSucc = array[i];
            }
        }

        return result;
    }

}
