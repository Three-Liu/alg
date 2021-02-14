package leet142;


import java.security.cert.TrustAnchor;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode fast = head, slow = head;
        while(fast!=null){
            slow = slow.next;
            if(fast.next==null)
                return null;
            else
                fast = fast.next.next;
            if(fast == slow){
                ListNode tmp = head;
                while(tmp!=slow){
                    tmp = tmp.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node0.next = node0;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        Solution solution = new Solution();
        System.out.println(solution.detectCycle(node0).val);
        System.out.println(solution.detectCycle(node1));
        System.out.println(solution.detectCycle(node2).val);
    }
}
