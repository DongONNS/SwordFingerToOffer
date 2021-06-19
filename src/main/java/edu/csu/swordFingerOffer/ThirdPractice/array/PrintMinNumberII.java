package edu.csu.swordFingerOffer.ThirdPractice.array;

public class PrintMinNumberII {

    public static void main(String[] args) {
        int[] src = new int[]{3,32,321};
        PrintMinNumberII obj = new PrintMinNumberII();
        String res = obj.PrintMinNumber(src);
        System.out.println("拼凑的结果为: " + res);
    }

    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0) return "";
        String[] array = new String[numbers.length];
        for (int i = 0;i < numbers.length;i++){
            array[i] = String.valueOf(numbers[i]);
        }

        quickSort(array);
        String res = new String();
        for(String str : array){
            res += str;
        }
        return res;
    }

    private void quickSort(String[] arr){
        int left = 0,right = arr.length - 1;
        int part = quickSort(arr,left,right);

        quickSort(arr,left,part - 1);
        quickSort(arr,part + 1,right);
    }

    private int quickSort(String[] arr,int left,int right){
        if(left > right) return -1;
        String comp = arr[left];
        int i = left + 1,j = right;
        while(true){
            while(i <= j && (arr[i] + comp).compareTo(comp + arr[i]) <= 0) i++;
            while(i <= j && (comp + arr[j]).compareTo(arr[j] + comp) <= 0) j--;
            if(i >= j) break;
            swap(arr,i,j);
        }
        swap(arr,left,j);
        return j;
    }

    private void swap(String[] arr,int i,int j){
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
