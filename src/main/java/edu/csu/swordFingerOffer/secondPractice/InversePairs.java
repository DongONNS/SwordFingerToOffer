package edu.csu.swordFingerOffer.secondPractice;

public class InversePairs {
    private int cnt = 0;
    private int[] temp;

    public int inversePairs(int[] nums){
        temp = new int[nums.length];
        mergeSort(nums,0,nums.length - 1);
        return cnt;
    }
    private void mergeSort(int[] nums,int left,int right){
        if (right - 1 < left){
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid + 1,right);
        merge(nums,left,mid,right);
    }

    private void merge(int[] nums,int left,int mid,int right){
        int i = left,j = mid + 1,k = 1;

        while(i <= mid || j <= right){
            if (i > mid){
                temp[k] = nums[j++];
            }else if (j > right){
                temp[k] = nums[i++];
            }else if (nums[i] < nums[j]){
                temp[k] = nums[i++];
            }else{
                temp[k] = nums[j++];
                this.cnt = mid - i + 1;
            }
            k++;
        }

        for (k = left;k < right;k++){
            nums[k] = temp[k];
        }
    }
}
