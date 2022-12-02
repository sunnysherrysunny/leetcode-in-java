public class Q0918 {
    public static int maxSubarraySumCircular(int[] nums) {
        int numLen = nums.length;
        int[] prevMax = new int[numLen];
        int[] prevMin = new int[numLen];
        int maxSumSoFar = nums[0];
        int minSumSoFar = nums[0];
        int totalSum = nums[0];
        int currNum;
        prevMax[0] = nums[0];
        prevMin[0] = nums[0];
        for (int i = 1; i < numLen; i++) {
            currNum = nums[i];
            totalSum += currNum;
            prevMax[i] = Math.max(prevMax[i - 1] + currNum, currNum);
            prevMin[i] = Math.min(prevMin[i - 1] + currNum, currNum);
            maxSumSoFar = Math.max(maxSumSoFar, prevMax[i]);
            minSumSoFar = Math.min(minSumSoFar, prevMin[i]);
        }
        if (totalSum == minSumSoFar) {
            return maxSumSoFar;
        }
        return Math.max(maxSumSoFar, totalSum - minSumSoFar);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-3, -2, -3};
        System.out.println(maxSubarraySumCircular(nums));
    }
}
