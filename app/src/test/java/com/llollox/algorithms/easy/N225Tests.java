package com.llollox.algorithms.easy;

import org.junit.Assert;
import org.junit.Test;
import com.llollox.algorithms.problems.easy.N225_ImplementStackUsingQueues;

public class N225Tests {

    @Test
    public void test1() {
        N225_ImplementStackUsingQueues.MyStack stack = new N225_ImplementStackUsingQueues.MyStack();
        stack.push(1);
        stack.push(2);
        Assert.assertEquals(2, stack.top());
        Assert.assertEquals(2, stack.pop());
        Assert.assertEquals(false, stack.empty());
    }

    @Test
    public void test2() {
        N225_ImplementStackUsingQueues.MyStack stack = new N225_ImplementStackUsingQueues.MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertEquals(3, stack.top());
        Assert.assertEquals(false, stack.empty());
    }
}
