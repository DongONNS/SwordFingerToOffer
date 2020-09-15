package edu.csu.leetcode.binarySearch;

public class FindMedianSortedArrays_version2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 让我们的nums1 成为更短的那个数组,缩小搜索的范围
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        // 我们的搜索范围可以缩小到[0,m]之间，这样我们的时间复杂度就成了O(log(m,n))
        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        // 这个是我们的分割线左侧的元素个数，这是一个统一的表达式
        int left_total = (m + n + 1) / 2;

        while(left < right){
            // 尝试要找的索引，在区间里完成二分
            int i = (left + right) / 2;

            // 因为我们的左侧元素总数量为left_total，所以nums2中剩余的元素数量为left_total - i;
            int j = left_total - i;

            // 如果第二个数组的左边最大数字大于第一个数组右边最小数字，查找区间则在[i + 1 , right]
            if(nums2[j - 1] > nums1[i])
                left = i + 1;
                // 否则边界区间在[left , i]之间
            else
                right = i;
        }

        // 退出循环时，交叉的小于等于关系必定成立，那么中位数就可以从边界线的两边的数组得到;
        int i = left;
        int j = left_total - left;

        // 考虑边界值的特殊情况
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];

        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        // 交叉小于等于关系成立，那么中位数就可以从“边界线”两边的数得到
        if((((m + n) & 1) == 1))
            return Math.max(nums1LeftMax,nums2LeftMax);
        else
            return (double)((Math.max(nums1LeftMax,nums2LeftMax) + Math.min(nums1RightMin,nums2RightMin))) / 2;
    }
}
