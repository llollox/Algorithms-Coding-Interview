package com.llollox.algorithms.problems.crack.bitmanipulation;

public class DrawLine {

    /*
        A monochrome screen is stored as a single array of bytes,
        allowing eight consecutive pixels to be stored in one byte.
        The screen has width w, where w is divisible by 8 (that is, no byte will be split across rows).
        The height of the screen, of course, can be derived from the length of the array and the width.
        Implement a function that draws a horizontal line from (xl, y) to (x2, y).
        The method signature should look something like:
        drawLine(byte[] screen, int width, int xl, int x2, int y)
     */

    public void drawLine(byte[] screen, int width, int x1, int x2, int y) {

        int firstFullPosition = y * (width / 8) + x1 / 8 + (x1 % 8 == 0 ? 0 : 1);
        int lastFullPosition = y * (width / 8) + x2 / 8 - (x2 % 8 == 0 ? 0 : 1);

        for (int i=firstFullPosition; i<=lastFullPosition; i++) {
            screen[i] = (byte) 0xFF;
        }

        if (x1 % 8 > 0) {
            byte startMask = (byte) (0xFF >> x1 % 8);
            screen[firstFullPosition - 1] = (byte) (screen[firstFullPosition - 1] | startMask);
        }

        if (x2 % 8 > 0) {
            byte endMask = (byte) (0xFF << (8 - x2 % 8));
            screen[lastFullPosition + 1] = (byte) (screen[lastFullPosition - 1] | endMask);
        }
    }
}
