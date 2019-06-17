package previmedical.it.leetcode.problems.unitn.dynamic;

public class Domino {

    /*
    Il gioco del domino è basato su tessere di dimensione 2×1.
    Scrivere un algoritmo efficiente che prenda in input un intero n
    e restituisca il numero di possibili disposizioni di n tessere in un rettangolo 2 × n.

    Solution.

    Se metto una tessera in verticale, risolverò il problema di dimensione n − 1
    Se metto una tessera in orizzontale, ne devo mettere due; risolverò il problema di dimensione n − 2
    Queste due possibilità si sommano insieme (conteggio)

    2x0 => 0
    2x1 => |  (1)
    2x2 => ||, == (2)
    2x3 => |||, ==|, |== (3)
    2x4 => ||||, ====, ||==, ==||, |==| (5)
    2x5 => |||||, ====|, ==|==, |====, |||==, ||==|, |==||, ==||| (8)
     */


    public int domino(int n) {

        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else {
            return this.domino(n - 2) + this.domino(n - 1);
        }
    }
}
