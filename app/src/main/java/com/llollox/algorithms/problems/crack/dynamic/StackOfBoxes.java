package com.llollox.algorithms.problems.crack.dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

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

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public int stackOfBoxesDP(ArrayList<Box> boxes) {
        if (boxes == null || boxes.isEmpty()) return 0;
        // Sorted asc order
        Collections.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box box1, Box box2) {
                return Integer.compare(box1.h, box2.h);
            }
        });
        return stackOfBoxesHelper(boxes, new int[boxes.size()]);
    }

    public int stackOfBoxesHelper(ArrayList<Box> boxes, int[] heightFromBox) {
        int max = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int maxWithI = tallestStackHeight(boxes, i, heightFromBox);
            heightFromBox[i] = maxWithI;
            max = Math.max(max, maxWithI);
        }
        return max;
    }

    private int tallestStackHeight(ArrayList<Box> boxes, int boxIndex, int[] heightFromBox) {

        Box box = boxes.get(boxIndex);
        int max = box.h;

        for (int j = 0; j < boxIndex; j++) {
            Box top = boxes.get(j);

            if (box.canBeOnTop(top)) {
                int height = box.h + heightFromBox[j];
                max = Math.max(height, max);
            }
        }

        return max;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    private static class BoxHeight {
        Box box;
        int height;

        public BoxHeight(Box box, int height) {
            this.box = box;
            this.height = height;
        }
    }

    public int stackOfBoxesDPOptimized(ArrayList<Box> boxes) {
        if (boxes == null || boxes.isEmpty()) return 0;

        // Sorted asc order N log N
        Collections.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box box1, Box box2) {
                return Integer.compare(box1.h, box2.h);
            }
        });

        PriorityQueue<BoxHeight> boxHeight = new PriorityQueue<>(new Comparator<BoxHeight>() {
            @Override
            public int compare(BoxHeight o1, BoxHeight o2) {
                return Integer.compare(o2.height, o1.height);
            }
        });

        int max = 0;
        // N
        for (int i = 0; i < boxes.size(); i++) {
            int maxWithI = tallestStackHeight(boxes, i, boxHeight); // N
            boxHeight.add(new BoxHeight(boxes.get(i), maxWithI)); // log N
            max = Math.max(max, maxWithI);
        }
        return max;
    }

    // O(N)
    private int tallestStackHeight(
            ArrayList<Box> boxes, int boxIndex, PriorityQueue<BoxHeight> boxHeights) {

        Box box = boxes.get(boxIndex);

        for (BoxHeight boxHeight : boxHeights) {
            Box top = boxHeight.box;
            if (box.canBeOnTop(top)) {
                return boxHeight.height + box.h;
            }
        }

        return box.h;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public int stackOfBoxesRecursive(ArrayList<Box> boxes) {
        if (boxes == null || boxes.isEmpty()) return 0;
        // Sorted asc order
        Collections.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box box1, Box box2) {
                return Integer.compare(box2.h, box1.h);
            }
        });

        int[] memo = new int[boxes.size()];
        int max = 0;
        for (int i = 0; i < boxes.size(); i++) {
            max = Math.max(max, stackOfBoxesHelperRecursive(boxes, i, memo));
        }
        return max;
    }

    public int stackOfBoxesHelperRecursive(ArrayList<Box> boxes, int bottom, int[] memo) {
        Box bottomBox = boxes.get(bottom);
        int max = 0;
        for (int i = bottom + 1; i < boxes.size(); i++) {
            Box top = boxes.get(i);
            if (bottomBox.canBeOnTop(top)) {
                max = Math.max(max, stackOfBoxesHelperRecursive(boxes, i, memo));
            }
        }
        return max + bottomBox.h;
    }
}
