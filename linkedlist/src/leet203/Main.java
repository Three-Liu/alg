package leet203;


import java.awt.*;
import java.lang.management.ThreadInfo;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode pre = newHead, cur = pre.next;
        while(cur!=null){
            if(cur.val==val){
                pre.next = cur.next;
                cur = pre.next;
                continue;
            }
            pre = cur;
            cur = cur.next;
        }
        return newHead.next;
    }
}
public class Main {
    public static void main(String[] args) {
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Solution solution = new Solution();
        solution.removeElements(null, 3);
    }
}
