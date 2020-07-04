package edu.csu.leetcode.search.backTrack;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    public List<List<String>> partition(String s) {
        //存储遍历结果
        List<String> path = new ArrayList();

        //结果集
        List<List<String>> res = new ArrayList();

        //遍历所有可能的结果
        backTrack(s,path,res);

        return res;
    }

    //遍历所有可能的结果
    private void backTrack(String s,List<String> path,List<List<String>> res){
        //递归终止条件
        if(s.length() == 0){
            res.add(new ArrayList(path));
            return ;
        }

        //递归体
        for(int i = 0;i < s.length();i++){
            //如果前缀为回文串
            if(isPalindrome(s,0,i)){
                path.add(s.substring(0,i + 1));
                backTrack(s.substring(i + 1),path,res);
                path.remove(path.size() - 1);
            }
        }
    }

    //判断是否为回文字符串
    private boolean isPalindrome(String s,int left,int right){
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}
