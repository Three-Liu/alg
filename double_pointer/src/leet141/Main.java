package leet141;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode fast = head.next, slow = head;
        if(slow == fast) return true;
        while(true){
            if(slow == fast){
                return true;
            }
            if(fast.next == null || fast.next.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
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
        System.out.println(solution.hasCycle(node0));
        System.out.println(solution.hasCycle(node1));
        System.out.println(solution.hasCycle(node2));
    }
}
