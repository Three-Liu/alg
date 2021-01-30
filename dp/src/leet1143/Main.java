package leet1143;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return dp(text1, 0, text2, 0);
    }
    /*
     思路
         挨个比较，如果相同往前挪，不相同只挪一个
         dp[i][j] text1前i个字符串和text2中前j个字符串LCS得最大值
    */
    public int dp(String a, int la, String b, int lb){
        if(la == a.length() || lb == b.length())return 0;
        if(a.charAt(la) == b.charAt(lb)){
            return 1 + dp(a, la+1, b, lb+1);
        }else {
            return Math.max(dp(a, la+1, b, lb), dp(a, la, b, lb+1));
        }
    }
    public int longestCommonSubsequence2(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=1;i<=text1.length();i++){
            for(int j=1;j<=text2.length();j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
    public int longestCommonSubsequence3(String text1, String text2) {
        int[] dp = new int[text2.length()+1];
        for(int i=1;i<=text1.length();i++){
            int pre = 0;
            for(int j=1;j<=text2.length();j++){
                int temp = dp[j];
                if(text1.charAt(i-1) == text2.charAt(j-1)){
//                    dp[i][j] = 1 + dp[i-1][j-1];
                    dp[j] = 1 + pre;
                }else{
//                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                    dp[j] = Math.max(dp[j-1],dp[j]);
                }
                pre = temp;
            }
        }
        return dp[text2.length()];
    }
}
public class Main {
    public static void main(String[] args) {
        String[][] array = new String[][]{
            {"abcde","ace"},
            {"abc","abc"},
            {"abc","defc"},
            {"","defc"},
            {"",""},
        };
        Solution solution = new Solution();
        for(String[] pair: array){
            System.out.println(solution.longestCommonSubsequence3(pair[0],pair[1]));
        }
    }
}
