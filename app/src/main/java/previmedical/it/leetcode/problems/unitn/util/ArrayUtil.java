package previmedical.it.leetcode.problems.unitn.util;

public class ArrayUtil {

    public static int[] reverse(int[] array) {
        int length = array.length;
        for (int i=0; i<length/2; i++) {
            swap(array, i, length - (i + 1));
        }
        return array;
    }

    public static void swap(int[] array, int idx1, int idx2) {
        int tmp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = tmp;
    }

    public static int min(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int i=0; i<array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int max(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i=0; i<array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
