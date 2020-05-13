package edu.csu.problem43;

import java.util.Arrays;

public class Ratio {
    public static void main(String[] args) {
        double[] result = twoSum(2);
        System.out.println(Arrays.toString(result));
    }

    public static double[] twoSum(int n) {
        if(n==0) return new double[0];
        double[] dp=new double[6*n+1];
        double[] ans=new double[5*n+1];
        double all=Math.pow(6,n);
        for(int i=1;i<=6;i++){
            dp[i]=1;
            ans[i-1]=1.0/6;
        }
        for(int i=2;i<=n;i++){
            for(int j=6*n;j>=1;j--){
                int temp=0;
                for(int k=1;k<=6;k++){
                    temp+=(j>=k)?dp[j-k]:0;
                }
                dp[j]=temp;
                if(i==n && j>=n){
                    ans[j-i]=dp[j]/all;
                }
            }
        }
        return ans;
    }
}
