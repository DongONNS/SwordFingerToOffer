package edu.csu.Top300;

import java.util.Arrays;
import java.util.Stack;

public class FinalDiscountedPrice {
    public static void main(String[] args) {
        int[] prices = {2,3,6,10,9,7,3,9,3,5};
        int[] res = finalDiscountedPrice(prices);
        System.out.println(Arrays.toString(res));
    }
    public static int[] finalDiscountedPrice(int[] prices) {
        if(prices.length == 0) return new int[0];
        int[] res = new int[prices.length];
        Stack<Integer> stack = new Stack();
        for(int i = 0;i < prices.length;i++){
            //初始化res数组为prices数组的值
            res[i] = prices[i];
            while(!stack.isEmpty() && res[stack.peek()] >= prices[i]){
                int index = stack.pop();
                res[index] -= prices[i];
            }
            stack.push(i);
        }
        return res;
    }
}
