package edu.csu.leetcode.binarySearch;

/*
题目描述：一个有序数组只有一个数不出现两次，找出这个数。

要求以 O(logN) 时间复杂度进行求解，
因此不能遍历数组并进行异或操作来求解，这么做的时间复杂度为 O(N)。


例题：
Input: [1, 1, 2, 3, 3, 4, 4, 8, 8]
Output: 2
 */


public class SingleNonDuplicate {
    public static int singleNonDuplicate(int[] nums){
        int left = 0,right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;

            //left mid right都在偶数位，使得查找区间大小一直都是奇数
            if (mid % 2 == 1)
                mid--;

            //如果mid与其后一位是成对的，那么我们的单个元素在[mid + 2,right]之间
            //否则单个元素在[left,mid]之间
            if (nums[mid] == nums[mid + 1])
                left = mid + 2;
            else
                right = mid;

        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        int res = singleNonDuplicate(nums);
        System.out.println(res);
    }
}
