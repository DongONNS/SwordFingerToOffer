package edu.csu.swordFingerOffer.firstPractice.problem3;

public class FindNumberIn2DArray {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},
                          {2,5,8,12,19},
                          {3,6,9,16,22},
                          {10,13,14,17,24},
                          {18, 21, 23, 26, 30}};
        boolean ans = findNumberIn2DArray(matrix, 20);
        System.out.println(ans);
    }
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int R = matrix.length;
        if (R == 0) return false;
        int C = matrix[0].length;
        for(int i = 0;i < R;i++){
            int ans = binarySearch(matrix[i],target);
            if(ans != -1) return true;
        }
        return false;
    }
    public static int binarySearch(int[] nums,int target){
        int ans = -1;
        int left = 0,right = nums.length-1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(nums[mid] < target) left = mid+1;
            else if(nums[mid] > target) right = mid-1;
            else return mid;
        }
        return ans;
    }
}
