package com.llollox.algorithms.problems.crack.dynamic;

import com.llollox.algorithms.models.Point;

import java.util.HashSet;

public class PaintFill {

    public void paintFill(int[][] screen, int i, int j, int color) {
        if (screen == null || screen.length == 0) {
            return;
        }

        if (i < 0 || j < 0 || i >= screen.length || j >= screen[0].length) {
            return;
        }

        int currentColor = screen[i][j];
        if (currentColor == color) {
            return;
        }

        HashSet<Point> points = new HashSet<>();
        colorDfs(screen, i, j, currentColor, color, points);
    }

    private void colorDfs(int[][] screen, int i, int j, int currentColor, int newColor, HashSet<Point> visited) {
        if (isVisited(visited, i, j) || screen[i][j] != currentColor) {
            return;
        }

        visited.add(new Point(i, j));

        // Nord
        if (i > 0) {
            colorDfs(screen, i - 1, j, currentColor, newColor, visited);
        }

        // Est
        if (j < screen[0].length - 1) {
            colorDfs(screen, i, j + 1, currentColor, newColor, visited);
        }

        // West
        if (j > 0) {
            colorDfs(screen, i, j - 1, currentColor, newColor, visited);
        }

        // South
        if (i < screen.length - 1) {
            colorDfs(screen, i + 1, j, currentColor, newColor, visited);
        }

        screen[i][j] = newColor;
    }

    private boolean isVisited(HashSet<Point> visited, int i, int j) {
        return visited.contains(new Point(i, j));
    }
}
