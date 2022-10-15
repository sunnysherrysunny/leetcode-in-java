import java.util.HashMap;
import java.util.Map;

public class Q0091 {

    public static int backtrack(char[] c, int start, int length, Map<Integer, Integer> cache) {
        if (start == length) {
            return 1;
        }
        if (c[start] == '0') {
            return 0;
        }
        if (start == length - 1) {
            return 1;
        }

        if (cache.containsKey(start)) {
            return cache.get(start);
        }

        int two = (c[start] - '0') * 10 + (c[start + 1] - '0');
        int res;
        if (two >= 10 & two <= 26) {
            res = backtrack(c, start + 2, length, cache) + backtrack(c, start + 1, length, cache);

        } else {
            res = backtrack(c, start + 1, length, cache);
        }
        cache.put(start, res);
        return res;
    }

    public static int numDecodings(String s) {
        char[] c = s.toCharArray();
        Map<Integer, Integer> cache = new HashMap<>();
        return backtrack(c, 0, c.length, cache);
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("111111111111111111111111111111111111111111111"));
    }
}
