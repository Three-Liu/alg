package leet1143.leet712;


import java.util.Arrays;

class Solution {
    private int[][] memo;
    public int minimumDeleteSum(String s1, String s2) {
        memo = new int[s1.length()][s2.length()];
        for(int i=0;i< s1.length();i++) Arrays.fill(memo[i], Integer.MAX_VALUE);
        return dp(s1, 0, s2, 0);
    }
<<<<<<< HEAD
    /*
        思路：
        dp[i][j] s1[...i]与s2[...j]最小ASCII长度
     */
=======

>>>>>>> 771df5f64f2cba476d5f4e91d43c939f2d2ca4c0
    public int dp(String s1, int a, String s2, int b){
        if(s1.length() == a){
            int t = 0;
            for(int i=b; i<s2.length();i++) t += s2.charAt(i);
            return t;
        }
        if(s2.length() == b){
            int t = 0;
            for(int i=a; i<s1.length();i++) t += s1.charAt(i);
            return t;
        }
        if(memo[a][b] != Integer.MAX_VALUE) return memo[a][b];
        if(s1.charAt(a) == s2.charAt(b)){
            memo[a][b] = dp(s1, a+1, s2, b+1);
        }else {
            memo[a][b] = Math.min(s1.charAt(a)+dp(s1, a + 1, s2, b),
                    s2.charAt(b)+dp(s1, a, s2, b + 1));
        }
        return memo[a][b];
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumDeleteSum("","a"));
        System.out.println(solution.minimumDeleteSum("",""));
        System.out.println(solution.minimumDeleteSum("sea","eat"));
        System.out.println(solution.minimumDeleteSum("delete","leet"));
        System.out.println(solution.minimumDeleteSum("leet","delete"));
    }
}
