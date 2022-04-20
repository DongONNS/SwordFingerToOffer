package edu.csu.leetcode.array;

import java.util.LinkedList;
import java.util.Queue;

public class UpdateMatrix {
    private static int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    private static int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        int[][] dist = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0;j < n;j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            for (int[] direction : directions) {
                int nextR = r + direction[0];
                int nextC = c + direction[1];
                if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && !seen[nextR][nextC]) {
                    dist[nextR][nextC] = dist[r][c] + 1;
                    queue.add(new int[]{nextR, nextC});
                    seen[nextR][nextC] = true;
                }
            }
        }
        return mat;
    }
}
