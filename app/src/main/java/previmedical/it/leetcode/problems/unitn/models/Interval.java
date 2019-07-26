package previmedical.it.leetcode.problems.unitn.models;

public class Interval {
    public int start;
    public int end;
    public int profit;

    public Interval(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }

    public int length() {
        return end - start;
    }
}