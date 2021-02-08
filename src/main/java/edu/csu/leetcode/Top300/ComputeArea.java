package edu.csu.leetcode.Top300;

public class ComputeArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long X = Math.max(0, (long)Math.min(G, C) - Math.max(A, E));
        long Y = Math.max(0, (long)Math.min(D, H) - Math.max(B, F));
        return (int)((long)(C - A) * (D - B) - X * Y + (G - E) * (H - F));
    }
}
