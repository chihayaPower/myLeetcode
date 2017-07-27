package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
 * Word Break II leetcode java
题目：

Given a string s and a dictionary of words dict, 
add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].

 

题解：

这道题不仅仅是看是不是wordbreak，还需要在此基础上把所有word break的结果保存。
为了把所有可能性都保存，那么就使用DFS方法来解决。DFS主要就是跳的层次不容易看出，
我下面就以字符串leetcode字典le l et eet code作为例子画了一张图，大概讲解了如何递回和返回，这样更加有助于理解。
 */
public class test140字符串动态规划2不会 {
	public boolean wordBreakcheck(String s, List<String> dict) {
        if(s==null || s.length()==0)
            return true;
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for(int i=0;i<s.length();i++){
            StringBuilder str = new StringBuilder(s.substring(0,i+1));
            for(int j=0;j<=i;j++){
                if(res[j] && dict.contains(str.toString())){
                    res[i+1] = true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return res[s.length()];
    }
    
    public ArrayList<String> wordBreak(String s, List<String> dict) {  
        ArrayList<String> res = new ArrayList<String>();  
        if(s==null || s.length()==0)  
            return res;
        if(wordBreakcheck(s,dict))
            helper(s,dict,0,"",res);  
        return res;  
    }  
    private void helper(String s, List<String> dict, int start, String item, ArrayList<String> res){  
        if(start>=s.length()){  
            res.add(item);  
            return;  
        }
        
        StringBuilder str = new StringBuilder();  
        for(int i=start;i<s.length();i++){  
            str.append(s.charAt(i));  
            if(dict.contains(str.toString())){  
                String newItem = new String();  
                if(item.length()>0)
                    newItem = item + " " + str.toString();
                else
                    newItem = str.toString();
                helper(s,dict,i+1,newItem,res);  
            }  
        }  
    }
}
