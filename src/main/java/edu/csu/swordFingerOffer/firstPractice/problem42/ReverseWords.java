package edu.csu.swordFingerOffer.firstPractice.problem42;

public class ReverseWords {
    public String reverseWords(String string){
        string.trim();
        int j = string.length(),i = j;
        StringBuilder sb = new StringBuilder();
        while(i >= 0){
            while(i >= 0 && string.charAt(i) != ' ') i--;
            sb.append(string.substring(i+1,j+1) + " ");
            while(i >= 0 && string.charAt(i) == ' ') i--;
            j = i;
        }
        return sb.toString().trim();
    }
}
