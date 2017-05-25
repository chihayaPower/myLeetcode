package com.yxh.leetcode.testcase;

public class test048 {
	/*
	 * public void rotate(int[][] matrix) { int m = matrix.length; int n =
	 * matrix[0].length;
	 * 
	 * int[][] result = new int[m][n];
	 * 
	 * for(int i = 0; i<m; i++){ for(int j = 0; j<n; j++){ result[j][m-1-i] =
	 * matrix[i][j]; } }
	 * 
	 * for(int i=0;i<m;i++){ for(int j=0; j<n; j++){ matrix[i][j] =
	 * result[i][j]; } } }
	 */

	// in place
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = temp;
			}
		}
	}
}
