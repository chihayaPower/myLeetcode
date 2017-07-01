package com.yxh.leetcode.testcase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.yxh.leetcode.testcase.entity.Interval;

/*
 * 【题目】
 
Add to List
56. Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

【解析】
题意：有很多个区间，把有重叠的区间合并。

思路：先排序，然后检查相邻两个区间，看前一个区间的结尾是否大于后一个区间的开始，注意前一个区间包含后一个区间的情况。

用Java自带的sort()方法，只要自己重写compare()方法即可。
 */

/*
 * 先根据每个interval的start按升序排序，
 * 然后再像Insert Interval那样遍历一遍进行merge，不过有点小区别，
 * 在Insert Interval中，遍历到不能merge时，就可以直接移动后面的所有interval了，
 * 而这里还需要继续往后merge。
 */
public class test056IMPORT {
 	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() == 0) {
			return intervals;
		}
		int N = intervals.size();

		// sort
		Interval[] intervalArray = intervals.toArray(new Interval[N]);
		Arrays.sort(intervalArray, new Comparator<Interval>() {
			@Override
			public int compare(Interval interval1, Interval interval2) {
				return interval1.start - interval2.start;
			}
		});

		// merge
		ArrayList<Interval> result = new ArrayList<Interval>();
		Interval mover = intervalArray[0];
		for (int i = 1; i < N; ++i) {
			if (mover.end < intervalArray[i].start) {
				result.add(mover);
				mover = intervalArray[i];
			} else {
				mover.end = Math.max(mover.end, intervalArray[i].end);  //还不能添加到结果列表  因为下一个区间有可能还比这个小
			}
		}
		result.add(mover);
		return result;
	}
}
