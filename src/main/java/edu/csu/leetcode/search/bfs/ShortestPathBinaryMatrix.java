package edu.csu.leetcode.search.bfs;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //非空判断
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        //遍历方向
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int m = grid.length, n = grid[0].length;

        //用于在遍历中存储每一层的节点
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        // 添加首节点
        queue.add(new Pair<>(0, 0));
        int pathLength = 0;
        //遍历每一层
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {

                //弹出上一次遍历存储的本层节点
                Pair<Integer, Integer> cur = queue.poll();

                //获取当前的位置 current row ,current column
                int cr = cur.getKey(), cc = cur.getValue();


                if (grid[cr][cc] == 1) {
                    continue;
                }

                //到达了节点的末尾
                if (cr == m - 1 && cc == n - 1) {
                    return pathLength;
                }

                // 遍历完后，将节点进行标记
                grid[cr][cc] = 1;

                //按照遍历顺序将节点添加到队列中
                for (int[] d : direction) {
                    int nr = cr + d[0], nc = cc + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }
}
