package com.yxh.leetcode.testcase;

import java.util.HashMap;

/*
 * 题目：

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

 

题解：

这道题也是用滑动窗口的思想，思想跟 Substring with Concatenation of All Words是一样的，同样是利用HashMap来存Dict，然后来遍历整个母串。因为这里是要求最短的包含子串的字符串，所以中间是可以允许有非子串字符的，当遇见非子串字符而count又没到子串长度时，可以继续走。

当count达到子串长度，说明之前遍历的这些有符合条件的串，用一个pre指针帮忙找，pre指针帮忙找第一个在HashMap中存过的，并且找到后给计数加1后的总计数是大于0的，判断是否为全局最小长度，如果是，更新返回字符串res，更新最小长度，如果不是，继续找。

这道题的代码也参考了code ganker的。 
 */

public class test076 {
	public String minWindow(String S, String T) {
	    String res = "";
	    if(S == null || T == null || S.length()==0 || T.length()==0)
	        return res;
	    
	    HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
	    for(int i =0;i < T.length(); i++){   //处理模板串
	        if(!dict.containsKey(T.charAt(i)))
	            dict.put(T.charAt(i), 1);  //第一次遇到模板的串  记录为1
	        else
	            dict.put(T.charAt(i), dict.get(T.charAt(i))+1);   //有多少个   记录为多少个数
	    }
	    
	    int count = 0;
	    int pre = 0;
	    int minLen = S.length()+1;
	    for(int i=0;i<S.length();i++){
	        if(dict.containsKey(S.charAt(i))){
	            dict.put(S.charAt(i),dict.get(S.charAt(i))-1);  //用掉了一个字串的字符   模式串减一
	            if(dict.get(S.charAt(i)) >= 0)
	                count++;           //计数器加一
	                
	            while(count == T.length()){
	                if(dict.containsKey(S.charAt(pre))){
	                    dict.put(S.charAt(pre),dict.get(S.charAt(pre))+1);
	                    
	                    if(dict.get(S.charAt(pre))>0){
	                        if(minLen>i-pre+1){
	                            res = S.substring(pre,i+1);
	                            minLen = i-pre+1;
	                        }
	                        count--;
	                    }
	                }
	                pre++;
	            }
	        }//end for if(dict.containsKey(S.charAt(i)))
	    }
	    return res;
	}
}
