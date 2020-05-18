package com.llollox.algorithms.datastructure;

public class MfSet {

    // MsSet(int x)  // Crea un MFSet col nodo x
    // void merge(int x, int y)  // Unisce le componenti che contengono x, y


    // Ho un array dei padri: parent. parent[i] indica il parent dell'elemento[i]


    private int[] parent;
    private int[] rank;

    MfSet(int capacity) {
        this.parent = new int[capacity];
        this.rank = new int[capacity];

        for (int i=0; i<capacity; i++) {
            this.parent[i] = i;
            this.rank[i] = 1;
        }
    }

    private boolean isDelegate(int x) {
        return this.parent[x] == x;
    }


    // Restituisce il rappresentante di x
    // se il nodo i è un rappresentante di un set, allora parent[i] == i.
    // altrimenti devo scorrere l'albero verso l'alto fintanto che trovo un rappresentante.
    // Nel mentre che scorro l'albero verso l'alto aggiorno i nodi di rappresentanza

    // Compressione dei cammini.
    // Dopo che la ricorsione ha trovato il rappresentante generale.
    // Assegno tale valore a tutti gli elementi che ho incontrato fino al padre.

    int find(int x) {
        if (isDelegate(x)) {
            return x;
        }
        else {
            int delegate = find(this.parent[x]);
            this.parent[x] = delegate;
            return delegate;
        }
    }

    // Unisce le componenti che contengono x, y
    // Prendo i due rappresentanti dei due nodi
    // Setto uno il padre dell'altro, cosi facendo unisco i due insiemi

    // Euristica sul rango
    // Devo agganciare il l'albero meno profondo all'albero più profondo.
    void merge(int x, int y) {
        int xDelegate = find(x);
        int yDelegate = find(y);

        int xRank = this.rank[xDelegate];
        int yRank = this.rank[yDelegate];

        if (xRank > yRank) {
            this.parent[yDelegate] = xDelegate;
        }
        else if (xRank < yRank) {
            this.parent[xDelegate] = yDelegate;
        }
        else {
            this.parent[xDelegate] = yDelegate;
            this.rank[xDelegate] = this.rank[xDelegate] + 1;
        }
    }
}
