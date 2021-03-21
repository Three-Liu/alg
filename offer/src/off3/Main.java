package off3;
class Solution {
    public int findRepeatNumber(int[] nums) {
        int t;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                t = nums[i];
                nums[i] = nums[t];
                nums[t] = t;
            }
        }
        return -1;
    }
}
public class Main {
    public static void main(String[] args) {
        int res = new Solution().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
        System.out.println(res);
    }
}
