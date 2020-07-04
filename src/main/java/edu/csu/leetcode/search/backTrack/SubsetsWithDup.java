package edu.csu.leetcode.search.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        //排序
        Arrays.sort(nums);

        //结果集
        List<List<Integer>> res = new ArrayList<>();

        //遍历的结果
        List<Integer> path = new ArrayList();

        boolean[] visited = new boolean[nums.length];

        for(int size = 0;size <= nums.length;size++){
            backTrack(0,path,res,visited,size,nums);
        }

        return res;
    }
    private static void backTrack(int start,List<Integer> path,List<List<Integer>> res,boolean[] visited,int size,int[] nums){
        //递归终止条件
        if(path.size() == size){
            res.add(new ArrayList(path));
            return ;
        }

        for(int i = start;i < nums.length;i++){
            //剪枝
            if(i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;

            path.add(nums[i]);
            visited[i] = true;

            backTrack(i + 1,path,res,visited,size,nums);

            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> res = subsetsWithDup(nums);
        for(List<Integer> list : res){
            System.out.println(list.toString());
        }
    }
}
