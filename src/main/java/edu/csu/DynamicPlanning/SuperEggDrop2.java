package edu.csu.DynamicPlanning;

import java.util.HashMap;
import java.util.Map;

public class SuperEggDrop2 {
    class Solution {
        public int superEggDrop(int K, int N) {
            return dp(K,N);
        }
        Map<Integer,Integer> memo = new HashMap();
        public int dp(int K,int N){
            if(!memo.containsKey(N*100+K)){
                int ans;
                //如果楼层数量为0，那么不用扔鸡蛋
                if(N == 0) ans = 0;
                    //如果楼层数不为0而且鸡蛋只有一个，那么只能扫面
                else if(K == 1) ans =N;
                    //楼层数不为0，鸡蛋数大于1的情况：
                else{
                    int lo = 1,hi = N;
                    while(lo + 1 < hi){
                        int x = (lo + hi) / 2;
                        int t1 = dp(K-1,x - 1);
                        int t2 = dp(K,N-x);
                        if(t1 < t2) lo = x;
                        else if (t1 > t2) hi = x;
                        else lo = hi = x;
                    }
                    ans = 1 + Math.min(Math.max(dp(K-1,lo-1),dp(K,N - lo)),Math.max(dp(K-1,hi-1),dp(K,N-hi)));
                }
                memo.put(N*100 + K,ans);
            }
            return memo.get(N*100+K);
        }
    }
}
