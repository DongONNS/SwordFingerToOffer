package edu.csu.swordFingerOffer.ThirdPractice.array;

public class InversePairs {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,0};
        InversePairs inversePairs = new InversePairs();
        int res = inversePairs.InversePairs(arr);
        System.out.println(res);

    }

    private int sum;
    int[] temp;
    public int InversePairs(int [] array) {
        if(array == null || array.length == 0) return 0;
        int left = 0;
        int right = array.length - 1;
        temp = new int[array.length];
        mergeSort(array,left,right);
        return sum % 1000000007;
    }

    private void mergeSort(int[] array,int left,int right){
        if(left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(array,left,mid);
        mergeSort(array,mid + 1,right);
        merge(array,left,mid,right);
    }

    private void merge(int[] array,int left,int mid,int right){
        int i = left,k = left,j = mid + 1;
        while(i <= mid || j <= right){
            if(i > mid){
                temp[k] = array[j++];
            }else if(j > right){
                temp[k] = array[i++];
            } else if(array[i] <= array[j]){
                temp[k] = array[i++];
            } else {
                temp[k] = array[j++];
                this.sum += (mid - i + 1);
            }
            k++;
        }
        for(k = left;k <= right;k++){
            array[k] = temp[k];
        }
    }
}
