public class Q0011 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, (Math.min(height[left], height[right])) * (right - left));
            System.out.println("l: " + left + "  " + "r: " + right + "  " + max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
