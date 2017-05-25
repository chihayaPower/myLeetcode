package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.yxh.leetcode.utils.ArrayUtils;

/*
题目：

Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

 

题解：

这道题就用循环递归解决子问题。

因为求所有组合，这就意味着不能重复使用元素，要用visited数组。

有因为是所有可能的组合，所以循环length次，就是这里面每位都有可能有length个可能性。

正因为如此，每一层递归就不需要传递一个start点，告诉他从哪开始（因为都是从头开始循环）。


 这道题跟Permutaitons没啥大的区别，就是结果去重。

 我之前也有写过去重的两个方法:

 一个是在加入结果的时候用contains判断，一个是在找结果的时候看他是不是跟前一个元素相同。

 这道题还要考虑的是visited情况，前一个元素就算跟当前元素相同，如果visited==true也没关系。
 但是如果前面元素跟当前元素相同还没被visited，那么就要做去重处理了
 */

public class test046AND047 {  
	public static List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        
        if(num.length==0||num==null)
            return res;	
        boolean[] visited = new boolean[num.length];  
        Arrays.sort(num);
        permutation_helper(num,res,item,visited);
        return res;
    }
    
    public static void permutation_helper(int[] num,   //测试数据
    	List<List<Integer>> res,       //返回数据结构
    	List<Integer> item,			//每个枚举出来的list
    	boolean[] visited){       //节点是否访问过
        if(item.size()==num.length){         //item size够了就加入最终结果
            res.add(new ArrayList<Integer>(item));
            return;
        }
        
        for(int i = 0; i<num.length;i++){
            if(i>0 && num[i-1] == num[i] && !visited[i-1])  //和前面一个数字相等就认为是重复的  跳过
                continue;
            if(!visited[i]){     //如果之前没访问过
                item.add(num[i]);  //加入结果集
                visited[i]=true;   //标记访问过
                //System.out.println("1: "+item.toString());
                permutation_helper(num,res,item,visited);
                //System.out.println("2: "+item.toString());
                System.out.println("index: "+ i + " item is "+ item.toString() +" remove value is: "+item.get(item.size()-1));
                item.remove(item.size()-1);
                
                
                
                
                visited[i]=false;
            }
        }
    }
    
    /*
     * 注意在实现中有一个细节，就是在递归函数的前面，我们分别设置了used[i]的标记，
     * 表明改元素被使用，并且把元素加入到当前结果中，而在递归函数之后，我们把该元素从结果中移除，
     * 并把标记置为false，这个我们可以称为“保护现场”，递归函数必须保证在进入和离开函数的时候，
     * 变量的状态是一样的，这样才能保证正确性。当然也可以克隆一份结果放入递归中，但是那样会占用大量空间。
     * 所以个人认为这种做法是最高效的，而且这种方法在很多题目（几乎所有NP问题）中一直用到，不熟悉的朋友可以练习一下哈。
对于NP问题我们一直都是用递归方法，也是一个很成熟的套路，可以举一反三。不过有时候面试官会刻意让我们实现一下迭代的做饭，
所以这里我们就介绍一下迭代的实现方法。迭代一般就是要理清每次加入一个新的元素，我们应该做什么，
这里其实还是比较清晰的，假设有了当前前i个元素的所有permutation，当第i+1个元素加进来时，
我们要做的就是将这个元素带入每一个之前的结果，并且放到每一个结果的各个位置中。
因为之前的结果没有重复，所以带入新元素之后也不会有重复（当然这里假设数字集合本身是没有重复的元素的）。
按照这个思路，实现的代码如下：
     */
    
    public static void main(String[] args){
    	int sample[] = {1,2,3};
    	List<List<Integer>> res = permuteUnique(sample);
    	//System.out.println("res: "+res.toString());
    	
    }
}
