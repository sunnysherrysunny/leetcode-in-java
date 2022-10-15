public class Q0005 {
    public static String longestPalindrome(String s) {

        int length = s.length();
        if (length == 1) return s;
        if (length == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return (s.substring(0, 1));
            }
        }

        int longestLength = 0;
        int left = 0;
        int right = 0;
        int longestLeft = 0;
        int longestRight = 0;
        for (int center = 0; center < length; center++) {
            //odd length
            left = center;
            right = center;
            while (left >= 0 && right <= length - 1 && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (longestLength < (right - left - 1)) {
                longestLeft = left + 1;
                longestRight = right - 1;
                longestLength = (right - left - 1);
            }

            //even length
            left = center;
            right = center + 1;
            while (left >= 0 && right <= length - 1 && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (longestLength < (right - left - 1)) {
                longestLeft = left + 1;
                longestRight = right - 1;
                longestLength = (right - left - 1);
            }
        }


        return s.substring(longestLeft, longestRight + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aba"));
    }

}