package previmedical.it.leetcode.problems.easy;

import android.util.Log;

public class N278_FirstBadVersion {

    /*
        You are a product manager and currently leading a team to develop a new product.
        Unfortunately, the latest version of your product fails the quality check.
        Since each version is developed based on the previous version,
        all the versions after a bad version are also bad.

        Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
        which causes all the following ones to be bad.

        You are given an API bool isBadVersion(version) which will return whether version is bad.
        Implement a function to find the first bad version.
        You should minimize the number of calls to the API.

        Example:

        Given n = 5, and version = 4 is the first bad version.

        call isBadVersion(3) -> false
        call isBadVersion(5) -> true
        call isBadVersion(4) -> true

        Then 4 is the first bad version.
     */


    public int firstBadVersion(int n) {

        int startIndex = 1;
        int endIndex = n;

        while (startIndex < endIndex) {

            int mid = startIndex + (endIndex - startIndex) / 2;

            if (isBadVersion(mid)) {
                endIndex = mid; // cercare sulla meta prima
            }
            else {
                startIndex = mid + 1; // cercare sulla meta dopo
            }
        }

        return startIndex;
    }

    public boolean isBadVersion(int version) {
        return version >= 1;
    }

    public void test() {

        int firstBadVersion = this.firstBadVersion(1);
        Log.w("TEST", "First bad version: " + firstBadVersion);

    }
}