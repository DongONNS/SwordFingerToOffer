package edu.csu.JiuZhang.kuaishou;

import java.util.Objects;
import java.util.Stack;

//给定一个字符串，逐个翻转字符串中的每个单词。
//        Example
//        样例  1:
//        输入:  "the sky is blue"
//        输出:  "blue is sky the"
public class ReverseWords {
    public static String reverseWords(String string){
        if (string == null || string.length() == 0) return "";
        String[] array = string.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1;i >= 0;i--){
            if (!array[i].equals("")){
                if (sb.length() > 0) sb.append(" ");
                sb.append(array[i]);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String string = "the   sky is blue";
        String res = reverseWords(string);
        System.out.println(res);
    }
}

//    写废了......
//    public static String reverseWords(String string){
//        if (string == null || string.length() == 0) return null;
//        String trim = string.trim();
//        Stack<String> auxStack = new Stack();
//        int slow = 0,fast = 0;
//        //将单词逐个存入到栈中
//        String temp;
//        while(fast < trim.length()){
//            if (trim.charAt(fast) == ' '){
//                temp = trim.substring(slow,fast);
//                auxStack.push(temp);
//                while(trim.charAt(fast) == ' ') fast++;
//                slow = fast;
//            } else if (fast == trim.length()-1){
//                temp = trim.substring(slow,trim.length());
//                auxStack.push(temp);
//            }
//            fast++;
//        }
//        StringBuilder sb = new StringBuilder();
//        boolean period = false;
//        while(!auxStack.isEmpty()){
//            temp = auxStack.pop();
//            if (temp == ".") period = true;
//            else
//                sb.append(temp+" ");
//        }
//        sb.deleteCharAt(sb.length()-1);
//        if (period) sb.append(".");
//        return sb.toString();
//    }
