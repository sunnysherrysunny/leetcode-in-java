import java.util.HashMap;

public class Q0691 {
    public int minStickers(String[] stickers, String target) {

        int N = stickers.length;

        int[][] freq = new int[N][26];
        char[] curr;
        for (int i = 0; i < N; i++) {
            curr = stickers[i].toCharArray();
            for (char j : curr) {
                freq[i][j - 'a']++;
            }
        }
        HashMap<String, Integer> cachedRes = new HashMap<>();
        cachedRes.put("", 0);

        return minus(freq, target, cachedRes);
    }

    public int minus(int[][] freq, String target, HashMap<String, Integer> cachedRes) {
        if (cachedRes.containsKey(target)) {
            return cachedRes.get(target);
        }
        if (target.length() == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        int[] targetFreq = new int[26];
        char[] targetArray = target.toCharArray();
        for (char curr : targetArray) {

            targetFreq[curr - 'a']++;
        }

        for (int i = 0; i < freq.length; i++) {
            int[] currFreq = freq[i];

            if (currFreq[targetArray[0] - 'a'] > 0) {
                StringBuilder sb = new StringBuilder();


                for (int j = 0; j < 26; j++) {
                    for (int k = 0; k < targetFreq[j] - currFreq[j]; k++) {
                        sb.append((char) ('a' + j));
                    }
                }

                String rest = sb.toString();
                if (rest.length() != target.length()) {
                    min = Math.min(min, minus(freq, rest, cachedRes));
                }

            }

        }

        int res;
        if (min == Integer.MAX_VALUE) {
            res = Integer.MAX_VALUE;
        } else {
            res = min + 1;
        }
        cachedRes.put(target, res);
        return res;

    }


}
