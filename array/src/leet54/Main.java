package leet54;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                arrayList.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                arrayList.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i > left; i--) {
                    arrayList.add(matrix[bottom][i]);
                }
                for (int i = bottom; i > top; i--) {
                    arrayList.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return arrayList;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4, 5}};
        int[][] arr1 = {{1}, {2}, {3}, {4}, {5}};
        int[][] arr2 = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        Solution solution = new Solution();
        List<Integer> l = solution.spiralOrder(arr);
        List<Integer> l1 = solution.spiralOrder(arr1);
        List<Integer> l2 = solution.spiralOrder(arr2);
        for (int i : l) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : l1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : l2) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
