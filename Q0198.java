public class Q0198 {
    public static int rob(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return nums[0];
        }
        int[] ans = new int[len];
        ans[0] = nums[0];
        ans[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            ans[i] = Math.max(ans[i - 1], ans[i - 2] + nums[i]);
        }
        return Math.max(ans[len - 2], ans[len - 1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }
}
