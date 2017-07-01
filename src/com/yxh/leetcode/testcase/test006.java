package com.yxh.leetcode.testcase;


/*
 * 6. ZigZag ConversionAdd to List
DescriptionHintsSubmissionsSolutions
Total Accepted: 149239
Total Submissions: 563363
Difficulty: Medium
Contributor: LeetCode
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P A H N A P L S I I G Y I R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
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
                
                System.out.println("numRows= "+numRows+" row= "+row+" childLenOfGroup1= " +childLenOfGroup1+" childLenOfGroup2= "+childLenOfGroup2);
                
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
