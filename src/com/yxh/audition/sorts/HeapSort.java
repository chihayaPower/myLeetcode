package com.yxh.audition.sorts;

import com.yxh.leetcode.utils.ArrayUtils;

public class HeapSort {  
    public static void main(String[] args) {  
        int[] array = { -3, -2, 7, 6, 5, 4, 3, 2, 1, 0, -1, 8, 9 };  

        System.out.println("Before heap:");  
        ArrayUtils.printArray(array);  

        heapSort(array);    //堆排序  

        System.out.println("After heap sort:");  
        ArrayUtils.printArray(array);  
    }  

    public static void heapSort(int[] array) {  
        if (array == null || array.length <= 1) {  
            return;  
        }  

        buildMaxHeap(array);   //建立一个堆   堆顶最大元素 
        
        //ArrayUtils.printArray(array); 

        for (int i = array.length - 1; i >= 1; i--) {  
            ArrayUtils.exchangeElements(array, i, 0);   //交换0和i的位置  最大值去了i位置
            //System.out.println(i);
            //ArrayUtils.printArray(array);
            maxHeap(array, i, 0);   //沉降法 判断  大小为i的堆  0位置变为最大值
            //System.out.println(i);
            //ArrayUtils.printArray(array); 
        }  
    }  

    private static void buildMaxHeap(int[] array) {  
        if (array == null || array.length <= 1) {  
            return;  
        }  

        int half = array.length / 2;  
        for (int i = half; i >= 0; i--) {  
            maxHeap(array, array.length, i);  
        }  
    }  

    private static void maxHeap(int[] array, int heapSize, int index) {  
        int left = index * 2 + 1;  
        int right = index * 2 + 2;  

        int largest = index;  
        if (left < heapSize && array[left] > array[index]) {  
            largest = left;  
        }  

        if (right < heapSize && array[right] > array[largest]) {  
            largest = right;  
        }  

        if (index != largest) {  
            ArrayUtils.exchangeElements(array, index, largest);  

            maxHeap(array, heapSize, largest);  
        }  
    }  
}  