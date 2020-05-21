package com.llollox.algorithms.problems.easy;

public class N762_PrimeNumberBitsSetInBinaryRepresentation {

    public int countPrimeSetBits(int L, int R) {
        return sol2(L, R);
    }

    public int sol1(int L, int R) {
        int count = 0;
        for (int v = L; v <= R; v++) {
            int numBitsOne = numBitsOne(v);
            boolean isPrime = isPrime(numBitsOne);
            if (isPrime) {
                count += 1;
            }
        }
        return count;
    }

    private int numBitsOne(int num) {
        return Integer.bitCount(num);
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        if (num % 2 == 0 && num != 2) {
            return false;
        }

        int sqrt = (int) Math.sqrt(num);
        for (int d = 3; d <= sqrt; d += 2) {
            if (num % d == 0) {
                return false;
            }
        }

        return true;
    }

    public int sol2(int L, int R) {
        boolean[] isPrime = new boolean[] {
                false, false, true, true, false, true,
                false, true, false, false, false,
                true, false, true, false, false,
                false, true, false, true, false, false
        };

        int[][] co = new int[21][21];
        for(int i = 0; i <= 20; i++) {
            co[i][0] = 1;
            co[i][i] = 1;
            for(int j = 1; j < i; j++) {
                co[i][j] = co[i-1][j-1] + co[i-1][j];
            }
        }

        int ans = getCount(R, isPrime, co) - getCount(L, isPrime, co);
        return isPrime[Integer.bitCount(R)] ? ans + 1 : ans;
    }

    private int getCount(int n, boolean[] isPrime, int[][] co) {
        int ans = 0;
        int m = 20;
        int mask = 1 << m;
        int leadingOnes = 0;
        while(mask > 0) {
            if ((n & mask) != 0) {
                for(int i = 0; i <= m; i++) {
                    if (isPrime[i + leadingOnes]) {
                        ans += co[m][i];
                    }
                }

                leadingOnes++;
            }

            mask >>= 1;
            m--;
        }
        return ans;
    }
}
