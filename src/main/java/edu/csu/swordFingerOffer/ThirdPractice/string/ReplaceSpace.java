package edu.csu.swordFingerOffer.ThirdPractice.string;

public class ReplaceSpace {
    public static String replaceSpace (String s) {
        // 统计空格的数量
        int spaceCount = 0;
        for(char c : s.toCharArray()){
            if(c == ' ')
                spaceCount++;
        }

        int newLen = s.length() + spaceCount*2;
        char[] array = new char[newLen];
        int index = array.length - 1;
        // 从后往前获取字符
        for(int i = s.length() - 1;i >= 0;i--){
            // 如果不是空的字符，那么直接填充
            if(s.charAt(i) != ' '){
                array[index--] = s.charAt(i);
            }else {
                array[index--] = '0';
                array[index--] = '2';
                array[index--] = '%';
            }
        }
        return new String(array);
    }

    public static void main(String[] args) {
        String str = "We Are Happy";
        String res = replaceSpace(str);
        System.out.println(res);
    }
}
