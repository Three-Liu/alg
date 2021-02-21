package leet116;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    /*
     思路
      1. 链接节点的左右节点
      2. 链接左右节点的子节点的左右和左的右子节点和右的左子节点
     */
    public Node connect(Node root) {
        if(root == null) return root;
        connectLeftRight(root.left, root.right);
        return root;
    }

    public void connectLeftRight(Node left, Node right){
        if(left == null || right == null) return;   // 由于是完全二叉树，为null直接判断是叶子节点
        left.next = right;
        connectLeftRight(left.left, left.right);    // 链接左节点的子节点
        connectLeftRight(left.right, right.left);   // 链接右节点的子节点
        connectLeftRight(right.right, right.right); // 链接左右节点的中部
    }
}

public class Main {
}
