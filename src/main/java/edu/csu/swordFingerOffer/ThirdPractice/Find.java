package edu.csu.swordFingerOffer.ThirdPractice;

public class Find {
    public boolean Find(int target, int [][] array) {
        // 判空
        if(array == null || array.length == 0 || array[0].length == 0){
            return false;
        }

        int rows = array.length,cols = array[0].length;

        int i = 0,j = cols - 1;
        while(i < rows && j >= 0){
            if(array[i][j] > target){
                i--;
            }else if ( array[i][j] < target){
                j++;
            }else{
                return true;
            }
        }
        return false;
    }
}
