package edu.csu.swordFingerOffer.ThirdPractice.dp;

class JumpFloor {
    public static int jumpFloor(int target){
        if(target < 2)  return target;

        int pre2 = 1,pre1 = 1;
        int sum = 0;

        for (int i = 2;i <= target;i++){
            sum = pre2 + pre1;

            pre2 = pre1;
            pre1 = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        int res = jumpFloor(3);
        System.out.println("所需要的总步数为：" + res);
    }
}
