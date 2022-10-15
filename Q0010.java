/* not finished*/
public class Q0010 {
    public boolean isMatch(String s, String p) {
        if (s == "" && p != "") {
            return false;
        }

        String[] patterns = p.split("\\*");
        char[] str = s.toCharArray();
        return match(str, patterns, 0, 0);

        // "a*ab" "aab" =>match a with a => "ab ab" =>"match a orelse not match"
    }

    public boolean match(char[] str, String[] patterns, int strIndex, int pattIndex) {
        if (pattIndex >= patterns.length && strIndex >= str.length) return true;
        if (pattIndex >= patterns.length) return false;
        if (strIndex >= str.length) return false;
        char[] currPatt = patterns[pattIndex].toCharArray();
        int newStrIndex = strIndex;
        boolean flag = true;


        for (int i = 0; i < currPatt.length; i++) {
            if (newStrIndex >= str.length) {
                flag = false;
                break;
            }

            if (str[newStrIndex] != currPatt[i]) {
                flag = false;
                break;
            }

            newStrIndex++;
        }
        //Comparision finished
        if (newStrIndex == str.length && pattIndex == patterns.length - 1) {
            return true;
        }
        if (flag) {
            return match(str, patterns, strIndex, pattIndex + 1) || match(str, patterns, newStrIndex, pattIndex);
        } else {
            return match(str, patterns, strIndex, pattIndex + 1);
        }

    }
}
