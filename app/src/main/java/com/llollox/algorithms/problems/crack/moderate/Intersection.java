package com.llollox.algorithms.problems.crack.moderate;

import com.llollox.algorithms.models.Point;

public class Intersection {

    /*
        Given two straight line segments (represented as a start point and an end point),
        compute the point of intersection, if any.
     */

    /*

        Solution 1.

        1. Calculate the equation for both lines.
        2. Get the intersection point, if exists
        3. Verify if the intersection point is within the bounds
            - Per entrambe le linee che x, y siano tra lo start ed end.

        (0,0)  (2,4)

     */


    public Point intersection(Point l1a, Point l1b, Point l2a, Point l2b) {
        int gradient1 = this.gradient(l1a, l1b);
        int c1 = l1a.y - gradient1 * l1a.x;

        int gradient2 = this.gradient(l2a, l2b);
        int c2 = l2a.y - gradient2 * l2a.x;

        // If they have different gradient they cannot intersect
        if (gradient1 == gradient2 && c1 != c2) {
            return null;
        }

        return l1a;
    }


    public int gradient(Point p1, Point p2) {
        return (p2.x - p1.x) / (p2.y - p1.y);
    }

}
