package previmedical.it.leetcode.problems.crack.stacks;

import java.util.Stack;

public class SortStack extends Stack<Integer> {


    /*

        Solution.

        Finche ci sono elementi in s

            Estrapolo un elemento da s in tmp
            fintanto che la cima di r > tmp e ci sono elementi in r
                re-inserisco gli elementi maggiori di r in s
            per finire inserisco tmp in r

        s:
        r: 1 2 4 7
        tmp:

     */


    public void sort() {

        Stack<Integer> r = new Stack<>();

        while (!this.isEmpty()) {
            int tmp = this.pop();

            while (!r.isEmpty() && r.peek() > tmp) {
                this.push(r.pop());
            }

            r.push(tmp);
        }

        while (!r.isEmpty()) {
            this.push(r.pop());
        }

    }

}
