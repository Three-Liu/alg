package leet354;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    /*
       思路
       先按第一个边进行排序，相同的按第二边降序，计算LIS
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) { // 1 2 3 2 3 4 5
                if (envelopes[j][1] < envelopes[i][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] env = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(new Solution().maxEnvelopes(env));
    }
}
