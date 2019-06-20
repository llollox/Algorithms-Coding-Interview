package previmedical.it.leetcode.problems.crack.bitmanipulation;

public class BitManipulationUtil {

    // Get the i-th bit of the number n
    // Creo una maschera con 0000001000000
    // Metto in and il numero con la maschera.
    // Verifico se il numero è diventato 0 o 1.
    public boolean getBit(int n, int i) {
        int mask = 1 << i;
        return (n & mask) != 0;
    }


    // Set i-th bit to 1
    public int setBit(int n, int i) {
        int mask = 1 << i;
        return n | mask;
    }

    // Clear i-th bit
    public int clearBit(int n, int i) {
        int mask = ~(1 << i);
        return n & mask;
    }

    // Pulisci i bits dal piu significativo fino ad i (compreso)
    // Creao la maschera 0000010000, con 1 su i.
    // Sottraggo 1 ed ottengo: 0000001111
    // A questo se metto in and il numero con questa maschera ottengo un azzeramento dei bits piu significativi.
    public int clearMSBthroughI(int n, int i) {
        int mask = (1 << i) - 1;
        return n & mask;
    }


    public int updateBit(int n, int i, boolean is1) {
        if (is1) {
            int mask = 1 << i;
            return n | mask;
        }
        else {
            int mask = ~(1 << i);
            return n & mask;
        }
    }
}
