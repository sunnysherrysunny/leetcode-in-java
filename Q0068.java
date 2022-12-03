import java.util.ArrayList;
import java.util.List;

public class Q0068 {

    public static String centralJustify(List<String> currLine, int maxWidth,
                                        int lineLenSoFar) {
        int wordCount = currLine.size();
        if (wordCount == 1) {
            return leftJustify(currLine, maxWidth);
        }
        char[] res = new char[maxWidth];
        int idx = 0;
        int interval = (maxWidth - lineLenSoFar) / (wordCount - 1);
        int extraPadding = (maxWidth - lineLenSoFar) % (wordCount - 1);
        for (String s : currLine) {
            for (char c : s.toCharArray()) {
                res[idx] = c;
                idx++;
            }
            for (int j = idx; j < maxWidth && j < idx + interval; j++) {
                res[j] = ' ';
            }
            idx += interval;
            if (extraPadding > 0) {
                res[idx] = ' ';
                idx++;
                extraPadding--;
            }
        }
        return String.valueOf(res);
    }

    public static String leftJustify(List<String> currLine, int maxWidth) {
        char[] res = new char[maxWidth];
        int idx = 0;
        for (int i = 0; i < currLine.size() - 1; i++) {
            for (char c : currLine.get(i).toCharArray()) {
                res[idx] = c;
                idx++;
            }
            res[idx] = ' ';
            idx++;
        }
        for (char c : currLine.get(currLine.size() - 1).toCharArray()) {
            res[idx] = c;
            idx++;
        }
        for (int j = idx; j < maxWidth; j++) {
            res[j] = ' ';
        }
        return String.valueOf(res);
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> currLine = new ArrayList<>();
        int wordLenSoFar = 0;
        int whiteSpaceCount = 0;
        for (String word : words) {
            if (wordLenSoFar + whiteSpaceCount + word.length() > maxWidth) {
                res.add(centralJustify(currLine, maxWidth, wordLenSoFar));
                wordLenSoFar = 0;
                whiteSpaceCount = 0;
                currLine = new ArrayList<>();
            }
            currLine.add(word);
            wordLenSoFar += word.length();
            whiteSpaceCount += 1;
        }
        res.add(leftJustify(currLine, maxWidth));
        return res;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"abc", "de", "efd", "hello", "rea", "ok"
                , "sss", "xxx", "oxox", "areyouok", "thankyou", "why", "id",
                "rs", "ad"};
        System.out.println(fullJustify(words, 12));

    }
}
