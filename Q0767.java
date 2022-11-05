import java.util.Arrays;

public class Q0767 {
    public static String reorganizeString(String s) {
        int freqLen = 'z' - 'a' + 1;
        CharacterFreq[] freqs = new CharacterFreq[freqLen];
        for (int i = 0; i < freqLen; i++) {
            freqs[i] = new CharacterFreq();
            freqs[i].c = (char) ('a' + i);
            freqs[i].freq = 0;
        }
        int count = 0;
        int currIdx = 0;
        CharacterFreq curr = null;
        char[] sArr = s.toCharArray();
        for (char c : sArr) {
            int idx = c - 'a';
            CharacterFreq oldfreq = freqs[idx];
            oldfreq.freq++;
            count++;
        }
        Arrays.sort(freqs);
        if ((count % 2 == 1 && freqs[0].freq > count / 2 + 1) || (count % 2 == 0 && freqs[0].freq > count / 2)) {
            return "";
        }
        char[] res = new char[count];
        for (int i = 0; i < count / 2; i++) {
            while (currIdx < freqLen && freqs[currIdx].freq == 0) {
                currIdx++;
            }
            if (currIdx >= freqLen) {
                break;
            }
            curr = freqs[currIdx];
            res[i * 2] = curr.c;
            curr.freq--;
        }
        if (count % 2 == 1) {
            while (currIdx < freqLen && freqs[currIdx].freq == 0) {
                currIdx++;
            }
            if (currIdx < freqLen) {
                curr = freqs[currIdx];
                res[count - 1] = curr.c;
                curr.freq--;
            }
        }
        for (int i = 0; i < count / 2; i++) {
            while (currIdx < freqLen && freqs[currIdx].freq == 0) {
                currIdx++;
            }
            if (currIdx >= freqLen) {
                break;
            }
            curr = freqs[currIdx];
            res[i * 2 + 1] = curr.c;
            curr.freq--;
        }

        return String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("abbbbaaccdefaaaaaaaa"));
    }
}
