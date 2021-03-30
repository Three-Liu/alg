package bfs;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class ShortestPath {
    static class Node{
        public int parent;
        public int current;
        public Node(){}
        public Node(int p, int c){parent = p; current=c;}
    }
    public static void main(String[] args) {
        int[][] arr = {
                {0,1,1,0,1},
                {1,0,0,1,0},
                {1,0,0,0,1},
                {0,1,1,0,0},
                {1,0,0,1,0},
        };
        int tgt = 3;
        Deque<Node> queue = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        HashMap<Integer, Node> visited = new HashMap<>();
        Node i;
        queue.offer(new Node(-1,0));
        while(!queue.isEmpty()){
            i = queue.poll();
            if(visited.containsKey(i.current)) continue;
            visited.put(i.current, i);
            if(i.current == tgt) break;
            for(int j=0;j<arr[0].length;j++){
                if(arr[i.current][j] == 1 && visited.containsKey(i.current)){
                    queue.offer(new Node(i.current, j));
                }
            }
        }
        int t = tgt;
        result.addFirst(t);
        while((t = visited.get(t).parent)!=-1){
            result.addFirst(t);
        }
        return;
    }
}

