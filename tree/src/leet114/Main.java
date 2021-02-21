package leet114;

import common.TreeNode;

class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode p = root;
        while(p.right!=null) p = p.right;
        p.right = right;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right =  new TreeNode(5);
        root.right.right = new TreeNode(6);
        Solution solution = new Solution();
        solution.flatten(root);
    }
}
