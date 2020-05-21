package com.llollox.algorithms.problems.topics.dynamic;

public class Hateville {

    /*

        Hateville è un villaggio particolare, composto da n case, numerate da 1 a n lungo una singola strada.

        Ad Hateville ognuno odia i propri vicini della porta accanto, da entrambi i lati.

        Quindi, il vicino i odia i vicini i − 1 e i + 1 (se esistenti).

        Hateville vuole organizzare una sagra e vi ha affidato il compito di raccogliere i fondi.

        Ogni abitante i ha intenzione di donare una quantità D[i],
        ma non intende partecipare ad una raccolta fondi a cui partecipano uno o entrambi i propri vicini.


        Scrivere un algoritmo che restituisca la quantità massima di fondi che può essere raccolta

        Scrivere un algoritmo che restituisca il sottoinsieme di indici
        S ⊆ {1, . . . , n} tale per cui la donazione totale T = P i∈ S D[i] è massimale

        Vettore donazioni: D = [4, 3, 6, 5]
     */

    /*
        Solution.

        M[i] = max donation until i
        M[i] = Max(M[i - 2] + D[i],  M[i - 1])

     */


    public int maximumDonation(int[] donations) {

        switch (donations.length) {

            case 0: return 0;
            case 1: return donations[0];
            case 2: return Math.max(donations[0], donations[1]);
            default: {

                int prevPrev = donations[0];
                int prev = Math.max(donations[1], donations[0]);

                for (int i=2; i<donations.length; i++) {
                    int value = Math.max(prevPrev + donations[i], prev);
                    prevPrev = prev;
                    prev = value;
                }

                return prev;
            }
        }

    }
}
