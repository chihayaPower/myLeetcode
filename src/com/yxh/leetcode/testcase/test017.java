package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test017 {
	Map<String, List<String>> dict= new HashMap<>();
	List<String> ret = new ArrayList<String>();
	
    public List<String> letterCombinations(String digits) {
    	if (digits.length()<1) {
    		return ret;
    	}
    	
        ret.clear();
        createDict();
        dfs(0, digits.length(), digits, "");
        
        return ret;
    }
    
    private void dfs(int dep, int maxDep, String s, String ans) {
		// TODO Auto-generated method stub
    	if (dep == maxDep) {
    		ret.add(ans);
    		return;
    	}
    	
    	for (int i = 0; i < dict.get(s.charAt(dep)+"").size(); i++) {
    		dfs(dep + 1, maxDep, s, ans + dict.get(s.charAt(dep)+"").get(i));
    	}
		
	}

	void createDict() {
    	dict.clear();
    	
    	List<String> b2 = new ArrayList<String>();
    	b2.add("a");
    	b2.add("b");
    	b2.add("c");
    	dict.put("2", b2);
    	
    	List<String> b3 = new ArrayList<String>();
    	b3.add("d");
    	b3.add("e");
    	b3.add("f");
    	dict.put("3", b3);
    	
    	List<String> b4 = new ArrayList<String>();
    	b4.add("g");
    	b4.add("h");
    	b4.add("i");
    	dict.put("4", b4);
    	
    	List<String> b5 = new ArrayList<String>();
    	b5.add("j");
    	b5.add("k");
    	b5.add("l");
    	dict.put("5", b5);
    	
    	List<String> b6 = new ArrayList<String>();
    	b6.add("m");
    	b6.add("n");
    	b6.add("o");
    	dict.put("6", b6);
    	
    	List<String> b7 = new ArrayList<String>();
    	b7.add("p");
    	b7.add("q");
    	b7.add("r");
    	b7.add("s");
    	dict.put("7", b7);
    	
    	List<String> b8 = new ArrayList<String>();
    	b8.add("t");
    	b8.add("u");
    	b8.add("v");
    	dict.put("8", b8);
    	
    	List<String> b9 = new ArrayList<String>();
    	b9.add("w");
    	b9.add("x");
    	b9.add("y");
    	b9.add("z");
    	dict.put("9", b9);
    	
    }
	
	public static void main(String[] args) {
		
	}

}
