package edu.csu.problem8;

//给定一个递增数组旋转后的数组，找出数组中的最小值
//如{1，2，3，4，5} --> {3,4,5,1,2} 最小值为1
public class MinNumber {

    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }
//    public static int findMinNumber(int[] array){
//        if (array==null || array.length <=0)
//            throw new RuntimeException("Invalid parameters");
//        int left = 0,right = array.length-1;
//        int indexMid = left;
//        while(array[left] >= array[right]){
//            if (right - left == 1){
//                indexMid = right;
//                break;
//            }
//            indexMid = (left + right) / 2;
//            //如果我们left right indexMid三个下表对应的值相等，那么只能遍历查找
//            if (array[left] == array[right] && array[left] == array[indexMid]){
//                return minInOrder(array,left,right);
//            }
//            if (array[indexMid]>=array[left])
//                left = indexMid;
//            else if (array[indexMid] <= array[right])
//                right = indexMid;
//        }
//        return array[indexMid];
//    }
//    public static int minInOrder(int[] array,int left,int right){
//        int min = Integer.MAX_VALUE;
//        for (int i = left;i < right;i++){
//            if (array[i] < min)
//                min = array[i];
//        }
//        return min;
//    }
}
