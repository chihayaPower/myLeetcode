package com.yxh.audition.sorts;

public class insertSort {
	/**  
	 * 插入排序<br/>  
	 * <ul>  
	 * <li>从第一个元素开始，该元素可以认为已经被排序</li>  
	 * <li>取出下一个元素，在已经排序的元素序列中从后向前扫描</li>  
	 * <li>如果该元素（已排序）大于新元素，将该元素移到下一位置</li>  
	 * <li>重复步骤3，直到找到已排序的元素小于或者等于新元素的位置</li>  
	 * <li>将新元素插入到该位置中</li>  
	 * <li>重复步骤2</li>  
	 * </ul>  
	 *   
	 * @param numbers  
	 */  
	
	public static void main(String[] args) {
		//int[] sample = {0,1,2,3,4,5,6,7,8,9};
		int[] sample = {9,8,7,6,5,4,3,2,1,0};
		
		insertSort(sample);
		
		for (int i = 0; i < sample.length; i++) {
		System.out.println(sample[i]);
		}
	}
	public static void insertSort(int[] numbers) {   
	    int size = numbers.length, temp, j;   
	    for(int i=1; i<size; i++) {   
	        temp = numbers[i];   
	        for(j = i; j > 0 && temp < numbers[j-1]; j--)   
	            numbers[j] = numbers[j-1];   
	        numbers[j] = temp;   
	    }   
	}  
}
