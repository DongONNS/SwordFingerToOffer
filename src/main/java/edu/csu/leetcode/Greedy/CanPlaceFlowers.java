package edu.csu.leetcode.Greedy;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int cnt = 0;
        for(int i = 0;i < len && cnt < n;i++){
            //如果已经种了花了 那么直接跳过
            if(flowerbed[i] == 1) continue;

            //pre用于记录i的前一个花坛
            int pre = i == 0 ? 0 : flowerbed[i - 1];

            //next用于记录后一个花坛
            int next = i == len - 1 ? 0 : flowerbed[i + 1];

            //如果是i及其前后都没有种花，那么将其进行种上花，并且修改cnt数量
            if(pre == 0 && next == 0){
                cnt++;
                flowerbed[i] = 1;
            }
        }
        return cnt >= n;
    }
}
