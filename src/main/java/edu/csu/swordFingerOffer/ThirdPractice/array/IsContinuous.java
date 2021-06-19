package edu.csu.swordFingerOffer.ThirdPractice.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsContinuous {
    public static void main(String[] args) {
        int[] src = new int[]{6,0,2,0,4};
        boolean res = IsContinuous(src);
        System.out.println(res);
    }

    public static boolean IsContinuous(int [] numbers) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet();

        for(int num : numbers){
            if(num != 0 && set.contains(num)){
                return false;
            } else if (num != 0){
                set.add(num);
            }
            if (num != 0){
                low = Math.min(low,num);
                high = Math.max(high,num);
            }
        }
        return high - low < 5 || set.isEmpty();
    }
}
