package previmedical.it.leetcode.problems.crack.hard;

public class ShuffleDeck {

    /*
        Write a method to shuffle a deck of cards.
        It must be a perfect shuffle-in other words, each of the 52! permutations of the deck has to be equally likely.
        Assume that you are given a random number generator which is perfect.
     */

    public int[] shuffle(int[] deck) {
        if (deck == null || deck.length < 2) {
            return deck;
        }

        for (int i=1; i<deck.length; i++) {
            int position = random(0, i);
            int temp = deck[position];
            deck[position] = deck[i];
            deck[i] = temp;
        }

        return deck;
    }

    private int random(int lower, int higher) {
        return lower + (int)(Math.random() * (higher - lower + 1));
    }

}
