package edu.csu.swordFingerOffer.firstPractice.problem4;

public class ReplaceSpace {
    public static void main(String[] args) {
        String string = "we are    happy";
        String ans = replaceSpace(string);
        System.out.println(ans);
    }

    public static String replaceSpace(String string){
        int length = string.length();
        char[] array = new char[length*3];
        int size = 0;
        for (int i = 0;i < length;i++){
            char c = string.charAt(i);
            if (c == ' '){
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            }else
                array[size++]=c;
        }
        String ans = new String(array,0,size);
        return ans;
    }

//    public static String replaceSpace(String string){
//        String ans = string.replaceAll(" ", "%20");
//        return ans;
//    }
}
