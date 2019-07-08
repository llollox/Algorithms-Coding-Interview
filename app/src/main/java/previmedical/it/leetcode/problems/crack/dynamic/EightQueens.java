package previmedical.it.leetcode.problems.crack.dynamic;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EightQueens {

    /*
        Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board so
        that none of them share the same row, column, or diagonal.
        In this case, "diagonal" means all diagonals, not just the two that bisect the board.
     */



    private Set<Point> eightQueens(Set<Point> points, int n, int i) {
        if (points.size() == n) {
            return points;
        }

        for (int j=0; j<n; j++) {
            Point p = new Point(i, j);

            if (canBePlaced(points, p)) {

                points.add(p);

                this.eightQueens(points, n, i + 1);

                if (points.size() == n) {
                    return points; // Success
                }
                else {
                    points.remove(p);
                }
            }
        }

        return points;
    }

    public Set<Point> eightQueens(int n) {
        Set<Point> points = new HashSet<>();
        return this.eightQueens(points, n,0);
    }

    public boolean canBePlaced(Set<Point> points, Point p) {
        return !points.contains(p)
                    && !this.queenInSameColumn(points, p.j)
                    && !this.queenInSameRow(points, p.i)
                    && !this.queenInSameDiagonal(points, p);
    }

    private boolean queenInSameRow(Set<Point> points, int i) {
        for (Point point : points) {
            if (point.i == i) {
                return true;
            }
        }
        return false;
    }

    private boolean queenInSameColumn(Set<Point> points, int j) {
        for (Point point : points) {
            if (point.j == j) {
                return true;
            }
        }
        return false;
    }

    private boolean queenInSameDiagonal(Set<Point> points, Point p) {
        for (Point point : points) {
            int iDiff = point.i - p.i;
            int jDiff = point.j - p.j;
            if (iDiff == jDiff || iDiff == -jDiff) {
                return true;
            }
        }
        return false;
    }



    public class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return i == point.i &&
                    j == point.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
