package edu.csu.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dongcheng_2018@163.com
 * @date 2022/5/4 23:56
 */
public class Permute {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(final int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] visited = new boolean[nums.length];
        backTrack(nums, visited);
        return res;
    }

    private void backTrack(final int[] nums, final boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            backTrack(nums, visited);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
