package edu.csu.swordFingerOffer;

public class ReverseLeftWords {
        public String reverseLeftWords(String s, int n) {
            String res = "";
            for(int i = n; i < n + s.length(); i++)
                res += s.charAt(i % s.length());
            return res;
        }

}
