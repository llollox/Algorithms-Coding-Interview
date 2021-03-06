package com.llollox.algorithms.problems.crack.dynamic;

import com.llollox.algorithms.models.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RobotIntoGrid {


    /*
        Recursive solution in 2^(r+c)
     */
    public List<Point> robotInGrid(boolean[][] G) {

        if (G == null || G.length == 0) {
            return null;
        }

        ArrayList<Point> points = new ArrayList<>();

        this.robotInGrid(G, G.length - 1, G[0].length - 1, points);

        return points;
    }

    public boolean robotInGrid(boolean[][] G, int row, int col, List<Point> points) {

        if (row < 0 || col < 0 || !G[row][col]) {
            return false;
        }

        boolean isOrigin = row == 0 && col == 0;

        if (isOrigin
                || this.robotInGrid(G, row - 1, col, points)
                || this.robotInGrid(G, row, col - 1, points)) {

            Point p = new Point(col, row);
            points.add(p);
            return true;
        }

        return false;
    }




    /* Recursive solution with memoization */
    public List<Point> robotIntoGridMemoization (boolean[][] G) {

        if (G == null || G.length == 0) {
            return null;
        }
        ArrayList<Point> points = new ArrayList<>();
        this.robotIntoGridMemoization(G, G.length - 1, G[0].length - 1, points, new HashSet<Point>());
        return points;
    }

    public boolean robotIntoGridMemoization (boolean[][] G, int row, int col, List<Point> points, HashSet<Point> failurePoints) {

        // Outside bounds or cell off limits
        if (row < 0 || col < 0 || !G[row][col]) {
            return false;
        }

        Point point = new Point(col, row);

        // Already visited a failure node
        if (failurePoints.contains(point)) {
            return false;
        }

        boolean isOrigin = row == 0 && col == 0;

        // If path from origin found, return true and append nodes
        if (isOrigin
            || this.robotIntoGridMemoization(G, row -1, col, points, failurePoints)
            || this.robotIntoGridMemoization(G, row, col - 1, points, failurePoints)) {
            points.add(point);
            return true;
        }

        // If a failure point found, save this information
        failurePoints.add(point);
        return false;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ArrayList<Point> getPath(boolean[][] matrix) {
        if (matrix == null) {
            return null;
        }

        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> deadPoints = new HashSet<>();
        path.add(new Point(0, 0));
        if (calculatePath(0, 0, matrix, path, deadPoints)) {
            return path;
        }

        return null;
    }

    boolean calculatePath(int i, int j, boolean[][] matrix, ArrayList<Point> path,
                          HashSet<Point> deadPoints) {
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return true;
        }

        Point p = new Point(i, j);

        if (deadPoints.contains(p)) {
            return false;
        }

        if (canMoveRight(i, j, matrix)) {
            path.add(new Point(i, j + 1));
            if (calculatePath(i, j + 1, matrix, path, deadPoints)) {
                return true;
            }
        }
        else if (canMoveDown(i, j, matrix)) {
            path.add(new Point(i + 1, j));
            if (calculatePath(i + 1, j, matrix, path, deadPoints)) {
                return true;
            }
        }

        deadPoints.add(p);
        return false;
    }

    private boolean canMoveRight(int i, int j, boolean[][] matrix) {
        return j < matrix[0].length - 1 && matrix[i][j + 1];
    }

    private boolean canMoveDown(int i, int j, boolean[][] matrix) {
        return i < matrix.length - 1 && matrix[i + 1][j];
    }

}
