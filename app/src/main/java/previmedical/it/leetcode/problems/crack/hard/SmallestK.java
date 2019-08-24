package previmedical.it.leetcode.problems.crack.hard;


import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestK {


    // Time O(n * log k) Space O(log k)
    public int[] smallestK(int[] array, int k) {
        if (array == null || k < 0) {
            return null;
        }

        if (k >= array.length) {
            return array;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(i2, i1);
            }
        });

        for (int i=0; i<k; i++) {
            pq.add(array[i]);
        }

        for (int i=k; i<array.length; i++) {
            int value = array[i];
            int max = pq.peek();

            if (value < max) {
                pq.poll();
                pq.add(value);
            }
        }

        int[] result = new int[k];
        for (int i=0; i<k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}
