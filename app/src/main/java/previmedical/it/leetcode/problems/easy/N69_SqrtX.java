package previmedical.it.leetcode.problems.easy;

import android.util.Log;

public class N69_SqrtX {

    /*
    Implement int sqrt(int x).

    Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

    Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

    Example 1:
    Input: 4
    Output: 2

    Example 2:
    Input: 8
    Output: 2
    Explanation: The square root of 8 is 2.82842..., and since
                 the decimal part is truncated, 2 is returned.
     */

    /*
        [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        end = (x/2)+1, x = 10
        ---------------
        start = 0
        end = 6
        mid = 3
        3*3 = 9, difference = 1, under

        start = 3
        end = 6
        mid = 4
        4*4 = 16, difference = 6, above

        start = 3
        end = 4
        mid = 3
        3*3 = 9, difference = 1, under


        end = (x/2)+1, x = 20
        ---------------
        start = 0
        end = 11
        mid = 5
        5*5 = 25, difference = 5, above
        sqrt = MAX

        start = 0
        end = 5
        mid = 2
        2*2 = 4, difference = 16, under
        sqrt = 2

        start = 2
        end = 5
        mid = 3
        3*3 = 9, difference = 11, under
        sqrt = 3

        start = 4
        end = 5
        mid = 4
        4*4 = 16, difference = 4, under
        sqrt = 4











        end = x
        ---------
        start = 0
        end = 10
        mid = 5
        (10+0)/2=5
        5*5 = 25, difference = 15, above

        start = 0
        end = 5
        mid = 2
        (5+0)/2 = 5 / 2 = 2
        2*2 = 4, difference = 6, under

        start = 2
        end = 5
        mid = 3
        (5+2)/2 = 7 / 2 = 3
        3*3 = 9, difference = 1, under

        start = 3
        end = 5
        mid = 4
        (5+3)/2 = 8 / 2 = 4
        4*4 = 16, difference = 6, above

        start = 3
        end = 4
        mid = 3
        3*3 = 9, difference = 1, under


        Solution. Binary Search O(log(n))

        // Risolvo immediatamente i casi base.

        Difference = Int.MAX_INTEGER
        start = 0
        end = x

        Fintanto che difference scende
        Prendo il valore medio.
        square = medio * medio.

        Se square == x, ritorno medio

        Se square < x,
           newDiff = x - square.
           se newDiff > diff, allora ritorno il valore precedente.
           altrimenti start = medio, diff = newDiff e ricomincio

        Se square > x,
           newDiff = square - x.
           se newDiff > diff, allora ritorno il valore precedente.
           altrimenti end = medio, diff = newDiff e ricomincio

     */


    public int mySqrt(int x) {

        int start=0;
        int end=(x/2)+1;

        while(start<=end){
            int mid = (start+end)/2;
            long square = (long)mid * (long)mid;

            if(square==x)
                return mid;
            else if(square<x)
                start=mid+1;
            else
                end=mid-1;
        }
        return end;
    }

    public void test() {
        int output = this.mySqrt(2147395599);
        Log.w("TEST", output + " ==? 46339");
    }
}
