package com.llollox.algorithms.problems.crack.dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StackOfBoxes {

    public static class Box {
        int h;
        int w;
        int d;

        public Box(int h, int w, int d) {
            this.h = h;
            this.w = w;
            this.d = d;
        }

        public boolean canBeOnTop(Box box) {
            if (box == null || box.h <= 0 || box.d <= 0 || box.w <= 0) {
                return false;
            }

            return box.h < this.h && box.w < this.w && box.d < this.d;
        }
    }

    public int stackOfBoxes(ArrayList<Box> boxes) {
        if (boxes == null || boxes.isEmpty()) return 0;
        // Sorted asc order
        Collections.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box box1, Box box2) {
                return Integer.compare(box2.h, box1.h);
            }
        });
        return stackOfBoxesHelper(boxes, 0, null);
    }

    public int stackOfBoxesHelper(ArrayList<Box> boxes, int index, Box top) {
        if (index == boxes.size()) {
            return 0;
        }

        Box box = boxes.get(index);
        int withBox = 0;
        if (top == null || top.canBeOnTop(box)) {
            withBox = box.h + stackOfBoxesHelper(boxes, index + 1, box);
        }

        int withoutBox = stackOfBoxesHelper(boxes, index + 1, top);

        return Math.max(withBox, withoutBox);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public int stackOfBoxesMemo(ArrayList<Box> boxes) {
        if (boxes == null || boxes.isEmpty()) return 0;
        // Sorted asc order
        Collections.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box box1, Box box2) {
                return Integer.compare(box2.h, box1.h);
            }
        });
        int[] memo = new int[boxes.size()];
        return stackOfBoxesHelper(boxes, 0, null, memo);
    }

    public int stackOfBoxesHelper(ArrayList<Box> boxes, int index, Box top, int[] memo) {
        if (index == boxes.size()) {
            return 0;
        }

        Box box = boxes.get(index);
        int withBox = 0;
        if (top == null || top.canBeOnTop(box)) {
            if (memo[index] == 0) {
                withBox = box.h + stackOfBoxesHelper(boxes, index + 1, box, memo);
            }
            memo[index] = withBox;
        }

        int withoutBox = stackOfBoxesHelper(boxes, index + 1, top, memo);

        return Math.max(withBox, withoutBox);
    }


}
