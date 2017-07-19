package com.yxh.leetcode.testcase;

/*
 * 题目：

Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.

 

题解：

 这道题首先引用我忘记在哪里看到的一句话：

 “When you see string problem that is about subsequence or matching, 
 dynamic programming method should come to your mind naturally. ”

 所以这种类型题可以多往DP思考思考。

 首先设置动态规划数组dp[i][j]，表示S串中从开始位置到第i位置与T串从开始位置到底j位置匹配的子序列的个数。

 如果S串为空，那么dp[0][j]都是0；

 如果T串为空，那么dp[i][j]都是1，因为空串为是任何字符串的字串。

 可以发现规律，dp[i][j] 至少等于 dp[i][j-1]。

 当i=2，j=1时，S 为 ra，T为r，T肯定是S的子串；这时i=2，j=2时，S为ra，T为rs，
 T现在不是S的子串，当之前一次是子串所以现在计数为1.

 

同时，如果字符串S[i-1]和T[j-1]（dp是从1开始计数，字符串是从0开始计数）匹配的话，dp[i][j]还要加上dp[i-1][j-1]

 例如对于例子： S = "rabbbit", T = "rabbit"

 当i=2，j=1时，S 为 ra，T为r，T肯定是S的子串；当i=2，j=2时，S仍为ra，
 T为ra，这时T也是S的子串，所以子串数在dp[2][1]基础上加dp[1][1]。


 */


public class test115字符串DP不会 {
	public int numDistinct(String S, String T) {
        int[][] dp = new int[S.length() + 1][T.length() + 1];
        dp[0][0] = 1;//initial
        
        for(int j = 1; j <= T.length(); j++)//S is empty
            dp[0][j] = 0;
            
        for (int i = 1; i <= S.length(); i++)//T is empty
            dp[i][0] = 1;
           
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                dp[i][j] = dp[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) 
                    dp[i][j] += dp[i - 1][j - 1];
            }
        }
     
        return dp[S.length()][T.length()];
    }
}
