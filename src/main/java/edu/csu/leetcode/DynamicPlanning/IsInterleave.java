package edu.csu.leetcode.DynamicPlanning;

/**
 * 第97题 交叉字符串.
 */
public class IsInterleave {

  /**
   * 测试方法正确性.
   */
  public static void main(String[] args) {
    String s1 = "aabcc";
    String s2 = "dbbca";
    String s3 = "aadbbcbcac";
    boolean res = isInterleave(s1, s2, s3);
    System.out.println(res);
  }

  private static boolean isInterleave(String s1, String s2, String s3) {
    int m = s1.length();
    int n = s2.length();
    if (s3.length() != m + n) {
      return false;
    }

    boolean[][] dp = new boolean[m + 1][n + 1];
    // 初始化[0][0]位置
    dp[0][0] = true;
    // 初始化第一列
    for (int i = 1; i <= m; i++) {
      if (dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1)) {
        dp[i][0] = true;
      }
    }
    // 初始化第一行
    for (int i = 1; i <= n; i++) {
      if (dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1)) {
        dp[0][i] = true;
      }
    }

    // 遍历数组中非左边及上边元素
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if ((dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i))
            || (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j))) {
          dp[i][j] = true;
        }
      }
    }
    return dp[m][n];
  }
}
