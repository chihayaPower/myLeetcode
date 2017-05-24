package com.yxh.leetcode.testcase;

public class test008 {

	
	static int atoi(String s){
		
		if (s == null) {
			return 0;
		}
		
		int flag = 0;
		while (flag < s.length() && s.charAt(flag) == ' '){
		//for (int i = 0; i < s.length(); i++) {
			flag++;
		}
		
		if (s.charAt(flag) == '\0') {
			return 0;
		}
		
		int maxValue = Integer.MAX_VALUE;
		int minValue = Integer.MIN_VALUE;
		
		int singal = 1;
		if (s.charAt(flag) == '+') {
			singal = 1;
			flag++;
		} else if (s.charAt(flag) == '-') {
			singal = -1;
			flag++;
		}
		
		long sum = 0;
		for(int i = flag; i < s.length(); i++) {
			System.out.println(s.charAt(flag));
			
			if (s.charAt(flag) >= '0' && s.charAt(flag) <= '9') {
				sum = sum*10+singal*(s.charAt(flag) - '0');
			} else {
				return (int)sum;
			}
			
			if (sum > maxValue || sum < minValue) {
				return sum > 0 ? maxValue : minValue;
			}
			
			flag++;
			
		}
		
		
		return (int)sum;
	}
	
	
	
	public static void main(String[] args) {
		String tmp = "     -321";
		
		
		int a = atoi(tmp);
		
		System.out.println(a);
	
	
	}
}
