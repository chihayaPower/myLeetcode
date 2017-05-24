package com.yxh.leetcode.testcase;

import com.yxh.leetcode.testcase.entity.ListNode;

public class test025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        int cnt = 0;
        ListNode cur_node = head;
        ListNode last_tail = newHead;  //上次翻转完以后末尾的那个指针
        while(cur_node!=null) {
            cnt++;
            if(cnt == k) {
                ListNode cp = cur_node.next;  //保存要断掉的那个点的现场

                cur_node.next = null; //先断掉当前的链表  从k那个点
                last_tail = reverseList(last_tail.next, last_tail); //翻转前面K个
                last_tail.next = cp; //然后再接上链表
                
                cur_node = cp;  //设置当前工作指针
                cnt = 0;  //计数器归零
                continue;
            }
            cur_node = cur_node.next;  //工作指针挪到 K个模块的末尾那个去
        }
        return newHead.next;
    }
    
    ListNode reverseList(ListNode head, ListNode last_tail) {
        ListNode next_node = head.next;
        ListNode res = head;
        while(next_node != null) {  //每两个一组翻转
            ListNode tmp = next_node.next;  //先记录下一个点
            next_node.next = head;  // 后面的指针指向前面
            head = next_node;  //  头指针后移
            next_node = tmp;  //  next_node 后移
        }
        last_tail.next = head;
        return res;
    }
    
    
}
