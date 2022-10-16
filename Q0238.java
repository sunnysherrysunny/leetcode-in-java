public class Q0238 {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int zeroIdx = 0;
        int totalProduct = 1;
        int curr;
        for (int i = 0; i < nums.length; i++) {
            curr = nums[i];
            if (curr == 0) {
                zeroCount++;
                zeroIdx = i;
                if (zeroCount >= 2) {
                    return new int[nums.length];
                }
            } else {
                totalProduct *= curr;
            }
        }
        int[] res = new int[nums.length];
        if (zeroCount > 0) {
            res[zeroIdx] = totalProduct;
            return res;
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = totalProduct / nums[i];
        }
        return res;
    }
}
