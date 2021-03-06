package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import java.util.List;

/*
 * 这道题跟Pascal's Triangle很类似，只是这里只需要求出某一行的结果。
 * Pascal's Triangle中因为是求出全部结果，所以我们需要上一行的数据就很自然的可以去取。
 * 而这里我们只需要一行数据，就得考虑一下是不是能只用一行的空间来存储结果而不需要额外的来存储上一行呢？
 * 这里确实是可以实现的。对于每一行我们知道如果从前往后扫，第i个元素的值等于上一行的res[i]+res[i+1]，
 * 可以看到数据是往前看的，如果我们只用一行空间，那么需要的数据就会被覆盖掉。所以这里采取的方法是从后往前扫，
 * 这样每次需要的数据就是res[i]+res[i-1]，我们需要的数据不会被覆盖，因为需要的res[i]只在当前步用，
 * 下一步就不需要了。这个技巧在动态规划省空间时也经常使用，
 * 主要就是看我们需要的数据是原来的数据还是新的数据来决定我们遍历的方向。时间复杂度还是O(n^2)，
 * 而空间这里是O(k)来存储结果，仍然不需要额外空间。代码如下：

 */
public class test119TREEPascalsTriangle2 {
	public static List<Integer> getRow(int rowIndex) {  
	    List<Integer> res = new ArrayList<Integer>();  
	    if(rowIndex<0)  
	        return res;  
	    res.add(1);  
	    for(int i=1;i<=rowIndex;i++)     
	    {  
	        for(int j=res.size()-2;j>=0;j--)  //从后往前扫
	        {  
	            res.set(j+1,res.get(j)+res.get(j+1)); 
	            System.out.println(res.toString());
	        }  
	        res.add(1);  
	    }  
	    return res;  
	}  
	
	public static void main(String[] args) {
		System.out.println(getRow(5).toString());
	}
}
