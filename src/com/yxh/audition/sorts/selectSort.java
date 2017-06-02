package com.yxh.audition.sorts;

public class selectSort {
	/**  
	 * 选择排序<br/>  
	 * <li>在未排序序列中找到最小元素，存放到排序序列的起始位置</li>  
	 * <li>再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。</li>  
	 * <li>以此类推，直到所有元素均排序完毕。</li>  

	 *   
	 * @param numbers  
	 */  
	public static void main(String[] args) {
		//int[] sample = {0,1,2,3,4,5,6,7,8,9};
		int[] sample = {9,8,7,6,5,4,3,2,1,0};
		
		selectSort(sample);
		
		for (int i = 0; i < sample.length; i++) {
		System.out.println(sample[i]);
		}
	}
	public static void selectSort(int[] numbers) {   
	    int size = numbers.length, temp;   
	    for (int i = 0; i < size; i++) {   
	        int k = i;   
	        for (int j = size - 1; j >i; j--)  {   
	            if (numbers[j] < numbers[k])  k = j;   
	        }   
	        temp = numbers[i];   
	        numbers[i] = numbers[k];   
	        numbers[k] = temp;   
	    }   
	}  
}
