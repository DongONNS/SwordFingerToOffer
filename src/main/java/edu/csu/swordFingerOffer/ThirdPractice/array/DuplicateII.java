package edu.csu.swordFingerOffer.ThirdPractice.array;

public class DuplicateII {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,0,2,5,3};
        int res = duplicate(arr);
        System.out.println(res);
    }

    public static int duplicate (int[] numbers) {
        if(numbers == null || numbers.length == 0) return 0;

        for(int i = 0;i < numbers.length;i++){
            if(numbers[i] != i){
                while(numbers[i] != numbers[numbers[i]]){
                    swap(numbers,i,numbers[i]);
                }
                return numbers[i];
            }
        }
        return 0;
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
