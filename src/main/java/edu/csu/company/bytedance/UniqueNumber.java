package edu.csu.company.bytedance;

/**
 * 数组a,先递增再递减，输出数组中不同元素个数。
 * 要求：O(1)空间复杂度，尽可能小的时间复杂度，不能改变原数组。 如arr=1,2,4,6,3,2,2 输出5
 * case：4，2，2，2
 */
public class UniqueNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,6,3,2,2};
//        int[] arr = new int[]{4,2,2,2};
//        int[] arr = new int[]{2,2,2,2};
        int res = uniqueNumber(arr);
        System.out.println("数组中不重复的数字数量为：" + res);
    }

    private static int uniqueNumber(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }

        int left = 0,right = arr.length - 1;
        int count = 0;

        while(left < right){
            // 数字相等
            if(arr[left] == arr[right]){
                count++;

                // 找到左边的不重复该数的值
                while( left < right && arr[++left] == arr[right]){
                    count++;
                }
                if (left == right) break;
                left--;

                // 找到右边的不重复该数字的所有值
                while(left < right && arr[--right] == arr[left]){
                    count++;
                }
            } else if(arr[left] > arr[right]){
                // 重复值处理
                while(left < right && arr[right] == arr[right - 1]){
                    right--;
                    count++;
                }
                right--;
            } else {
                // 重复值处理
                while(left < right && arr[left] == arr[left + 1]){
                    left++;
                    count++;
                }
                left++;
            }
        }
        return (arr.length - count) == 0 ? 1 : arr.length - count;
    }
}
