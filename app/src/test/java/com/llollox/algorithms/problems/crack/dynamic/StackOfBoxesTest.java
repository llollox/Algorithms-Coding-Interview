package com.llollox.algorithms.problems.crack.dynamic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class StackOfBoxesTest {

    private StackOfBoxes stackOfBoxes = new StackOfBoxes();

    @Test
    public void stackOfBoxes() {
        ArrayList<StackOfBoxes.Box> boxes = new ArrayList<>();

        boxes.add(new StackOfBoxes.Box(5, 5, 5));
        boxes.add(new StackOfBoxes.Box(7, 7, 7));
        boxes.add(new StackOfBoxes.Box(9, 5, 4));
        boxes.add(new StackOfBoxes.Box(11, 11, 11));

        Assert.assertEquals(23, stackOfBoxes.stackOfBoxes(boxes));
    }

    @Test
    public void stackOfBoxesMemo() {
        ArrayList<StackOfBoxes.Box> boxes = new ArrayList<>();

        boxes.add(new StackOfBoxes.Box(5, 5, 5));
        boxes.add(new StackOfBoxes.Box(7, 7, 7));
        boxes.add(new StackOfBoxes.Box(9, 5, 4));
        boxes.add(new StackOfBoxes.Box(11, 11, 11));

        Assert.assertEquals(23, stackOfBoxes.stackOfBoxesMemo(boxes));
    }
}