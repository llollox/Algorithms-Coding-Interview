package previmedical.it.leetcode.problems.crack.moderate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class T9 {

    public List<String> t9(Set<String>dictionary, String number) {
        ArrayList<String> list = new ArrayList<>();
        t9(number, 0, dictionary, list, new StringBuilder());
        return list;
    }

    private void t9(String number, int index, Set<String> dictionary, ArrayList<String> list, StringBuilder sb) {
        if (index == number.length()) {

            String word = sb.toString();
            if (dictionary.contains(word)) {
                list.add(word);
            }

        }
        else {

            for (char c : numberToChars(number.charAt(index))) {
                sb.append(c);
                t9(number, index + 1, dictionary,  list, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }


    private char[] numberToChars(char c) {

        switch (c) {
            case '0': return new char[0];
            case '1': return new char[0];
            case '2': return new char[] {'a', 'b', 'c'};
            case '3': return new char[] {'d', 'e', 'f'};
            case '4': return new char[] {'g', 'h', 'i'};
            case '5': return new char[] {'j', 'k', 'l'};
            case '6': return new char[] {'m', 'n', 'o'};
            case '7': return new char[] {'p', 'q', 'r', 's'};
            case '8': return new char[] {'t', 'u', 'v'};
            case '9': return new char[] {'w', 'x', 'y', 'z'};
            default: throw new RuntimeException();
        }
    }
}
