package edu.csu.swordFingerOffer.problem11;

public class MinArray {
    public int minArray(int[] numbers) {
        if(numbers.length == 0) return 0;
        int left = 0,right = numbers.length - 1;
        while(left < right){
            int mid = (left + right)>>1;
            //大于的话mid在左排序序列，目标值在右区间
            if(numbers[mid] > numbers[right]) left = mid+1;
                //小于的话mid在右排序序列，目标值在左区间
            else if (numbers[mid] < numbers[right]) right = mid;
                //相等的话直接将右边界减1，并不影响我们的取值
            else right--;
        }
        return numbers[left];
    }
}
