package previmedical.it.leetcode;

import org.junit.Assert;

import java.util.Arrays;

public class Test {

    @org.junit.Test
    public void myTest() {

        String a = "eIm";
        String sorted = sort(a);
        Assert.assertEquals("Iem", sorted);
    }

    private String sort(String s) {
        if (s == null) {
            return null;
        }
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return String.valueOf(array);
    }

}
