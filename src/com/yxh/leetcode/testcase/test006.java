package com.yxh.leetcode.testcase;

public class test006 {
    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        StringBuilder strBuilder = new StringBuilder();
        int lengthOfGroup = 2 * numRows - 2;       
        for(int row=0; row < numRows; row++){
            if (row == 0 || row == numRows - 1){
                for(int currentRow = row; currentRow < s.length(); currentRow += lengthOfGroup){
                    strBuilder.append(s.charAt(currentRow));
                }
            }
            else{
                int currentRow = row;        
                boolean flag = true;
                int childLenOfGroup1 = 2 * (numRows - 1 - row);           
                int childLenOfGroup2 = lengthOfGroup - childLenOfGroup1;
                while (currentRow <s.length()){
                    strBuilder.append(s.charAt(currentRow));
                    if (flag)
                        currentRow += childLenOfGroup1;
                    else
                        currentRow += childLenOfGroup2;
                    flag = !flag;
                }
            }
        }
        return strBuilder.toString();
    }
	
	public static void main(String[] args) {
		String tmp = "abcdefghijklmnopqrst";
		
		String res = convert(tmp, 4);
		
		System.out.println(res);
	}
}
