package previmedical.it.leetcode.problems.easy;

public class PalindromeInteger {


    // This algorithm reverse half of the number and then checks
    // if the both half are the same
    public boolean isPalindrome(int x) { // 6ms

        // All negative numbers are palindrome
        if (x < 0 || (x % 10 == 0) && x != 0) {
            return false;
        }

        int reversed = 0;

        while (x > reversed) {
            reversed = reversed * 10 + (x % 10);
            x = x / 10;
        }


        // Check if half is equal reversed half
        return x == reversed || x == reversed / 10;
    }



    // This algorithm checks if the first and last digits are the same.
    // Than divide the number by 100 and checks again.
    public boolean isPalindromeFromCenter(int x) {

        if (x < 0) {
            return false;
        }

        int copy = x;
        int grade = 0;

        while (copy > 9) {
            grade++;
            copy = copy / 10;
        }

        while (x > 0) {

            int magnitude = (int) Math.pow(10, grade);

            int smallest = x % 10;
            int biggest = x / magnitude;

            if (smallest != biggest) {
                return false;
            }

            x = x - biggest * magnitude;
            x = x / 10;
            grade = grade - 2;
        }

        return true;
    }


    // This algorithm convert the number into a string and then checks
    // if that string is palindrome or not.
    public boolean isPalindromeByString(int x) {

        if (x < 0) {
            return false;
        }

        String string = String.valueOf(x);
        int length = string.length();
        int mid = length / 2;

        // Even
        if (length % 2 == 0) {
            return isPalindrome(string, mid - 1, mid, length);
        }
        // Odd
        else {
            return isPalindrome(string, mid, mid, length);
        }

    }

    private boolean isPalindrome(String s, int left, int right, int length) {

        while (left >= 0 && right < length) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left--;
            right++;
        }

        return true;
    }

}
