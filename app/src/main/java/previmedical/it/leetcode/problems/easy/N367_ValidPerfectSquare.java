package previmedical.it.leetcode.problems.easy;

public class N367_ValidPerfectSquare {

    /*
        Given a positive integer num, write a function which returns
        True if num is a perfect square else False.

        Note: Do not use any built-in library function such as sqrt.

        Example 1:
        Input: 16
        Output: true

        Example 2:
        Input: 14
        Output: false
     */

    /*
    Solution.
    [1,2,3,4,5,6,7 ..,94,95,96,97,98,99,100]

    [1..51], mid=25
    [1..24], mid=12
    [1..11], mid=6
    [7..11], mid=9
    [10..11], mid=10

     */



    public boolean isPerfectSquare(int num) {

        int start = 0;
        int end = num/2 + 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            long square = (long) mid * (long) mid;

            if (square == num) {
                return true;
            }
            else if (square < num){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return false;
    }
}
