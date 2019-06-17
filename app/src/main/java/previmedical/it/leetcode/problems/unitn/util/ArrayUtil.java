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

}
