package edu.csu.swordFingerOffer.secondPractice;

public class MinNumber {
    public String minNumber(int[] nums) {
        // 将数组中的数字转换成字符串数组
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);

        // 快排实现字符数组的排序
        fastSort(strs, 0, strs.length - 1);

        // 拼接结果字符串
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);

        return res.toString();
    }


    void fastSort(String[] strs, int l, int r) {
        if(l >= r) return;

        int i = l, j = r;
        String tmp = strs[i];
        while(i < j) {
            while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            swap(strs,i,j);
        }
        swap(strs,i,l);
        fastSort(strs, l, i - 1);
        fastSort(strs, i + 1, r);
    }

    //交换字符数组的字符串位置
    private void swap(String[] strs,int i,int j){
        String temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }
}
