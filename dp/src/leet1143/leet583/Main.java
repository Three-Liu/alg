package leet1143.leet583;

class Solution {
    /*
     * 思路：
     * 最小距离就是：两个字符串长度的综合-最大公共序列的长度
     */
    public int minDistance(String word1, String word2) {
        int length = longestCommonString(word1, word2);
        return word1.length() + word2.length() - 2 * length;
    }

    public int longestCommonString(String word1, String word2){
        int[] dp = new int[word2.length()+1];
        for(int i=1;i<=word1.length();i++){
            int pre = 0;
            for(int j=1;j<=word2.length();j++){
                int temp = dp[j];
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[j] = pre + 1;
                }else{
                    dp[j] = Math.max(dp[j], dp[j-1]);
                }
                pre = temp;
            }
        }
        return dp[word2.length()];
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minDistance("abc",""));
        System.out.println(s.minDistance("",""));
        System.out.println(s.minDistance("abc","ab"));
        System.out.println(s.minDistance("aaabaaa","b"));
    }
}
