package previmedical.it.leetcode.problems.crack.moderate;

public class SmallestDifference {

    /*
        Given two arrays of integers, compute the pair of values (one value in each array)
        with the smallest (non-negative) difference. Return the difference.

        Solution 1. O(n^2)
        Calcolo tutte le coppie possibili e tengo tracci del minore.

        Solution 2. O(nlogn)
        Ordino i due array e applico binary search per cercare il valore.
        n log n per entrambi gli array
        n log n per fare binary search n volte
        tot 3 * nlogn = O(nlogn)

        Solution 3. O(nlogn)
        Ordino i due array.
        Scorro le due liste insieme, andando ad aumentare l'indice della lista col minore.
        n log n per entrambi gli array
        n + m per scorrere entrambe le liste insieme
        tot nlogn + mlogm + n + m = O(nlogn)
     */


}
