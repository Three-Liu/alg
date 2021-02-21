package traverse;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public List<Integer> preOrder(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode t = stack.pop();
            res.add(t.val);
            if(t.right!=null){
                stack.push(t.right);
            }
            if(t.left !=null){
                stack.push(t.left);
            }
        }
        return res;
    }
    public List<Integer> inOrder(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
    public List<Integer> postOrder(TreeNode root){
        Deque<TreeNode> stack0 = new LinkedList<>();
        Deque<TreeNode> stack1 = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        stack0.push(root);
        while (!stack0.isEmpty()){
            TreeNode t = stack0.pop();
            stack1.push(t);
            if(t.left!=null){
                stack0.push(t.left);
            }
            if(t.right!=null){
                stack0.push(t.right);
            }
        }
        while(!stack1.isEmpty()){
            res.add(stack1.pop().val);
        }
        return res;
    }

    public void print(List<Integer> list){
        for(int i: list){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right =  new TreeNode(5);
        root.right.right = new TreeNode(6);
        Main main = new Main();
        main.print(main.preOrder(root));
        main.print(main.inOrder(root));
        main.print(main.postOrder(root));
    }
}
