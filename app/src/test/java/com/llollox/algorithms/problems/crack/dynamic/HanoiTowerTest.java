package com.llollox.algorithms.problems.crack.dynamic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class HanoiTowerTest {

    private HanoiTower hanoiTower = new HanoiTower();

    @Test
    public void hanoiReImplemented() {
        ArrayList<String> moves = hanoiTower.hanoiReImplemented(3);
        Assert.assertEquals(7, moves.size());
    }
}