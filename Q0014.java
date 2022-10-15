public class Q0014 {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        StringBuilder res = new StringBuilder();
        if (len == 0) {
            return "";
        }
        if (len == 1) {
            return strs[0];
        }

        String first = strs[0];
        int firstLen = first.length();
        for (int i = 0; i < firstLen; i++) {
            char currChar = first.charAt(i);
            for (int j = 1; j < len; j++) {
                String currStr = strs[j];
                if (i >= currStr.length() || currStr.charAt(i) != currChar) {
                    return res.toString();
                }

            }
            res.append(currChar);
        }
        return res.toString();
    }
}
