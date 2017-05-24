package com.yxh.leetcode.testcase;

public class test007 {

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
