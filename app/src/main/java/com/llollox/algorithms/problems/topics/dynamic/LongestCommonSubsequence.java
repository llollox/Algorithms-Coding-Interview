package com.llollox.algorithms.problems.topics.dynamic;

public class LongestCommonSubsequence {


    /*
        Date due stringhe di caratteri, ritornare la sottosequenza di lunghezza massima.
        Una stringa p è sotto di una stringa s, se p è ottenuta da s rimuovendo qualche carattere.
        L'ordine dei caratteri delle stringhe NON deve cambiare.

        Solution.

        Se una è null o empty ritorno stringa vuota.
        Inizializzo una matrice[a.length][b.length].
        matrix[i][j] = lcs ottenuta con i primi i caratteri della stringa A e i primi j caratteri della stringa B.
        matrix[i][j] = la lcs di lunghezza massima tra
            - matrix[i - 1][j] = Prendo il carattere j della stringa B, ma non il carattere i della stringa A.
            - matrix[i][j - 1] = Non prendo il carattere j della stringa B, ma prendo il carattere i della stringa A.
            - matrix[i - 1][j - 1] + A[i] == B[j] ? A[i] : "" =
                Prendo la lcs senza i due caratteri in questione. (i - 1) (j - 1)
                Se i due caratteri sono uguali, allora posso aggiungerli altrimenti devo prendere la stringa cosí com'è.
        Ritorno matrix[a.length() - 1][b.length() - 1]
     */

    public String lcs(String a, String b) {

        if (a == null || a.isEmpty() || b == null || b.isEmpty()) {
            return "";
        }


        StringBuilder sbA = new StringBuilder(a);
        StringBuilder sbB = new StringBuilder(b);

        String[][] matrix = new String[a.length()][b.length()];

        String firstB = sbB.substring(0, 1);
        for (int i=1; i<=a.length(); i++) {
            matrix[i - 1][0] = sbA.substring(0, i).contains(firstB) ? firstB : "";
        }

        String firstA = sbA.substring(0, 1);
        for (int j=1; j<=b.length(); j++) {
            matrix[0][j - 1] = sbB.substring(0, j).contains(firstA) ? firstA : "";
        }

        for (int i=1; i<a.length(); i++) {
            for (int j=1; j<b.length(); j++) {

                String up = matrix[i - 1][j];
                String left = matrix[i][j - 1];
                String max = up.length() > left.length() ? up : left;

                String diagonal = matrix[i - 1][j - 1] + (sbA.charAt(i) == sbB.charAt(j) ? sbA.charAt(i) : "");
                matrix[i][j] = max.length() > diagonal.length() ? max : diagonal;
            }
        }

        return matrix[a.length() - 1][b.length() - 1];
    }
}
