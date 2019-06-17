package previmedical.it.leetcode.problems.medium;

public class IntegerToRoman {

    public String convert(int num) {

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder sb = new StringBuilder();
        int index = 0;

        while (num > 0) {

            int value = values[index];
            if (num >= value) {
                sb.append(convertNum(value));
                num = num - value;
            }
            else {
                index++;
            }
        }

        return sb.toString();
    }



    private String convertNum(int n) {
        switch (n) {
            case 1: return "I";
            case 4: return "IV";
            case 5: return "V";
            case 9: return "IX";
            case 10: return "X";
            case 40: return "XL";
            case 50: return "L";
            case 90: return "XC";
            case 100: return "C";
            case 400: return "CD";
            case 500: return "D";
            case 900: return "CM";
            case 1000: return "M";
            default: return "Z";
        }
    }
}
