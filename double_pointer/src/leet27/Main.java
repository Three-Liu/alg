package leet27;

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] == val) {
                i++;
                continue;
            }
            nums[j] = nums[i];
            i++;
            j++;
        }
        return j;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][][] result = {
                {{3, 2, 2, 3},{3}},
                {{0, 1, 2, 2, 3, 0, 4, 2},{2}}
        };
        Solution solution = new Solution();
        for(int[][] t: result){
            System.out.println(solution.removeElement(t[0],t[1][0]));
        }
    }
}
