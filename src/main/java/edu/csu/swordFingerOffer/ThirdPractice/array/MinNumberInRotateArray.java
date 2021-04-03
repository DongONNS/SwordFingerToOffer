package edu.csu.swordFingerOffer.ThirdPractice.array;

public class MinNumberInRotateArray {
    public static int minNumberInRotateArray(int [] array) {
        // 判空操作
        if(array.length == 0){
            return 0;
        }

        //二分查找
        int left = 0,right = array.length - 1;
        // 此处写成mid = left是因为当[left,right]本身就是有序数组时，可以直接返回最小的第一个数字
        int mid = left;
        while(array[left] >= array[right]){
            if (right - left == 1){
                mid = right;
                break;
            }

            mid = left + (right - left) / 2;

            // 如果left mid right三个位置对应的元素是一样的，那么就采用顺序查找
            if(array[left] == array[right] && array[left] == array[mid]){
                return orderSearch(array,left,right);
            }

            if (array[mid] >= array[left]){
                left = mid;
            }else {
                right = mid;
            }
        }
        return array[mid];
    }

    /**
     * 顺序查找
     */
    private static int orderSearch(int[] array,int left,int right){
        int res = array[left];
        for(int i = left + 1;i <= right;i++){
            if(res > array[i]){
                res = array[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = new int[]{6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        int res = minNumberInRotateArray(array);
        System.out.println(res);
    }
}
