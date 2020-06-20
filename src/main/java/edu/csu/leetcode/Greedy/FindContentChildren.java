package edu.csu.leetcode.Greedy;

import java.util.Arrays;

public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        if(g == null || s == null) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        //策略 优先满足胃口小的孩子；
        int gi = 0, si = 0;
        while(gi < g.length && si < s.length){
            if(s[si] >= g[gi])
                gi++;
            si++;
        }
        return gi;
    }
}
