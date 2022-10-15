import java.util.*;

public class Q0140 {

    public static void backtrack(String s, Set<String> wordDict, int index, StringBuilder stringBuilder, List<String> res) {
        if (index == s.length()) {
            res.add(stringBuilder.toString().trim());
        }

        for (int i = index; i < s.length(); i++) {
            String currSub = s.substring(index, i + 1);
            if (wordDict.contains(currSub)) {
                int originalEnd = stringBuilder.length();
                stringBuilder.append(currSub);
                stringBuilder.append(" ");
                backtrack(s, wordDict, i + 1, stringBuilder, res);
                stringBuilder.replace(originalEnd, stringBuilder.length(), "");
            }
        }
    }

    public static List<String> wordBreak2(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        backtrack(s, wordDictSet, 0, new StringBuilder(), res);
        return res;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreak2(s, wordDict));
    }


}
