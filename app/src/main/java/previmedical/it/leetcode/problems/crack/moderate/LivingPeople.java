package previmedical.it.leetcode.problems.crack.moderate;

public class LivingPeople {

    /*
        Given a list of people with their birth and death years,
        implement a method to compute the year with the most number of people alive.

        You may assume that all people were born between 1900 and 2000 (inclusive).
        If a person was alive during any portion of that year,
        they should be included in that year's count.
        For example, Person (birth= 1908, death= 1909) is included in the counts for both 1908 and 1909.
     */


    /*
        Solution 1.

        Array di 101 valori interi
        Per tutte le persone, per tutti gli anni di vita, vado ad incrementare il valore di 1 nell'array con indice (anno - 1900)
        Alla fine scorro l'array e ritorno il massimo.

        Ottimizzazione, tenere conto del massimo mentre inserisco i valori nell'array.
        Evito in questo modo l'ultimo passaggio.

        Complessità: n = #persone, k=100, durata massima di una persona
        O(n * k) S(k+1)


        Solution 2.
        Ordino gli intervalli
        Per ogni anno:
            - scorro gli intervalli con due indici contanto quanti rispettano il pattern.
            - quando year < interval.start, esco dal ciclo in quanto tutti i successivi saranno più grandi.

        1  2  3  4  5  6  7  8  9  10
        -------
           -------
           ----------
              -------
     */
}
