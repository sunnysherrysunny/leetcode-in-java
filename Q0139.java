import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q0139 {
    public static boolean dp(String s, List<String> wordDict, HashMap<String, Boolean> cache) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        int idx = 0;

        for (String word :
                wordDict) {
            idx = s.indexOf(word);
            if (idx != -1) {
                if (dp(s.substring(0, idx), wordDict, cache) &&
                        dp(s.substring(idx + word.length()), wordDict, cache)) {
                    cache.put(s, true);
                    return true;
                }
            }
        }
        cache.put(s, false);
        return false;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> cache = new HashMap<>();
        cache.put("", true);
        return dp(s, wordDict, cache);
    }

    public static void main(String[] args) {
        String s = "ccbb";
        List<String> wordDict = Arrays.asList("bc", "cb");
        System.out.println(wordBreak(s, wordDict));
    }
}
