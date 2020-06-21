package edu.csu.leetcode.fenzhi;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute {
    public List<Integer> diffWaysToCompute(String input){
        //用于存储最终的结果
        List<Integer> ways = new ArrayList<>();

        for (int i = 0;i < input.length();i++){
            char c = input.charAt(i);
            //如果遇到的是运算符，那么将其分成运算符左右两部分
            if (c == '+' || c == '-' || c == '*'){
                //计算左边部分可以组成的值
                List<Integer> left  = diffWaysToCompute(input.substring(0,i));
                //计算右边部分可以组成的值
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left){
                    for (int r : right){
                        //将左边部分 与 右边部分 按照运算符 c 进行运算
                        switch (c) {
                            case '+':
                                ways.add(l + r);
                                break;
                            case '-':
                                ways.add(l - r);
                                break;
                            case '*':
                                ways.add(l * r);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        // 若是没有得到相应的运算结果，那说明没有运算符号
        //将字符串转换成Integer类型再输出即可
        if (ways.size() == 0)
            ways.add(Integer.valueOf(input));
        return ways;
    }
}
