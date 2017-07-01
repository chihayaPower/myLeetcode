package com.yxh.leetcode.testcase;

/*
 * 题目：

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

 

题解：

 这道题分析看，就是一个词，在一行出现也是true，一列出现也是true，一行往下拐弯也是true，一行往上拐弯也是true，一列往左拐弯也是true，一列往右拐弯也是true。
 所以是要考虑到所有可能性，基本思路是使用DFS来对一个起点字母上下左右搜索，看是不是含有给定的Word。
 还要维护一个visited数组，表示从当前这个元素是否已经被访问过了，过了这一轮visited要回false，因为对于下一个元素，当前这个元素也应该是可以被访问的。
 */

public class test079DFS {
	public boolean exist(char[][] board, String word) {
        int m = board.length;  //行
        int n = board[0].length;    //列
        boolean[][] visited = new boolean[m][n];  
        for (int i = 0; i < m; i++) {  
            for (int j = 0; j < n; j++) {  
                if (dfs(board, word, 0, i, j, visited))  
                    return true;  
            }  
        }  
        return false;  
    }
    
    public boolean dfs(char[][] board, String word, int index, int rowindex, int colindex, boolean[][] visited) {  
        if (index == word.length())  
            return true;  
        if (rowindex < 0 || colindex < 0 || rowindex >=board.length || colindex >= board[0].length)  
            return false;  
        if (visited[rowindex][colindex])  
            return false;  
        if (board[rowindex][colindex] != word.charAt(index))  
            return false;  
        visited[rowindex][colindex] = true;  
        boolean res = dfs(board, word, index + 1, rowindex - 1, colindex, visited)  
                || dfs(board, word, index + 1, rowindex + 1, colindex, visited)  
                || dfs(board, word, index + 1, rowindex, colindex + 1, visited)  
                || dfs(board, word, index + 1, rowindex, colindex - 1, visited);  
        visited[rowindex][colindex] = false;  //恢复现场
        return res;  
            }
}
