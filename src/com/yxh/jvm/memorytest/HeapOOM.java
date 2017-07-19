package com.yxh.jvm.memorytest;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
	static class OOMObject {
	}
	
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();  //堆内存 占用
		
		while(true) {
			list.add(new OOMObject());
		}
	}
}
