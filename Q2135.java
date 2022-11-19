import java.util.HashSet;
import java.util.Set;

public class Q2135 {

    public static int getBitMap(String word) {
        int res = 0;
        for (char c : word.toCharArray()) {
            int mask = 1 << (c - 'a');
            res = res | mask;
        }
        return res;
    }

    public static int wordCount(String[] startWords, String[] targetWords) {

        Set<Integer> bitmaps = new HashSet<>();
        for (String word : startWords) {
            bitmaps.add(getBitMap(word));
        }
        int res = 0;
        for (String word : targetWords) {
            int currBitMap = getBitMap(word);
            for (char c : word.toCharArray()) {
                int mask = ~(1 << (c - 'a'));
                int newBitMap = currBitMap & mask;
                if (bitmaps.contains(newBitMap)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
