package com.llollox.algorithms.problems.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Collinear {

    /*
    Given a set of points P and an integer N,
    return all the lines (set of point) which are collinear and a number of elements
    greater or equal than N.

    Two points are always collinear, because there is always a line between two points.

    Given a line Line(gradient, shift) composed by two points p1, p2,
    and a third point p3 to be verified,
    they are collinear iif the line that passes between p1 and p3 is the same of the line between p1 and p2

     */

    public static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public class Line {
        private double gradient;
        private double shift;
        private HashSet<Point> points;
        private Point point1;

        Line(Point p1, Point p2) {
            this.point1 = p1;
            this.points = new HashSet<>();
            this.points.add(p1);
            this.points.add(p2);
            this.gradient = this.getGradient(p1, p2);
            this.shift = this.getShift(p1, p2);
        }

        public void add(Point p) {
            this.points.add(p);
        }

        public HashSet<Point> getPonts() {
            return this.points;
        }

        public boolean isCollinear(Point p) {
            return this.equals(new Line(this.point1, p));
        }

        private double getGradient(Point p1, Point p2) {
            if (p1.x - p2.x == 0) {
                return 0.0;
            }

            return (p1.y - p2.y) / (p1.x - p2.x);
        }

        private double getShift(Point p1, Point p2) {
            if (p2.x - p1.x == 0) {
                return 0.0;
            }

            return (p2.x * p1.y - p1.x * p2.y) / (p2.x - p1.x);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return Double.compare(line.gradient, gradient) == 0 &&
                    Double.compare(line.shift, shift) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(gradient, shift);
        }

        public boolean contains(Point p) {
            return this.points.contains(p);
        }
    }

    public List<HashSet<Point>> getCollinear(List<Point> points, int n) {
        if (points == null || points.size() < 2 || n > points.size()) {
            return new ArrayList<>();
        }

        ArrayList<Point> pointsList = new ArrayList<>(new HashSet<>(points));

        HashSet<Line> lines = new HashSet<>();
        for (int i=0; i<pointsList.size(); i++) {
            for (int j=i + 1; j<pointsList.size(); j++) {

                Point p1 = pointsList.get(i);
                Point p2 = pointsList.get(j);
                Line line = new Line(p1, p2);

                if (lines.contains(line)) {
                    // Line already considered
                    continue;
                }

                for (Point p3 : pointsList) {
                    if (!line.contains(p3) && line.isCollinear(p3)) {
                        line.add(p3);
                    }
                }

                lines.add(line);
            }
        }

        ArrayList<HashSet<Point>> found = new ArrayList<>();
        for (Line line : lines) {
            if (line.getPonts().size() >= n) {
                found.add(line.points);
            }
        }

        return found;
    }
}
