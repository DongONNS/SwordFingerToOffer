package edu.csu.swordFingerOffer.ThirdPractice.array;

public class Duplicate {
    public int duplicate (int[] numbers) {
        // 遍历数组中的每一个位置
        for(int i = 0; i < numbers.length; i++){
            while(numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]){
                    return numbers[i];
                }
                swap(numbers,i,numbers[i]);
            }
            swap(numbers,i,numbers[i]);
        }
        return -1;
    }

    private void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
