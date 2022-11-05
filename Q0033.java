public class Q0033 {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int middle;
        while (left < right) {
            middle = (right - left) / 2 + left;
            int leftNum = nums[left];
            int midNum = nums[middle];
            int rightNum = nums[right - 1];

            if (midNum == target) {
                return middle;
            }

            if(leftNum <= midNum) {
                if (midNum <= rightNum) {
                    if (midNum > target) {
                        right = middle;
                    } else {
                        left = middle + 1;
                    }
                } else {
                    if ((midNum > target && target <= rightNum) ||
                            (midNum < target)) {
                        left = middle + 1;
                    } else {
                        right = middle;
                    }
                }

            } else {
                if ((midNum < target && target <= rightNum)) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{9, 10, 11, 12, 99, 100, 101, 102, 103, 104, 105, 106, 107, 111, 112, 114,  1, 2 , 3, 4, 5, 6,  7, 8}, 112));
    }
}
