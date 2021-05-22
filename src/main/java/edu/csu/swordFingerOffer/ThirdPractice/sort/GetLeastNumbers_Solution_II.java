package edu.csu.swordFingerOffer.ThirdPractice.sort;

import java.util.ArrayList;

public class GetLeastNumbers_Solution_II {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList();
        if(input == null || input.length == 0 || input.length < k || k <= 0){
            return res;
        }
        int part = 0;
        while(true){
            part = partition(input,0,input.length - 1);
            if(part == k - 1){
                break;
            }
        }

        for(int i = 0;i <= part;i++){
            res.add(input[i]);
        }
        return res;
    }

    // 查找数组中最左元素在数组中的位置
    private int partition(int[] arr,int left,int right){
        int comp = arr[left];
        int i = left + 1,j = right;

        while(true){
            while(i <= j && arr[i] <= comp){
                i++;
            }

            while(j >= i && arr[j] >= comp){
                j--;
            }

            if(i >= j){
                break;
            }

            swap(arr,i,j);
        }
        swap(arr,left,j);
        return j;
    }

    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
