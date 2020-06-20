package edu.csu.leetcode.Greedy;

public class IsSubsequence {
    public boolean isSubsequence(String s,String t){
        int index = -1;
        for(char c : s.toCharArray()){
            //从index + 1开始查找查找字符c，如果存在则返回其索引
            //否则返回-1
            index = t.indexOf(c,index + 1);
            if (index == -1)
                return false;
        }
        return true;
    }
}
