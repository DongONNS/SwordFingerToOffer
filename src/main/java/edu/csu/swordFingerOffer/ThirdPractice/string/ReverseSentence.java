package edu.csu.swordFingerOffer.ThirdPractice.string;

public class ReverseSentence {

    public static void main(String[] args) {
        String sentence = "I am a student.";
        String res = ReverseSentence(sentence);
        System.out.println("语句翻转的结果为: " + res);
    }

    public static String ReverseSentence(String str) {
        // 先讲单词进行逆转
        if(str == null || str.length() == 0) return str;
        char[] arr = str.toCharArray();
        for(int left = 0,right = 0;right <= str.length();right++){
            if(right == str.length() || arr[right] == ' '){
                reverse(arr,left,right - 1);
                left = right + 1;
            }
        }
        reverse(arr,0,arr.length - 1);
        StringBuilder sb = new StringBuilder();
        for(char ch : arr){
            sb.append(ch);
        }
        return sb.toString();
    }

    // 逆转数组子区间
    private static void reverse(char[] arr,int i,int j){
        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;j--;
        }
    }
}
