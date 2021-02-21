package leet94.inorder;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        while(root!=null||!linkedList.isEmpty()){
            while(root!=null){
                linkedList.push(root);
                root = root.left;
            }
            root = linkedList.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Solution solution = new Solution();
        System.out.println(solution.inorderTraversal(root));
    }
}
