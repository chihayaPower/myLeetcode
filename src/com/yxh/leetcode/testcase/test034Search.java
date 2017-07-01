package com.yxh.leetcode.testcase;

public class test034Search {
	public int[] searchRange(int[] A, int target) {
        int [] res = {-1,-1};
        if(A == null || A.length == 0)
            return res;
        
        //first iteration, find target wherever it is
        int low = 0;
        int high = A.length-1;
        int pos = 0;
        while(low <= high){
            int mid = (low + high)/2;
            pos = mid;
            if(A[mid] > target)
                high = mid - 1;
            else if(A[mid] < target)
                low = mid + 1;
            else{
                res[0] = pos;
                res[1] = pos;
                break;
            }
        }
        
        if(A[pos] != target)    //不等于   就是找到了   
            return res;
        
        //second iteration, find the right boundary of this target
        int newlow = pos;
        int newhigh = A.length-1;
        while(newlow <= newhigh){               //搜后半部分  找到上限
            int newmid = (newlow+newhigh)/2;
            if(A[newmid] == target)
                newlow = newmid + 1;
            else
                newhigh = newmid - 1;
        }
        res[1] = newhigh;
        
        //third iteration, find the left boundary of this target
        newlow = 0;
        newhigh = pos;
        while(newlow <= newhigh){               //搜前半部分  找到下限
            int newmid = (newlow+newhigh)/2;
            if(A[newmid] == target)
                newhigh = newmid - 1;
            else
                newlow = newmid + 1;
        }
        res[0] = newlow;
        
        return res;
    }
}
