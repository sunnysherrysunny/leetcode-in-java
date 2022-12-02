public class Q0918 {
    public static int maxSubarraySumCircular(int[] nums) {
        int numLen = nums.length;
        int[] prevBest = new int[numLen];
        prevBest[0] = nums[0];
        int[] prefixSum = new int[numLen];
        int prefixSumSoFar = nums[0];
        prefixSum[0] = prefixSumSoFar;
        int linearBestSumSoFar = nums[0];
        for (int i = 1; i < numLen; i++) {
            if (prevBest[i - 1] < 0) {
                prevBest[i] = nums[i];
            } else {
                prevBest[i] = prevBest[i - 1] + nums[i];
            }
            linearBestSumSoFar = Math.max(linearBestSumSoFar, prevBest[i]);
            prefixSumSoFar += nums[i];
            prefixSum[i] = Math.max(prefixSumSoFar, prefixSum[i - 1]);
        }

        int[] suffixSum = new int[numLen];
        int suffixSumSoFar = nums[numLen - 1];
        suffixSum[numLen - 1] = suffixSumSoFar;
        for (int i = numLen - 2; i >= 0; i--) {
            suffixSumSoFar += nums[i];
            suffixSum[i] = Math.max(suffixSumSoFar, suffixSum[i + 1]);
        }
        int circularBestSumSoFar = Integer.MIN_VALUE;
        for (int i = 1; i < numLen; i++) {
            circularBestSumSoFar = Math.max(circularBestSumSoFar, prefixSum[i - 1] + suffixSum[i]);
        }
        return Math.max(linearBestSumSoFar, circularBestSumSoFar);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 3, -3, 9, -6, 8, -5, -5, -6, 10};
        System.out.println(maxSubarraySumCircular(nums));
    }
}
