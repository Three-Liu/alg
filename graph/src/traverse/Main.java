package traverse;


import java.util.*;

/*
6
a-b
b-c
c-d
b-f
f-e
e-d


a - b - c - d
      - f - e -d
{
    {0, 1, 0, 0, 0, 0},
    {1, 0, 1, 0, 0, 1},
    {0, 1, 0, 1, 0, 0},
    {0, 0, 1, 0, 0, 1},
    {0, 0, 0, 0, 0, 1},
    {0, 1, 0, 1, 1, 0},
}
0 1 2 5 3 4
a b c f d e
0 1 2 3 5 4
a b c d f e
 */
class BFSTraverse {
    private static LinkedList<Integer> l = new LinkedList<>();
    public static List<Integer> traverse(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        int[] visited = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (visited[i] == 0) {
                        visited[i] = 1;
                        bfs(grid, i, visited);
                    }
                }
            }
        }
        return l;
    }

    private static void bfs(int[][] grid, int start, int[] visited) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(start);
        while (!deque.isEmpty()) {
            int temp = deque.pop();
            l.add(temp);
            for (int i = 0; i < grid[0].length; i++) {
                if(grid[temp][i] == 1 && visited[i] == 0){
                    visited[i] = 1;
                    deque.offer(i);
                }
            }
        }
    }
}

class DFSTraverse {
    private static LinkedList<Integer> l = new LinkedList<>();
    public static List<Integer> traverse(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        int[] visited = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (visited[i] == 0) {
                        visited[i] = 1;
                        dfs(grid, i, visited);
                    }
                }
            }
        }
        return l;
    }

    private static void dfs(int[][] grid, int start, int[] visited) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(start);
        l.add(start);
        boolean pushed = false;
        while (!stack.isEmpty()) {
            pushed = false;
            int top = stack.peek();
            for (int i = 0; i < grid[0].length; i++) {
                if(grid[top][i] == 1 && visited[i] == 0){
                    visited[i] = 1;
                    stack.push(i);
                    l.add(i);
                    pushed = true;
                    break;
                }
            }
            if(!pushed){
                stack.pop();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        DFSTraverse.traverse(new int[][]{
                {0, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 1},
                {0, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 1},
                {0, 1, 0, 1, 1, 0},
        });
    }
}
