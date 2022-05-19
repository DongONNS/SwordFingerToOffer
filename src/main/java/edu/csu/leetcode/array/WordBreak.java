package edu.csu.leetcode.array;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dongcheng_2018@163.com
 * @Date 2022/5/20 0:08
 */
public class WordBreak {
    public boolean wordBreak(final String s, final List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                String curr = s.substring(j, i);
                dp[i] = dp[j] && set.contains(curr);
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
