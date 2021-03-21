package off4;

import java.util.Scanner;


/*
5 5
1 4 7 11 15
2 5 8 12 19
3 6 9 16 22
10 13 14 17 24
18 21 23 26 30
9
 */

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int i = matrix.length - 1, j = 0, col = matrix[0].length;
        while ( 0 <= i && j < col) {
            if(matrix[i][j]<target){
                j++;
            }else if(matrix[i][j] > target){
                i--;
            }else {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int target = scanner.nextInt();

        System.out.println(new Solution().findNumberIn2DArray(arr, target));

    }
}
