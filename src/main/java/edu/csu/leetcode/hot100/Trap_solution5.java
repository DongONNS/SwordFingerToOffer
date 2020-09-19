package edu.csu.leetcode.hot100;

import java.util.Arrays;
import java.util.Stack;

public class Trap_solution5 {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int res = trap(height);
        System.out.println(res);
    }

     public static int trap(int[] height){
         int sum = 0;
         Stack<Integer> stack = new Stack();
         int current = 0;
         while(current < height.length){

             // 当栈不为空并且当前位置墙的高度大于栈顶索引位置墙的高度
             while(!stack.isEmpty() && height[current] > height[stack.peek()]){
                 // 取出要出栈的元素
                 int h = height[stack.peek()];

                 // 出栈
                 stack.pop();

                 // 如果栈为空，那就直接出栈
                 if(stack.isEmpty())
                     break;

                 // 计算两堵墙之间的距离
                 int distance = current - stack.peek() - 1;
                 int min = Math.min(height[stack.peek()],height[current]);
                 sum += distance * (min - h);
             }
             // 将当前索引加入到队列中
             stack.push(current);
             current++;
         }
         return sum;
     }
}
