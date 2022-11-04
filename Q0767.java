import java.util.LinkedList;
import java.util.Queue;

public class Q0767 {
    public static String reorganizeString(String s) {
        if (s.length() == 0)
            return "";
        char[] sArr = s.toCharArray();
        StringBuilder res = new StringBuilder();
        Queue<Character> pending = new LinkedList<>();
        res.append(sArr[0]);
        for(int i = 1; i < sArr.length; i ++){
            if (res.charAt(res.length() - 1) == sArr[i]) {
                pending.add(sArr[i]);
            } else {
                res.append(sArr[i]);
                if (pending.size() > 0) {
                    res.append(pending.remove());
                }

            }
        }
        if (pending.size() > 0) {
            return "";
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aaccccaaccaabb"));
    }
}
