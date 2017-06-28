package com.yxh.leetcode.testcase;

/*
 * 问题：
给定两个字符串 A和B，由A转成B所需的最少编辑操作次数。允许的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。
例如将A(kitten)转成B(sitting)：
sitten （k→s）替换
sittin （e→i）替换
sitting （→g）插入
思路：
如果我们用 i 表示当前字符串 A 的下标，j 表示当前字符串 B 的下标。 如果我们用d[i, j] 来表示A[1, ... , i] B[1, ... , j] 之间的最少编辑操作数。那么我们会有以下发现：
1. d[0, j] = j;
2. d[i, 0] = i;
3. d[i, j] = d[i-1, j - 1] if A[i] == B[j]
4. d[i, j] = min(d[i-1, j - 1], d[i, j - 1], d[i-1, j]) + 1  if A[i] != B[j]
所以，要找出最小编辑操作数，只需要从底自上判断就可以了。伪代码如下：
 */
public class test072 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        
        for(int i = 0; i <= len1; i++){
     	   dp[i][0] = i;
        }
        for(int i = 0; i <= len2; i++){
     	   dp[0][i] = i;
        }
        
        for(int i = 1; i <= len1; i++){
     	   for(int j = 1; j <= len2; j++){
     		   if(word1.charAt(i - 1) == word2.charAt(j - 1))
     			   dp[i][j] = dp[i - 1][j - 1];
     		   else dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
     	   }
        }
        return dp[len1][len2];
     }
}
