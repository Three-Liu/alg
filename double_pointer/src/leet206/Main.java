package leet206;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = head, cur = pre.next;
        pre.next = null;
        while(cur!=null){
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        return pre;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
//        head.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
        Solution solution = new Solution();
        solution.reverseList(head);
        ;
    }
}
