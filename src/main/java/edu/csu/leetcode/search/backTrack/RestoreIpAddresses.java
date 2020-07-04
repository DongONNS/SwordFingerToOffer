package edu.csu.leetcode.search.backTrack;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList();
        //如果字符串的长度无法构成ip地址，那么直接返回
        if(s.length() < 4 || s.length() > 12) return res;

        StringBuilder tempAddress = new StringBuilder();
        //递归进行深度优先遍历所有的ip组合
        doRestore(0,tempAddress,res,s);
        return res;
    }

    /**
     * k ：代表的是递归的层数
     * tempAddress : 遍历过程中的ip地址
     * res : 结果集
     * s : 原字符串
     */
    private static void doRestore(int k,StringBuilder tempAddress,List<String> res,String s){
        //如果已经遍历了四层，或者s已经用尽了，那么直接返回
        if(k == 4 || s.length() == 0){
            //如果遍历四层并且刚好把s用尽，那么将tempAddress添加到结果集中
            if(k == 4 && s.length() == 0)
                res.add(tempAddress.toString());
            return ;
        }

        //每一层最多存储三个字符，所以i是在0-2之间的
        for(int i = 0;i < s.length() && i <= 2;i++){

            //剪枝，如果该部分长度大于1并且以0开头，那就直接返回
            if(i != 0 && s.charAt(0) == '0')
                break;
            //截取(0,i)，判断该part能否用于组成ip
            String part = s.substring(0,i + 1);
            if(Integer.valueOf(part) <= 255){
                //如果不是第一个part，那么增加一个“.”在中间
                if(tempAddress.length() != 0){
                    part = "." + part;
                }

                tempAddress.append(part);
                doRestore(k + 1,tempAddress,res,s.substring(i + 1));
                tempAddress.delete(tempAddress.length() - part.length(),tempAddress.length());
            }
        }
    }

    public static void main(String[] args) {
        String ip = "25525511135";
        List<String> restoreIpAddresses = restoreIpAddresses(ip);
        for (String address : restoreIpAddresses){
            System.out.println(address);
        }
    }
}
