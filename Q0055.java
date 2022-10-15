public class Q0055 {

    public static void helper(int[] nums, boolean[] cache, int currIdx) {
        if (currIdx == nums.length - 1) {
            cache[currIdx] = true;
            return;
        }
        int curr = nums[currIdx];
        if (curr == 0) {
            cache[currIdx] = false;
            return;
        }
        for (int i = curr; i > 0; i--) {
            if (currIdx + i >= nums.length - 1) {
                cache[currIdx] = true;
                return;
            }
            helper(nums, cache, currIdx + i);
            if (cache[currIdx + i]) {
                cache[currIdx] = true;
                return;
            }
        }
    }

    public static boolean canJump(int[] nums) {
        int start = 0;
        int end = nums[0];
        while (end < nums.length - 1) {
            int currDistance = 0;
            for (int i = start + 1; i <= end; i++) {
                if (i + nums[i] > currDistance) {
                    currDistance = i + nums[i];
                }
            }
            if (currDistance <= end) {
                return false;
            }
            start = end;
            end = currDistance;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{1, 2, 3}));
    }
}
