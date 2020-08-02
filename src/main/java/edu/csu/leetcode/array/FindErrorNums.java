package edu.csu.leetcode.array;

public class FindErrorNums {

    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[nums.length + 1];
        int dup = -1, missing = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] += 1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0)
                missing = i;
            else if (arr[i] == 2)
                dup = i;
        }
        return new int[]{dup, missing};
    }


//    public int[] findErrorNums(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
//                swap(nums, i, nums[i] - 1);
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != i + 1) {
//                return new int[]{nums[i], i + 1};
//            }
//        }
//        return null;
//    }
//
//    private void swap(int[] nums, int i, int j) {
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }

    // public int[] findErrorNums(int[] nums) {
    //     Map<Integer,Integer> map = new HashMap();

    //     //存储数据的个数
    //     for(int num : nums){
    //         map.put(num,map.getOrDefault(num,0) + 1);
    //     }

    //     //从map中数字的个数得到dup和missing
    //     int dup = -1,miss = -1;
    //     for(int i = 1;i <= nums.length;i++){
    //         if(map.containsKey(i)){
    //             if(map.get(i) == 2)
    //                 dup = i;
    //         }else {
    //             miss = i;
    //         }
    //     }
    //     return new int[]{dup,miss};
    // }
}
