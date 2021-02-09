package leet516;

class Solution {
    /*
        思路：
        dp[i][j] 定义 i 到 j 的最长回文字串
        转移
        dp[i][j] = dp[i+1][j-1] + 2               s[i] == s[j] 两头相等加中间
        dp[i][j] = max(dp[i+1][j], dp[i][j-1])    s[i] != s[j] 两头看 s[i+1]和s[j] s[i]和s[j-1]
     */
    public int longestPalindromeSubseq(String s) {
        if(s.length() == 0 ) return 0;
        if(s.length() == 1 ) return 1;
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0;i<s.length();i++) dp[i][i] = 1;
        for(int i = s.length()-2;i>=0;i--){
            for(int j = i+1;j < s.length();j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}

public class Main {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(new Solution().longestPalindromeSubseq(s));
        s = "";
        System.out.println(new Solution().longestPalindromeSubseq(s));
        s = "c";
        System.out.println(new Solution().longestPalindromeSubseq(s));
        s = "aaaa";
        System.out.println(new Solution().longestPalindromeSubseq(s));
        s = "abcd";
        System.out.println(new Solution().longestPalindromeSubseq(s));
        s = "bbbab";
        System.out.println(new Solution().longestPalindromeSubseq(s));
    }
}
