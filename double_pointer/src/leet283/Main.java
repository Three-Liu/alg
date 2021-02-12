package leet283;

class Solution {
    /*
       思路 双指针，left 标识 0 的位置， right标识非零元素位置
     */
    public void moveZeroes(int[] nums) {
        int left = 0, right =0;
        while(right < nums.length){
            if (nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++; // left 标记0的位置，left right都不等于0的时候，同时往前移动，否则只有right进行移动找寻非零元素
            }
            right++;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,0,0,4};
        solution.moveZeroes(arr);
        for(int i:arr) System.out.print(i+" ");
    }
}
