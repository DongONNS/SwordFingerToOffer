package edu.csu.leetcode.binarySearch;

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
