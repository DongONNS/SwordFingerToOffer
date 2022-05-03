package edu.csu.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dongcheng_2018@163.com
 * @date 2022/5/3 23:18
 */
public class CombinationSum {
    /**
     * 符合条件的路径.
     */
    private List<Integer> path = new ArrayList<>();

    /**
     * 组合总数.
     */
    private List<List<Integer>> res = new ArrayList<>();

    /**
     * 组合总数.
     * @param candidates 候选集
     * @param target 目标值
     * @return 组合总数
     */
    public List<List<Integer>> combinationSum(final int[] candidates,
                                              final int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        backTrack(candidates, target, 0);
        return res;
    }

    /**
     * 组合总数.
     * @param arr 初始数组
     * @param target 目标值
     * @param begin 起始位置（保证输出结果唯一）
     */
    private void backTrack(final int[] arr, final int target, final int begin) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < arr.length; i++) {
            if (arr[i] <= target) {
                path.add(arr[i]);
                backTrack(arr, target - arr[i], i);
                path.remove(path.size() - 1);
            }
        }
    }
}
