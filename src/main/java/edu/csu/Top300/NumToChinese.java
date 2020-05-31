package edu.csu.Top300;

public class NumToChinese {
    public static void main(String[] args) {
        int num = 100000003;
        String res = numToChinese(num);
        System.out.println(res);
    }

    static char[] numArr = {'零','一','二','三','四','五','六','七','八','九'};
    static String[] unitArr = {"","十","百","千","万"};
    public static String numToChinese(int num) {
        char[] newNum = String.valueOf(num).toCharArray();
        int len = newNum.length;
        StringBuilder res = new StringBuilder();
        for(int i=0;i<len;i++) {
            int temp = Integer.parseInt(String.valueOf(newNum[i]));
            boolean zeroFlag = temp==0 ? true : false;
            if(zeroFlag) {
                while(i<len-1 && newNum[i+1]=='0')
                    i++;
                if(i!=len-1) {
                    res.append(numArr[0]);
                }
            }else {
                res.append(numArr[temp]);
                res.append(unitArr[len-i-1]);
            }
        }
        return res.toString();
    }
}
