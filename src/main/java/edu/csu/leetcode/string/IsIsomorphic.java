package edu.csu.leetcode.string;

public class IsIsomorphic {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] preIndexS = new int[256];
        int[] preIndexT = new int[256];

        for(int i = 0;i < s.length();i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if(preIndexS[sc] != preIndexT[tc])
                return false;
            // 注意这里使用的i+1而不是i,否则会导致出错
            preIndexS[sc] = i + 1;
            preIndexT[tc] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        String sc = "ab";
        String tc = "aa";

        boolean res = isIsomorphic(sc, tc);

        System.out.println(res);
    }
}
