package com.yxh.leetcode.testcase;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:

A =  [2,3,1,1,4] , return  true .

A = [3,2,1,0,4] , return  false .

这道题的巧妙之处在于，每一个值可以跳“值”大小步数。所以我们的思路如下：

1.记录到现在为止能跳到最远的距离，记为max

2.每一个点能走的步数，记为step，且每往前面走一步，step--

3.判断到这个点后往后跳的步数是不是大于max，如果是就更新max，不是就继续往前走

这样的话我们可以看到：如果前面这个点是零，且这个时候step步数不够你迈过去，那么就会自动跳出返回false。但是如果可以一直这么走走到终点，那么返回true
 */
public class test055IMPORT {
	public static void main(String args[]) {
		// int[] A = {3,0,0,0};
		int[] A = { 3, 2, 1, 0, 4 };

		if (canJump(A))
			System.out.println("We win");
		else
			System.out.println("we lose");
	}

	public static boolean canJump(int[] A) {
		int max = 0;    //当前能达到的最大距离
		int step = 1;   //记录当前节点可以走的步数
		if (A.length <= 1)
			return true;
		if (A[0] == 0 && A.length > 1)
			return false;
		for (int i = 0; i < A.length; i++) {
			step--;   //
			if (i + A[i] > max) {
				max = i + A[i];
				step = A[i];
			}
			if (step == 0 && i < A.length - 1)  //不能往前走的情况下   还没达到末尾   则走不到了  返回false
				return false;

		}
		return true;
	}
}
