public class Q0162 {
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length;
        int mid;
        int curr;
        while (left < right) {
            mid = left + (right - left) / 2;
            curr = nums[mid];
            if (mid == 0) {
                if (curr > nums[mid + 1]) {
                    return curr;
                } else {
                    left = mid + 1;
                }
            } else if (mid == nums.length - 1) {
                if (nums[mid - 1] < curr) {
                    return curr;
                } else {
                    right = mid;
                }
            } else if (curr > nums[mid + 1]) {
                if (curr > nums[mid - 1]) {
                    return curr;
                } else {
                    right = mid;
                }
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 1, 2, 1}));
    }
}
