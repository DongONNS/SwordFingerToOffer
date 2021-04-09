package edu.csu.swordFingerOffer.ThirdPractice.array;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

public class ReorderArray {
    public int[] reOrderArray(int[] array){
        int[] aux = new int[array.length];
        // 代表我们重新填入偶数时应该填入的位置，假设原数组中没有偶数
        int evenIndex = array.length;
        for (int i = 0;i < array.length;i++){
            if (array[i]%2 == 0){
                evenIndex--;
            }
        }

        int oddIndex = 0;
        for (int i = 0;i < array.length;i++){
            if (array[i] % 2 == 0){
                aux[evenIndex++] = array[i];
            }else{
                aux[oddIndex++] = array[i];
            }
        }
        return aux;
    }
//    /**
//     * 将数组重排序，仅仅能实现将数组元素的奇和偶颠倒，没法实现排序
//     * @param array
//     * @return
//     */
//    public int[] reOrderArrayII(int[] array){
//        int slow = 0,fast = 0;
//        while(fast < array.length){
//            if ((array[fast]&1) == 1){
//                swap(array,slow,fast);
//                slow++;
//            }
//            fast++;
//        }
//        return array;
//    }
//
//    /**
//     * 交换数组中的元素
//     * @param array
//     * @param i
//     * @param j
//     */
//    private void swap(int[] array,int i,int j){
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }
}
