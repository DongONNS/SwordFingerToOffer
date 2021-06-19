package edu.csu.swordFingerOffer.ThirdPractice.array;

import java.util.ArrayList;

public class FindContinuousSequence {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = FindContinuousSequence(9);
        System.out.println(res);
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int left = 1,right = 2;

        while(right < sum){
            ArrayList<Integer> path = new ArrayList();
            int tempSum = 0;

            for(int i = left;i <= right;i++){
                path.add(i);
                tempSum += i;
            }

            if(tempSum == sum){
                res.add(new ArrayList(path));
                left++;
                right++;
            }else if(tempSum > sum){
                left++;
            }else {
                right++;
            }
        }
        return res;
    }
}
