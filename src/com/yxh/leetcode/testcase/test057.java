package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import java.util.List;

import com.yxh.leetcode.testcase.entity.Interval;

public class test057 {
	/**
	 * Definition for an interval.
	 * public class Interval {
	 *     int start;
	 *     int end;
	 *     Interval() { start = 0; end = 0; }
	 *     Interval(int s, int e) { start = s; end = e; }
	 * }
	 */
	public class Solution {
	    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	       // 先判断newInterval是否在intervals的范围内
	        if (newInterval == null)
	            return intervals;
	        int len = intervals.size();
	        if (len == 0)
	        {
	            intervals.add(newInterval);
	            return intervals;
	        }
	        List<Interval> res=new ArrayList<Interval>();
	        for(Interval interval:intervals)
	        {
	            if(interval.end<newInterval.start)//newInterval在中间的情况
	            {
	                res.add(interval);
	            }else if(interval.start>newInterval.end)//newInterval插入最前端的情况
	            {
	                res.add(newInterval);
	                newInterval=interval;//这个地方很重要，就是找到了待插入区间位置，指定新的newInterval，因为intervals中的区间也可能有相交的地方，需要融合。
	            }else if(interval.start<=newInterval.end||interval.end>=newInterval.start)//有重合部分的四种情况
	            {
	                newInterval=new Interval(Math.min(interval.start,newInterval.start),Math.max(interval.end,newInterval.end));
	            }
	        }
	        res.add(newInterval);
	        return res;
	    }
	}
}
