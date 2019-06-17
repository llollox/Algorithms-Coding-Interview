package previmedical.it.leetcode.problems.medium;

public class ZigZagConversion {

    public String convert(String s, int numRows) {

        int n = s.length();

        StringBuilder[] array = new StringBuilder[numRows];
        for (int i=0; i<numRows; i++) {
            array[i] = new StringBuilder();
        }


        boolean add = true;
        int index = 0;
        int limit = numRows - 1;
        for (int i=0; i<n; i++) {

            // do index
            array[index].append(s.charAt(i));

            if (numRows > 1) {
                if (index == limit) {
                    add = false;
                }
                else if (index == 0) {
                    add = true;
                }


                if (add) {
                    index++;
                }
                else {
                    index--;
                }
            }
        }

        StringBuilder finalSb = new StringBuilder();
        for (int i=0; i<numRows; i++) {
            finalSb.append(array[i].toString());
        }

        return finalSb.toString();
    }

}
