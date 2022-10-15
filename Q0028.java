public class Q0028 {
    public static void main(String[] args) {
        System.out.println(strStr("abc", "abc"));
    }

    public static int strStr(String haystack, String needle) {
        int hlen = haystack.length();
        int nlen = needle.length();
        char[] hArray = haystack.toCharArray();
        char[] nArray = needle.toCharArray();
        boolean isMatch = true;
        for (int i = 0; i < hlen - nlen + 1; i++) {
            isMatch = true;
            for (int j = 0; j < nlen; j++) {
                if (hArray[i + j] != nArray[j]) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                return i;
            }
        }
        return -1;
    }
}
