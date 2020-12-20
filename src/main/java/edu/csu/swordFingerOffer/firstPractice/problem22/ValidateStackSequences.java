package edu.csu.swordFingerOffer.firstPractice.problem22;

import java.util.Stack;
//给定两个数组，一个代表栈的压入序列，另一个代表栈的输出序列
//判读这个输出序列是否是压入序列的输入序列
//eg 1 2 3 4 5  ==> 4 5 3 2 1  这个是正确的
//   1 2 3 4 5  ==> 4 3 5 1 2  这个则是错误的
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed,int[] popped){
        if(pushed.length != popped.length) return false;
        Stack<Integer> stack = new Stack<Integer>();
        int length = popped.length;
        int index = 0;
        for(int i = 0;i < length;i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty() && i < length && stack.peek() == popped[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
