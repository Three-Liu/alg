package leet300;

/*
* https://leetcode-cn.com/problems/longest-increasing-subsequence/
*
* Input: nums = [10,9,2,5,3,7,101,18]
* Output: 4
*
* Input: nums = [0,1,0,3,2,3]
* Output: 4
*
* Input: nums = [7,7,7,7,7,7,7]
* Output: 1
*
* */

import java.util.Arrays;

class Solution {
    /*
    思路1.
       dp[i]: 以nums[i]结尾的递增子序列的最长长度
       if nums[j] < nums[i] dp[i] = max(dp[i],dp[j] + 1)  0 < j < i
       else continue
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }    /*
    思路2.
       patience sorting
       牌堆从上到下由小变大，取一个数，如果数比现有牌堆顶都大，新建一个牌堆，这样牌堆顶部相对有序，牌堆的堆数就是最长非降序列的长度
     */
    public int lengthOfLIS2(int[] nums) {
        int [] stack = new int[nums.length];
        int piles = 0;
        for (int num : nums) {
            int left = 0, right = piles;
            while (left < right) {
                int mid = (right + left) / 2;
                if (num == stack[mid]) break;
                else if (num < stack[mid]) right = mid;
                else left = mid + 1;
            }
            if (left == piles) {
                piles++;
            }
            stack[left] = num;
        }
        return piles;
    }

}

public class Main{
    public static void main(String[] args) {
        int[][] examples = {{10, 9, 2, 5, 3, 7, 101, 18}, {0,1,0,3,2,3}, {7,7,7,7,7,7,7}};
        for(int [] example: examples){
            int result = new Solution().lengthOfLIS2(example);
            System.out.println(result);
        }
    }
}