package edu.csu.swordFingerOffer.secondPractice;

import java.util.ArrayList;

public class GetLeastNumbers_Version2 {
    public ArrayList<Integer> getLeastNumbers(int[] nums, int k){
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > nums.length || k <= 0)
            return ret;
        findKthSmallest(nums,k - 1);

        for (int i = 0;i < k;i++){
            ret.add(nums[i]);
        }

        return ret;
    }

    /**
     * 改变数组，使得前k个数都是最小的k个数
     * @param nums
     * @param k
     */
    private void findKthSmallest(int[] nums, int k) {
        int low = 0,high = nums.length - 1;
        while(low < high){
            int j = partition(nums,low,high);
            if (j == k) break;
            if (j > k) high = j - 1;
            else low = j + 1;
        }
    }

    private int partition(int[] nums,int low,int high){
        int comp = nums[low];   // 切分元素
        int i = low,j = high + 1;
        while(true){
            // 从左向右推
            while(i != high && nums[i] < comp) i++;
            // 从右向左推
            while(j != low && nums[j] > comp) j--;
            if (i >= j) break;
            swap(nums,i,j);
        }
        swap(nums,low,j);
        return j;
    }


    /**
     * 交换数组i j位置的元素
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
