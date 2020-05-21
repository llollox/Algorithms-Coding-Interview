package com.llollox.algorithms.problems.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class N893_GroupsSpecialEquivStringsTest {

    private N893_GroupsSpecialEquivStrings groupsSpecialEquivStrings = new N893_GroupsSpecialEquivStrings();

    @Test
    public void areSpecialEquiv() {
        Assert.assertEquals(groupsSpecialEquivStrings.hash("abcd"), groupsSpecialEquivStrings.hash( "cdab"));
        Assert.assertEquals(groupsSpecialEquivStrings.hash("abcd"), groupsSpecialEquivStrings.hash( "cbad"));
        Assert.assertNotEquals(groupsSpecialEquivStrings.hash("abcd"), groupsSpecialEquivStrings.hash( "zzxy"));
        Assert.assertEquals(groupsSpecialEquivStrings.hash("xyzz"), groupsSpecialEquivStrings.hash( "zzxy"));
        Assert.assertNotEquals(groupsSpecialEquivStrings.hash("xyzz"), groupsSpecialEquivStrings.hash( "zzyx"));
    }

    @Test
    public void areSpecialEquivFalse() {
        Assert.assertNotEquals(groupsSpecialEquivStrings.hash("abcd"), groupsSpecialEquivStrings.hash( "zzxy"));
    }

    @Test
    public void areSpecialEquivFalse2() {
        Assert.assertNotEquals(groupsSpecialEquivStrings.hash("ababaa"), groupsSpecialEquivStrings.hash("aaabaa"));
    }

    @Test
    public void numGroupsSpecialEquiv() {
        String[] input = {"abcd", "cdab", "cbad"};
        Assert.assertEquals(1, groupsSpecialEquivStrings.numSpecialEquivGroups(input));
    }

    @Test
    public void numGroupsSpecialEquiv2() {
        String[] input = {"abcd", "cdab", "cbad", "zzxy"};
        Assert.assertEquals(2, groupsSpecialEquivStrings.numSpecialEquivGroups(input));
    }

    @Test
    public void numGroupsSpecialEquiv3() {
        String[] input = {"abcd", "cdab", "cbad", "zzxy", "xyzz"};
        Assert.assertEquals(2, groupsSpecialEquivStrings.numSpecialEquivGroups(input));
    }

    @Test
    public void numGroupsSpecialEquiv4() {
        String[] input = {"abcd", "cdab", "cbad", "zzxy", "xyzz", "zzyx"};
        Assert.assertEquals(3, groupsSpecialEquivStrings.numSpecialEquivGroups(input));
    }
}
