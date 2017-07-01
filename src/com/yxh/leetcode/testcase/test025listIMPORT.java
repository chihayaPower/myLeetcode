package com.yxh.leetcode.testcase;

import com.yxh.leetcode.testcase.entity.ListNode;

/*
 * 25Leetcode: Reverse Nodes in k-Group

仅允许使用常数时间, 交换 k-group 的节点
 
思路:
1. 完全逆转一个链表: 每遍历到一个节点, 就将该节点放在链表首位
2. 在(1) 的基础上添加大小为 j 的窗口
 
总结:
1. 看来上一道题目思路也不是最优的
 */

public class test025listIMPORT {
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
        last_tail.next = head;  //连上之前的已调转好的
        return res;   //指向第一个  调转后的最后一个
    }
    
    
}
