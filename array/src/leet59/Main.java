package leet59;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int t = n / 2, i = 0, cnt = 1;
        while (i < t) {
            for (int j = i; j < n - i - 1; j++) {
                matrix[i][j] = cnt++;
            }
            for (int j = i; j < n - i - 1; j++) {
                matrix[j][n - i - 1] = cnt++;
            }
            for (int j = n - i - 1; j >i; j--) {
                matrix[n - i - 1][j] = cnt++;
            }
            for (int j = n - i - 1; j >i; j--) {
                matrix[j][i] = cnt++;
            }
            i++;
        }
        if(n%2 != 0){
            matrix[n/2][n/2] = cnt++;
        }
        return matrix;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateMatrix(1);
        solution.generateMatrix(2);
        solution.generateMatrix(3);
        solution.generateMatrix(4);
    }
}
