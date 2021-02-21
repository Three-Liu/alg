package leet697;

import java.util.*;

class Solution {
    /*
        思路
         nums 拥有相同大小的度的最短连续子数组，
         1. 最大的元素都涵盖再这个最短连续数组中
         2. 最短连续子数组的首尾元素一定是这个度最大的元素
     */
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            if(hashMap.containsKey(nums[i])){
                hashMap.get(nums[i])[0]++;
                hashMap.get(nums[i])[2] = i;
            }else{
                hashMap.put(nums[i],new int[]{1, i, i});
            }
        }
        int maxNum=0, minLen=nums.length;
        for(Map.Entry<Integer, int[]> entry : hashMap.entrySet()){
            int[] temp = entry.getValue();
            if(maxNum < temp[0]){
                maxNum = temp[0];
                minLen = temp[2] - temp[1] + 1;
            }else if (maxNum == temp[0]){
                if(minLen > temp[2] - temp[1] + 1){
                    minLen = temp[2] - temp[1] + 1;
                }
            }
        }
        return minLen;
    }

}

public class Main {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 2, 3, 1};
//        int[] arr = {1, 2};
        int[] arr = {1,2,2,3,1,4,2};
        Solution solution = new Solution();
        System.out.println(solution.findShortestSubArray(arr));
    }
}
