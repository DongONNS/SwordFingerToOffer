package edu.csu.leetcode.Sort;

public class SortColor {
    public void sortColor(int[] nums){
        quick3Way(nums,0,nums.length - 1);
    }
    private void quick3Way(int[] nums,int lo,int hi){
        if (hi < lo) return;
        //中间元素
        int medium = nums[lo];

        //lt用于指向小于Medium的最后一个元素，gt用于指向大于medium的第一个元素
        int lt = lo,gt = hi;
        int i = lo + 1;

        while(i <= gt){
            //如果i处元素值小于中间值，交换lt位置元素值并修改指针位置
            if (nums[i] < medium) swap(nums,i++,lt++);
            //如果i处的元素值大于中间值，交换gt位置元素并修改指针位置
            else if (nums[i] > medium) swap(nums,i,gt--);
            //如果本身就是中间元素，那就直接将i指针前移
            else i++;
        }
        quick3Way(nums,lo,lt - 1);
        quick3Way(nums,gt + 1,hi - 1);
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
