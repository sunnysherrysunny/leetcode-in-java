public class Q0088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }

        if (m == 0) {
            if (n >= 0) System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }

        int left = 0;
        int right = 0;
        int index = 0;
        int[] res = new int[m + n];

        while (left < m && right < n) {
            if (nums1[left] < nums2[right]) {
                res[index] = nums1[left];
                left++;
            } else {
                res[index] = nums2[right];
                right++;
            }
            index++;
        }

        while (left < m) {
            res[index] = nums1[left];
            index++;
            left++;
        }

        while (right < n) {
            res[index] = nums2[right];
            index++;
            right++;
        }

        if (m + n >= 0) System.arraycopy(res, 0, nums1, 0, m + n);

    }
}
