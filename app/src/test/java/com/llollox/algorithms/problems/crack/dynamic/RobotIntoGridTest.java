package com.llollox.algorithms.problems.crack.dynamic;

import com.llollox.algorithms.models.Point;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RobotIntoGridTest {

    private RobotIntoGrid robotIntoGrid = new RobotIntoGrid();

    @Test
    public void getPath() {
        boolean[][] matrix = {
                {true, true, false, true},
                {false, true, true, false},
                {true, false, true, true}
        };

        ArrayList<Point> points = robotIntoGrid.getPath(matrix);
        Assert.assertEquals(6, points.size());
        Assert.assertEquals(0, points.get(0).x);
        Assert.assertEquals(0, points.get(0).y);

        Assert.assertEquals(2, points.get(5).x);
        Assert.assertEquals(3, points.get(5).y);
    }
}