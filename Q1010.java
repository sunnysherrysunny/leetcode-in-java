public class Q1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] mods = new int[60];
        for (int t : time) {
            mods[t % 60]++;
        }
        int res = 0;
        for (int i = 1; i <= 29; i++) {
            res += mods[i] * mods[60 - i];
        }
        int count0 = (int)(((long)mods[0] * (long)(mods[0] - 1)) / 2L);
        int count30 = (int)((long)mods[30] * (long)(mods[30] - 1) / 2L);
        return res + count30 + count0;
    }
}
