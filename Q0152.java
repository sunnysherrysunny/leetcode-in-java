public class Q0152 {

    public static void dp(int[] nums, int[] res, int curr, int maxSoFar,
                          int minSoFar) {
        if (curr >= nums.length) {
            return;
        }

        int newMaxSoFar = Math.max(Math.max(nums[curr] * maxSoFar,
                nums[curr] * minSoFar), nums[curr]);
        int newMinSoFar = Math.min(Math.min(nums[curr] * maxSoFar,
                nums[curr] * minSoFar), nums[curr]);
        res[curr] = newMaxSoFar;
        dp(nums, res, curr + 1, newMaxSoFar, newMinSoFar);
    }

    public static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] res = new int[nums.length];
        dp(nums, res, 1, 1, 1);
        int maxP = Integer.MIN_VALUE;
        for (int x : res) {
            maxP = Math.max(maxP, x);
        }
        return maxP;
    }

    public static void main(String[] args) {
        //System.out.println(maxProduct(new int[]{1,2, 3, 4, -1}));
        System.out.println(maxProduct(new int[]{-2, 3, -4}));
    }
}
