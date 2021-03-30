package off7;

import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public HashMap<Integer, Integer> m = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            m.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length -1 , 0, preorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int pleft, int pright, int ileft, int iright) {
        if (pleft > pright || ileft > iright) return null;
        TreeNode root = new TreeNode(preorder[pleft]);
        int inorderRoot = m.get(preorder[pleft]);
        int leftSize = inorderRoot - ileft;
        root.left = build(preorder, inorder, pleft+1, pleft+leftSize, ileft, inorderRoot-1);
        root.right = build(preorder, inorder, pleft+leftSize+1, pright, inorderRoot+1, iright);
        return root;
    }
}

public class Main {
}
