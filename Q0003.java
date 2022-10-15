public class Q0003 {
    public static int lengthOfLongestSubstring(String s) {

        int length = s.length();

        if (length == 1)
            return 1;

        int[] lastOccur = new int[256];
        int longest = 0;
        int tmp = 0;
        int left = 0;
        int right = 0;

        while (right < length) {
            char rightChar = s.charAt(right);
            if (lastOccur[rightChar] > 0) {
                left = Math.max(lastOccur[rightChar], left);
                lastOccur[rightChar] = 0;
            } else {
                lastOccur[rightChar] = right + 1;
                tmp = right - left + 1;
                if (tmp > longest) {
                    longest = tmp;
                }
                if (right == length - 1) {
                    break;
                }
                right++;
            }
        }
        return longest;
    }
}

