package leet72;

class Solution {

    /*
        思路
        dp[i][j] word[...i]和word[...j]得最小编辑距离
        插入 i j - 1       dp[i][j-1] + 1
        删除 i - 1 j       dp[i-1][j] + 1
        替换 i - 1 j - 1   dp[i-1][j-1] + 1

     */


    public int minDistance(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();
        if(word1Length == 0) return word2Length;
        if(word2Length == 0) return word1Length;
        return dp(word1, word1Length-1, word2, word2Length -1);
    }

    public int dp(String word1, int i, String word2, int j){
        if( i < 0 ) return j + 1;
        if( j < 0 ) return i + 1;
        if(word1.charAt(i) == word2.charAt(j)){
            return dp(word1, i - 1, word2, j - 1);
        }else{
            return Math.min(
                    Math.min(
                    dp(word1, i-1, word2, j-1) + 1,
                    dp(word1, i, word2, j-1) + 1),
                    dp(word1, i-1, word2, j) + 1
            );
        }
    }

    public int minDistance2(String word1, String word2) {
        // 边界条件, 任意一个长度是0，直接删除到开头
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++) dp[i][0] = i;
        for(int j=0;j<=word2.length();j++) dp[0][j] = j;


        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    // 相等直接拿前一个得状态
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    // 不相等考察不同得编辑方式
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = new int[0];
        System.out.println(a.length);

        Solution solution = new Solution();
        System.out.println(solution.minDistance2("",""));
        System.out.println(solution.minDistance2("","asd"));
        System.out.println(solution.minDistance2("xyz",""));
        System.out.println(solution.minDistance2("horse","ros"));
        System.out.println(solution.minDistance2("intention","execution"));
    }
}
