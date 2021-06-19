package edu.csu.swordFingerOffer.ThirdPractice.string;


public class LeftRotateString {

    public static void main(String[] args) {
        String str = "abcXYZdef";
        int rotateIndex = 3;
        String res = LeftRotateString(str, rotateIndex);
        System.out.println("旋转的结果为：" + res);
    }

    public static String LeftRotateString(String str,int n) {
        if(str == null || str.length() == 0) return str;
        char[] charArr = str.toCharArray();

        reverse(charArr,0,n - 1);
        reverse(charArr,n,str.length() - 1);

        reverse(charArr,0,str.length() - 1);
        StringBuilder sb = new StringBuilder();
        for(char ch : charArr){
            sb.append(ch);
        }
        return sb.toString();
    }

    // 将字符数组进行翻转
    private static  void reverse(char[] arr,int i,int j){
        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }
}
