import java.util.Arrays;

public class Q0451 {
    public static String frequencySort(String s) {
        int freqLen = 'z' - '0';
        CharacterFreq[] freqs = new CharacterFreq[freqLen];
        for (int i = 0; i < freqLen; i++) {
            freqs[i] = new CharacterFreq();
            freqs[i].c = (char) ('0' + i);
            freqs[i].freq = 0;
        }
        int count = 0;
        int currIdx = 0;
        CharacterFreq curr = null;
        StringBuilder res = new StringBuilder();
        char[] sArr = s.toCharArray();
        for (char c : sArr) {
            int idx = c - '0';
            CharacterFreq oldfreq = freqs[idx];
            oldfreq.freq++;
            count++;
        }
        Arrays.sort(freqs);
        while (count > 0) {
            while (currIdx < freqLen && freqs[currIdx].freq == 0) {
                currIdx++;
            }
            if (currIdx >= freqLen) {
                break;
            }
            curr = freqs[currIdx];
            res.append(curr.c);
            curr.freq--;
            count--;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort(
                "tAArB1324235w4233123123123qr2q34324BeCesadasd"));
    }
}

class CharacterFreq implements Comparable<CharacterFreq> {

    public char c;
    public int freq;

    public CharacterFreq() {
    }

    public CharacterFreq(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }


    @Override
    public int compareTo(CharacterFreq o) {
        return o.freq - this.freq;
    }
}
