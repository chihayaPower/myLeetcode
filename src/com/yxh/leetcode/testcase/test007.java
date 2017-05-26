package com.yxh.leetcode.testcase;

public class test007 {
	/*
	 * 07 题目要求：
Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321
Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the function (ie, add an extra parameter).

正如题目中所提示的，一些边界条件的考虑可以在笔试或面试时为你的代码带来加分的效果，所以题目就算简单，多思考和锻炼也能带来成长。
我写的代码比较简单，考虑了一下溢出的处理，欢迎各种大牛指导交流~
AC，Runtime: 56 ms
	 */

    public static int reverse(int x) {  
        // IMPORTANT: Please reset any member data you declared, as  
        // the same Solution instance will be reused for each test case.  
          
        int max = 0x7fffffff;  //int最大值  
        int min = 0x80000000;  //int最小值  
        long sum = 0;   
        
        if (x > max || x < min) {
        	System.out.println("over flow");
        	return 0;
        }
          
        while(x != 0)  
        {  
            int temp = x % 10; 
            
            System.out.print("#"+temp);
            sum = sum * 10 + temp;
            System.out.print("*"+sum);
            System.out.print("\n");
            if (sum > max || sum < min)   //溢出处理  
            {  System.out.println("over flow");
                //sum = sum > 0 ? max : min;    
                return 0;  
            }  
            x = x / 10;  
        }
        
        int ret = (int) sum;
        return ret;  
    }  
	
	public static void main(String[] args){
		int a = 153423646;
		System.out.println(a);
		int res = reverse(a);
		
		System.out.println("\n"+res);
		
	}
}
