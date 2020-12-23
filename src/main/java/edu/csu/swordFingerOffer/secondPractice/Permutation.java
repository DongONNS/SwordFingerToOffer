package edu.csu.swordFingerOffer.secondPractice;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
    ArrayList<String> res = new ArrayList();
    public ArrayList<String> permutation(String str) {
        // 判空
        if(str.length() == 0)   return res;

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backTrack(chars,new boolean[str.length()],new StringBuilder());

        return res;
    }

    //
    private void backTrack(char[] array,boolean[] hasUsed,StringBuilder tempCom){
        if(tempCom.length() == array.length){
            res.add(tempCom.toString());
            return;
        }

        for(int i = 0;i < array.length;i++){
            if(hasUsed[i]  || (i!= 0 && array[i] == array[i - 1] && !hasUsed[i - 1])){
                continue;
            }

            hasUsed[i] = true;
            tempCom.append(array[i]);
            backTrack(array,hasUsed,tempCom);
            tempCom.deleteCharAt(tempCom.length() - 1);
            hasUsed[i] = false;
        }
    }
}
