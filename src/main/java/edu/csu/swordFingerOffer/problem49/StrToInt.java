package edu.csu.swordFingerOffer.problem49;

public class StrToInt {
    public static void main(String[] args) {
        String str1 = "42";
        String str2 = "    -42";
        String str3 = "4193 with words";
        String str4 = "-91283472332";
        System.out.println(Integer.MAX_VALUE);
        int res = strToInt(str4);
        System.out.println(res);
    }
    public static int strToInt(String str){
        String trimStr = str.trim();
        boolean sign = true;
        long res = 0;
        //完成字符串的截取操作
        if (trimStr.charAt(0) == '-'){
            sign = false;
            trimStr = trimStr.substring(1,trimStr.length());
        }else if (trimStr.charAt(0) == '+')
            trimStr = trimStr.substring(1,trimStr.length());
        for (int i = 0;i < trimStr.length();i++){
            int c = trimStr.charAt(i)-'0';
            if (c < 0 || c > 9) break;
            res = res * 10 + c;
            if(res > Integer.MAX_VALUE) return sign?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        return (int)(sign?res:-res);
    }
}
