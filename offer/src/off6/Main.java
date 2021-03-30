package off6;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/*
1
3
2
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public int[] reversePrint(ListNode head) {
        if(head == null) return new int[0];
        ListNode p = head;
        Deque<Integer> l = new LinkedList<>();
        while(p!=null){
            l.push(p.val);
            p = p.next;
        }
        int[] res = new int[l.size()];
        int size = 0;
        while(!l.isEmpty()){
            res[size++] = l.pop();
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s = s.trim();
        ListNode head = new ListNode(-1);
        ListNode p = head;
        boolean first = true;
        for( String t: s.split(" ")){
            if(first){
                p.val = Integer.parseInt(t);
                first = false;
            }else{
                p.next = new ListNode(Integer.parseInt(t));
                p = p.next;
            }
        }
        new Solution().reversePrint(head);
    }
}
