package edu.csu.leetcode.hot100.array;

public class RotateSearch {

    public static void main(String[] args) {
        int[] input = new int[]{3,1};
        int target = 3;
        RotateSearch solution = new RotateSearch();
        int res = solution.search(input, target);
        System.out.println(res);
    }

    boolean flag = false;
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }

        int res = 0;
        int rotate = getRotateIndex(nums);
        if(flag) return binarySearch(nums,0,nums.length - 1,target);
        if(nums[0] <= target) return binarySearch(nums,0,rotate,target);
        return binarySearch(nums,rotate + 1,nums.length - 1,target);
    }

    private int getRotateIndex(int[] nums){
        if(nums == null || nums.length == 0) return -1;
        int left = 0,right = nums.length - 1;
        if(nums[left] < nums[right]){
            flag = true;
            return 0;
        }
        if (nums.length == 2) return 0;
        while(left < right){
            int rotate = left + (right - left) / 2;
            if(nums[rotate] > nums[rotate + 1]) return rotate;
            else if(nums[rotate] < nums[right]){
                right = rotate;
            }else {
                left = rotate;
            }
        }
        return 0;
    }

    private int binarySearch(int[] nums,int left,int right,int target){
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
