package edu.csu.leetcode.DynamicPlanning.zeroonepackage;

import java.util.List;

/*
s = "leetcode",
dict = ["leet", "code"].
Return true because "leetcode" can be segmented as "leet code".
 */

/*

dict 中的单词没有使用次数的限制，因此这是一个完全背包问题。

该问题涉及到字典中单词的使用顺序，也就是说物品必须按一定顺序放入背包中，例如下面的 dict 就不够组成字符串 "leetcode"：

["lee", "tc", "cod"]
Copy to clipboardErrorCopied
求解顺序的完全背包问题时，对物品的迭代应该放在最里层，对背包的迭代放在外层，只有这样才能让物品按一定顺序放入背包中。
 */

public class WordBreakII {
    public boolean wordBreak(String s, List<String> wordDict){
        int n = s.length();
        // dp[i]表示当背包的大小为i 的时候能否由wordDict中的字符组成
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        // 这里涉及到字典中单词的使用顺序问题，所以应该将单词的迭代放入到内层循环中
        for (int i = 1;i <= n;i++){
            for (String word : wordDict){
                int len = word.length();
                if (len <= i && word.equals(s.substring(i - len,i)));
                    dp[i] = dp[i] || dp[i - len];
            }
        }
        return dp[n];
    }
}
