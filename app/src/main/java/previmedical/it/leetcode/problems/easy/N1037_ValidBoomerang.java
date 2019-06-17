package previmedical.it.leetcode.problems.easy;

import android.util.Log;

public class N1037_ValidBoomerang {

    /*

        A boomerang is a set of 3 points that are all distinct and not in a straight line.
        Given a list of three points in the plane, return whether these points are a boomerang.

        Example 1:
        Input: [[1,1],[2,3],[3,2]]
        Output: true


        Example 2:
        Input: [[1,1],[2,2],[3,3]]
        Output: false

        Note:
        points.length == 3
        points[i].length == 2
        0 <= points[i][j] <= 100
     */


    // isBoomerang = NOT is in a straight line.
    // Per verificare se i punti sono nella stessa linea.
    // Una volta calcolato l'incremento in x e y dal primo punto al secondo.
    // Devo verificare che gli stessi incrementi si hanno tra il primo e il terzo o tra il terzo ed il secondo.

    // Time: O(1)
    // Space: O(1)

    public boolean isBoomerang(int[][] points) {

        // Check if there are duplicates.
        if (
                (points[0][0] == points[1][0] && points[0][1] == points[1][1])
                ||
                (points[0][0] == points[2][0] && points[0][1] == points[2][1])
                ||
                (points[1][0] == points[2][0] && points[1][1] == points[2][1])
        ) {
            return false;
        }

        // Check if they are on the same line => return false
        if (
                (points[0][0] == points[1][0]) && (points[0][0] == points[2][0])
                || (points[0][1] == points[1][1]) && (points[0][1] == points[2][1])
        ) {
            return false;
        }


        int incrementX = points[0][0] - points[1][0];
        int incrementY = points[0][1] - points[1][1];

        int differenceX = points[0][0] - points[2][0];
        int differenceY = points[0][1] - points[2][1];

        boolean isOnStraightLine =
                (differenceX == incrementX && differenceY == incrementY)
                        || (differenceX == -incrementX && differenceY == -incrementY)
                        || (differenceX == incrementX * 2 && differenceY == incrementY * 2)
                        || (differenceX == -incrementX * 2 && differenceY == -incrementY * 2);

        return !isOnStraightLine;
    }


    public boolean isBoomerangSimplified(int[][] p) {
                // (incrementX[0,1] *  incrementY[0,2])  !=  incrementX[0,2] * incrementY[0,1]
        return (p[0][0] - p[1][0]) * (p[0][1] - p[2][1]) != (p[0][0] - p[2][0]) * (p[0][1] - p[1][1]);
    }

    public void test() {
        int[][] points1 = { {1,1}, {2,3}, {3,2} };
        boolean output1 = this.isBoomerang(points1);
        Log.w("TEST", output1 + " ==? true");

        int[][] points2 = { {1,1}, {2,2}, {3, 3} };
        boolean output2 = this.isBoomerang(points2);
        Log.w("TEST", output2 + " ==? false");

        int[][] points3 = { {0,0}, {2,1}, {2, 2} };
        boolean output3 = this.isBoomerang(points3);
        Log.w("TEST", output3 + " ==? true");

        int[][] points4 = { {0,1}, {0,1}, {2,1} };
        boolean output4 = this.isBoomerang(points4);
        Log.w("TEST", output4 + " ==? false");

        int[][] points5 = { {0,1}, {2,2}, {2,0} };
        boolean output5 = this.isBoomerang(points5);
        Log.w("TEST", output5 + " ==? true");
    }
}
