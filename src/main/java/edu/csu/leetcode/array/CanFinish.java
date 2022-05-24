package edu.csu.leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author dongcheng_2018@163.com
 * @Date 2022/5/25 0:43
 */
public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        List<List<Integer>> adj = new ArrayList();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList());
        }

        for (int[] arr : prerequisites) {
            in[arr[0]]++;
            adj.get(arr[1]).add(arr[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.remove();
            --numCourses;
            for (int next : adj.get(curr)) {
                if (--in[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return numCourses == 0;
    }
}
