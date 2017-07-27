package com.yxh.leetcode.testcase;

import com.yxh.leetcode.testcase.entity.ListNode;

/*
 * 【题意】
给定一个链表，把最后一个结点插入到第1个结点后，倒数第二个结点插入到第2个结点后，倒数第三个结点插入到第3个结点后，以此类推……

【思路】

由题意知，后面 (n-1)/2 个结点需要分别插入到前面 (n-1)/2 个结点后。

那么先把链表分为两段，前面 n-(n-1)/2 个结点为被插入链表，和后面 (n-1)/2 个结点为插入链表。

在插入之前，需先把插入链表逆序，即第n个结点->第n-1个结点->...
 */
public class test143链表调换不会 {
    public void reorderList(ListNode head) {  
        ListNode node = head;  
        int cnt = 0;  
        while (node != null) {   //算下当前链表有多少个元素
            cnt++;  
            node = node.next;  
        }  
          
        if (cnt < 3) return;     //3个以下的结点不需要移动  
          
        int k = (cnt - 1) / 2;   //需要移动的后k个结点    中间点
        int i = 1;  
        node = head;  
        while (i++ < cnt - k) {  //找到中间的那个节点
            node = node.next;  
        }  
        ListNode begin = node.next;     //用begin表示需要移动的后k个结点的开始  
        node.next = null;    //把不需要移动的部分结尾设为null   后半部分断开    因为准备向前半部分插入
          
        //把需要移动的k个结点逆序  
        ListNode pre = begin;  
        ListNode cur = begin.next;    //后半部分的前两个节点
        begin.next = null;   //断开第一个节点
        while (cur != null) {  
            ListNode next = cur.next;  
            cur.next = pre;  
              
            begin = cur;  
            pre = cur;  
            cur = next;  
        }  
          
        ListNode node1 = head;  
        ListNode node2 = begin;  
        while (node1 != null && node2 != null) {  
            pre = node1;  
            cur = node2;  
              
            node1 = node1.next;//这两行一定要放在下面两行之前，因为pre和node1指向同一个结点，下面操作会改变node1的next；cur和node2同理  
            node2 = node2.next;  
              
            cur.next = pre.next;//这两行代码是把cur插入到pre后  
            pre.next = cur;  
        }  
    }  
}
