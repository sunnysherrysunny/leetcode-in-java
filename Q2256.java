public class Q2256 {
    public int minimumAverageDifference(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        long totalSum = 0;
        int len = nums.length;
        for (int n : nums) {
            totalSum += n;
        }
        long leftSum = 0;
        long rightSum = totalSum;
        long smallestSoFar = Long.MAX_VALUE;
        int smallestIdx = -1;
        for (int i = 0; i < len - 1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            long currDiff =
                    Math.abs((leftSum / (long) (i + 1)) - (rightSum / (long) (len - i - 1)));
            if (currDiff < smallestSoFar) {
                smallestSoFar = currDiff;
                smallestIdx = i;
            }
        }
        if (Math.abs(totalSum / len) < smallestSoFar) {
            return len - 1;
        }
        return smallestIdx;
    }
}
