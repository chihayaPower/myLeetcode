package com.yxh.audition.sorts;

public class quickSort {
	
	/*代码

	Code highlighting produced by Actipro CodeHighlighter (freeware)http://www.CodeHighlighter.com/-->/**  
	 * 快速排序<br/>  
	 * <ul>  
	 * <li>从数列中挑出一个元素，称为“基准”</li>  
	 * <li>重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分割之后，  
	 * 该基准是它的最后位置。这个称为分割（partition）操作。</li>  
	 * <li>递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。</li>  
	 * </ul>  
	 *   
	 * @param numbers  
	 * @param start  
	 * @param end  
	 */  
	
	public static void main(String[] args) {
		//int[] sample = {0,1,2,3,4,5,6,7,8,9};
		int[] sample = {9,8,7,6,5,4,3,2,1,0};
		
		quickSort(sample, 0, sample.length-1);
		
		for (int i = 0; i < sample.length; i++) {
		System.out.println(sample[i]);
		}
	}
		
	public static void quickSort(int[] numbers, int start, int end) {   
	    if (start < end) {   
	        int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）   
	        int temp; // 记录临时中间值   
	        int i = start, j = end;   
	        do {   
	            while ((numbers[i] < base) && (i < end))    //找一个I小于base的index
	                i++;   
	            while ((numbers[j] > base) && (j > start))    //找一个J大于base的index
	                j--;   
	            if (i <= j) {     //交换i和j的数值
	                temp = numbers[i];   
	                numbers[i] = numbers[j];   
	                numbers[j] = temp;   
	                i++;   
	                j--;   
	            }   
	        } while (i <= j);   
	        if (start < j)   
	            quickSort(numbers, start, j);   
	        if (end > i)   
	            quickSort(numbers, i, end);   
	    }   
	}
}
