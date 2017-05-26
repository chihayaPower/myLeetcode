package com.yxh.leetcode.testcase;

public class test008 {
/*
 * 08 题目要求：
mplement atoi to convert a string to an integer.
Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

照着要求写代码，可以总结如下：
1. 字串为空或者全是空格，返回0； 
2. 字串的前缀空格需要忽略掉；
3. 忽略掉前缀空格后，遇到的第一个字符，如果是‘+’或‘－’号，继续往后读；如果是数字，则开始处理数字；如果不是前面的2种，返回0；
4. 处理数字的过程中，如果之后的字符非数字，就停止转换，返回当前值；
5. 在上述处理过程中，如果转换出的值超出了int型的范围，就返回int的最大值或最小值。
清楚了要求，就可以写出AC的代码了。
我的代码如下，欢迎各位大牛指导交流~
AC，Runtime: 32 ms
 */
	
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
