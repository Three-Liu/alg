package leet720;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    /*
        要求词前缀存在在字典中，且词本身最长，相同长度取字典序小的
        思路 1. 记录所有前缀到HashSet，逐次拆分，使用长度减少判断次数，使用compareTo比较字典序 O(∑wi²)
        思路 2. 先排序然，然后再进行查找 O(∑wi²)
        思路 3. 使用前缀树, O(∑wi)
     */
    public String longestWord(String[] words) {
        String ans = "";
        Set<String> set = new HashSet<>();
        for(String word: words) set.add(word);
        for(String word: words){
            // 1. 如果一个词比当前计算出得目标词长度短一定不是最后答案
            // 2. 如果两个词相同比较字典序小的才有继续计算得意义
            if(word.length()>ans.length()||word.length()==ans.length()&&word.compareTo(ans)<0){
                boolean flag = true;
                for(int i=1;i<word.length();i++){
                    // 判断所有前缀是否都在
                    // substring 取 [a,b)
                    if(!set.contains(word.substring(0, i))){
                        flag = false;
                        break;
                    }
                }
                if(flag) ans = word;
            }
        }
        return ans;
    }
    public String longestWord2(String[] words) {
        class Node {
            char c;
            HashMap<Character, Node> children = new HashMap<>();
            int idx;
            public Node(){}
            public Node(char c){
                this.c = c;
            }
        }
        class Tree{
            Node root = new Node();
            public void insert(String word, int idx){
                Node cur = this.root;
                for(char c: word.toCharArray()){
                    cur.children.putIfAbsent(c, new Node(c));
                    cur = cur.children.get(c);
                }
                cur.idx = idx;
            }
            public String search(String[] words){
                Stack<Node> stack = new Stack<>();
                stack.push(root);
                String ans = "";
                while(!stack.isEmpty()){
                    Node node = stack.pop();
                    if (node.idx > 0 || node == root) {
                        if (node != root) {
                            String word = words[node.idx - 1];
                            if (word.length() > ans.length() ||
                                    word.length() == ans.length() && word.compareTo(ans) < 0) {
                                ans = word;
                            }
                        }
                        for (Node nei: node.children.values()) {
                            stack.push(nei);
                        }
                    }
                }
                return ans;
            }
        }
        Tree tree = new Tree();
        int idx = 0;
        for(String s: words){
            tree.insert(s,++idx);
        }
        return tree.search(words);
    }
}


public class Main{
    public static void main(String[] args) {
        String[] words = {"w","wo","wor","worl", "world"};
        String[] words1 = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        Solution solution = new Solution();
//        System.out.println(solution.longestWord(words));
        System.out.println(solution.longestWord2(words1));
    }
}