package com.yxh.leetcode.testcase;


/*
 * Best Time to Buy and Sell Stock III leetcode java
题目：

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at 
most two transactions.

Note:
You may not engage in multiple transactions at the same time 
(ie, you must sell the stock before you buy again).

 

题解： 

根据题目要求，最多进行两次买卖股票，而且手中不能有2只股票，就是不能连续两次买入操作。

所以，两次交易必须是分布在2各区间内，也就是动作为：买入卖出，买入卖出。

进而，我们可以划分为2个区间[0,i]和[i,len-1]，i可以取0~len-1。

那么两次买卖的最大利润为：在两个区间的最大利益和的最大利润。

一次划分的最大利益为：Profit[i] = MaxProfit(区间[0,i]) + MaxProfit(区间[i,len-1]);

最终的最大利润为：MaxProfit(Profit[0], Profit[1], Profit[2], ... , Profit[len-1])。
 */
public class test123ARRAYBESTSTOCK3 {
	public int maxProfit(int[] prices) {  
        if(prices == null || prices.length <= 1){  
            return 0;  
        }  
        int len = prices.length;  
        int maxProfit = 0;  
        int min = prices[0];  
        int arrayA[] = new int[len];  
        
        for(int i=1;i<prices.length;i++){
            min=Math.min(min,prices[i]);    //prices中  到i的最小值
            arrayA[i]=Math.max(arrayA[i-1],prices[i]-min);     //prices到i的最大利润
        }
        
        int max = prices[len-1];  
        int arrayB[] = new int[len];  
        for(int i = len-2; i >= 0; i--){
            max = Math.max(prices[i],max);  //prices中的 到I的最大值
            arrayB[i] = Math.max(max-prices[i],arrayB[i+1]);    //prices到i的最大利润
        }  
        
        for(int i = 0; i < len; i++){  
            maxProfit = Math.max(maxProfit,arrayA[i] + arrayB[i]);  //最终最大利润
        }  
        
        return maxProfit;  
    }
}
