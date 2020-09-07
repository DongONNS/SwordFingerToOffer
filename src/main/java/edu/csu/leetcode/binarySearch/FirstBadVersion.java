package edu.csu.leetcode.binarySearch;

/*
题目描述：给定一个元素 n 代表有 [1, 2, ..., n] 版本，在第 x 位置开始出现错误版本，
导致后面的版本都错误。可以调用 isBadVersion(int x) 知道某个版本是否错误，要求找到第一个错误的版本。

解题思路：
如果第 m 个版本出错，则表示第一个错误的版本在 [l, m] 之间，令 h = m；
否则第一个错误的版本在 [m + 1, h] 之间，令 l = m + 1。
因为 h 的赋值表达式为 h = m，因此循环条件为 l < h。
 */

public class FirstBadVersion {
    /**
     * 查找第一个错误版本
     * @param n 总共的版本数量
     * @return
     */
    public int firstBadVersion(int n){

        int left = 1,right = n;

        while(left < right){
            int mid = left + (right - left) / 2;

            //如果mid处为错误版本，那么将第一个错误版本在[left,mid]之间
            if(isBadVersion(mid))
                right = mid;
            //如果mid处不是错误版本，那么第一个错误版本在[mid + 1,right]之间
            else
                left = mid + 1;
        }
        return left;
    }

    /**
     * 此处是对是否为错误版本的判断函数模拟
     * @param n 待判断的版本号
     * @return
     */
    private boolean isBadVersion(int n){
        //doSomething
        return true;
    }
}
