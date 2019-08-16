package previmedical.it.leetcode.problems.crack.hard;

public class RandomSet {

    public int[] randomSet(int[] array, int m) {
        if (array == null || m >= array.length) {
            return null;
        }

        int[] subset = new int[m];
        for (int i=0; i< m; i++) {
            subset[i] = array[i];
        }

        for (int i=m; i<array.length; i++) {
            int position = random(0, i);
            if (position < m) {
                subset[position] = array[i];
            }
        }

        return subset;
    }

    int random(int lower, int higher) {
        return lower + (int) (Math.random() * (higher - lower + 1));
    }

}
