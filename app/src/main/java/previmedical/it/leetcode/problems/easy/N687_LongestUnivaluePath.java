package previmedical.it.leetcode.problems.easy;

import previmedical.it.leetcode.models.TreeNode;

public class N687_LongestUnivaluePath {

    /*

        Given a binary tree, find the length of the longest path where each node in the path has the same value.
        This path may or may not pass through the root.
        The length of path between two nodes is represented by the number of edges between them.

            1
          4   4
        4  6 2  4

        Eseguo una dfs

        Scendo in ricorsione passando il valore da cercare e il numero di occorrenze trovate fin ora.

        se sono uguale al valore da cercare
            calcolo il max inoltrando la funzione nei miei due figli e aggiungo 1

        se sono diverso dal valore da cercare
            ritorno il massimo tra:
                - il numero di occorrenze trovate fin ora
                - inizio a cercare me stesso

        se sono una foglia => return 1


        val max = Math.max(f(figlio sinistro) + 1 se sono uguale al figlio sx, f(figlio destro) + 1 se sono uguale al figlio dx)


     */


    public int longestUnivaluePath(TreeNode root) {

        return this.longestUnivaluePath(root, 1, root.val);
    }

    public int longestUnivaluePath(TreeNode node, int numOccurrences, int value) {
        if (node == null) {
            return 0;
        }
        else if (node.val == value) {

            int left = this.longestUnivaluePath(node.left, numOccurrences + 1, value);
            int right = this.longestUnivaluePath(node.right, numOccurrences + 1, value);

            return Math.max(left, right);
        }
        else {

            int left = this.longestUnivaluePath(node.left, 1, value);
            int right = this.longestUnivaluePath(node.right, 1, value);

            int max = Math.max(left, right);
            return Math.max(max, numOccurrences);
        }
    }




    // Solution provided by leetcode
//    int ans;
//    public int longestUnivaluePath(TreeNode root) {
//        ans = 0;
//        arrowLength(root);
//        return ans;
//    }
//    public int arrowLength(TreeNode node) {
//        if (node == null) return 0;
//        int left = arrowLength(node.left)
//        int right = arrowLength(node.right);
//        int arrowLeft = 0, arrowRight = 0;
//        if (node.left != null && node.left.val == node.val) {
//            arrowLeft += left + 1;
//        }
//        if (node.right != null && node.right.val == node.val) {
//            arrowRight += right + 1;
//        }
//        ans = Math.max(ans, arrowLeft + arrowRight);
//        return Math.max(arrowLeft, arrowRight);
//    }
}
