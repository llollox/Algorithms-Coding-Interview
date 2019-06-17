package previmedical.it.leetcode.problems.crack.strings;

public class IsUnique {

    /*
        Is Unique: Implement an algorithm to determine if a string has all unique characters.
        What if you cannot use additional data structures?
     */

    public boolean isUnique(String string) {

        int buffer = 0;

        char[] array = string.toCharArray();

        for (char c : array) {
            int index = this.getCharIndex(c);

            if (!this.hasCharacter(buffer, index)) {
                buffer = this.toggle(buffer, index);
            }
            else {
                return false;
            }
        }

        return true;
    }

    private int getCharIndex(char c) {
        return Character.getNumericValue(c) - Character.getNumericValue('a');
    }

    public boolean hasCharacter(int buffer, int index) {
        if (index >= 32 || index < 0) {
            throw new RuntimeException("Index out of bounds: " + index);
        }

        return (buffer >> index) % 2 == 1;
    }

    public int toggle(int buffer, int index) {
        if (index >= 32 || index < 0) {
            throw new RuntimeException("Index out of bounds: " + index);
        }

        int mask = 1 << index;
        int value = (buffer >> index) % 2;

        if (value == 1) {
            return buffer ^ mask;
        }
        else {
            return buffer | mask;
        }

    }
}
