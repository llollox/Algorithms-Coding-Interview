package previmedical.it.leetcode.problems.crack.linkedList;

import previmedical.it.leetcode.models.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {


    /*
         Implement a function to check if a linked list is a palindrome.

        Solution.
        Fast runner / Slow runner per sapere l'elemento medio. O(n)

        Riempio uno stack fino all'elemento middle. S(n)
        Dal middle in poi confronto i valori col peek dello stack,
        se non combaciano allora ritorno false. O(n)
        T: O(2*n) S: O(n/2)

        Ottimizzazione, fare tutto nello stesso run.
        Quando il fast runner diventa null, inizio a scaricare lo stack ed a confrontare i valori.
        T: O(n) S: O(n/2)

     */

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode middle = this.middle(head);

        ListNode current = head;
        Stack<ListNode> stack = new Stack<>();
        boolean middleFound = false;

        while (current != null) {

            if (middleFound) {  // verifica

                ListNode peek = stack.pop();
                if (current.val != peek.val) {
                    return false;
                }
            }

            else { // Aggiunta valori

                if (current == middle) {
                    middleFound = true;

                    if (stack.size() % 2 == 1) {
                        stack.push(current);
                    }
                }
                else {
                    stack.push(current);
                }
            }

            current = current.next;
        }

        return true;
    }

    private ListNode middle(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode slowRunner = head;
        ListNode fastRunner = head.next;


        while (fastRunner != null) {

            fastRunner = fastRunner.next;

            if (fastRunner != null) {
                slowRunner = slowRunner == null ? head : slowRunner.next;
                fastRunner = fastRunner.next;
            }
        }

        return slowRunner;
    }

//    private ListNode recurse(ListNode head) {

//        if (head.next == null) {
//            return head;
//        }
//        else {
//            System.out.println("**************************************");
//            System.out.println(head.val);
//            ListNode last = this.recurse(head.next);
//            System.out.println(last.val);
//            return last;
//        }
//    }
}
