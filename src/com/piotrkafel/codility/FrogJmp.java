package com.piotrkafel.codility;

/**
 * Count minimal number of jumps from position X to Y.
 */
public class FrogJmp {

    public static int solution(int X, int Y, int D) {
        return (int) Math.ceil((Y - X)/(double)D);
    }
}
