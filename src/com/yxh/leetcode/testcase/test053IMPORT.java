package com.yxh.leetcode.testcase;


/*Maximum Subarray
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * 这道题让我们求最大子数组之和，并且要我们用两种方法来解，分别是O(n)的解法，
 * 还有用分治法Divide and Conquer Approach，这个解法的时间复杂度是O(nlgn)，
 * 那我们就先来看O(n)的解法，定义两个变量res和curSum，其中res保存最终要返回的结果，
 * 即最大的子数组之和，curSum初始值为0，每遍历一个数字num，比较curSum + num和num中的较大值存入curSum，
 * 然后再把res和curSum中的较大值存入res，以此类推直到遍历完整个数组，可得到最大子数组的值存在res中，代码如下：
 */
public class test053IMPORT {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, curSum = 0;
        for (int num : nums) {
            curSum = Math.max(curSum + num, num);  //前面加起来的和  小于下一个单个值   则更新单个值
            res = Math.max(res, curSum);
        }
        return res;
    }
    
    /*
     * 题目还要求我们用分治法Divide and Conquer Approach来解，
     * 这个分治法的思想就类似于二分搜索法，我们需要把数组一分为二，分别找出左边和右边的最大子数组之和，
     * 然后还要从中间开始向左右分别扫描，求出的最大值分别和左右两边得出的最大值相比较取最大的那一个，代码如下：
     */
    public int maxSubArray2(int[] nums) {
        if (nums.length == 0) return 0;
        return helper(nums, 0, nums.length - 1);
    }
    public int helper(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int mid = left + (right - left) / 2;
        int lmax = helper(nums, left, mid - 1);
        int rmax = helper(nums, mid + 1, right);
        int mmax = nums[mid], t = mmax;
        for (int i = mid - 1; i >= left; --i) {
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        t = mmax;
        for (int i = mid + 1; i <= right; ++i) {
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        return Math.max(mmax, Math.max(lmax, rmax));
    }

}
