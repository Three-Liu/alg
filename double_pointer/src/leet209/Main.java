package leet209;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= target) {
                min = Math.min(min, j - i + 1);
                sum -= nums[i++];
            }
            j++;
        }
        return min == Integer.MAX_VALUE ? 0:min;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][][] nums = {
                {{2, 3, 1, 2, 4, 3}, {7}},
                {{1, 1, 1, 1, 1, 1, 1, 1}, {11}},
                {{1, 4, 4}, {4}},
        };
        for(int[][] n : nums)
            System.out.println(solution.minSubArrayLen(n[1][0], n[0]));
    }
}
