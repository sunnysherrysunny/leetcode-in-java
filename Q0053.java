public class Q0053 {
    public static int maxSubArray(int[] nums) {
        int bestSumSoFar = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + bestSumSoFar >= 0) {
                bestSumSoFar += nums[i];
                res = Math.max(bestSumSoFar, res);
            } else {
                bestSumSoFar = 0;
                res = Math.max(nums[i], res);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
