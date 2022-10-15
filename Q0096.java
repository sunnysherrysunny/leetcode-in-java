import java.util.HashMap;


public class Q0096 {
    public int numTrees(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;


        HashMap<Integer, Integer> cachedRes = new HashMap<>(19);
        cachedRes.put(0, 1);
        cachedRes.put(1, 1);
        cachedRes.put(2, 2);
        return generate(n, cachedRes);
    }

    public int generate(int n, HashMap<Integer, Integer> cachedRes) {
        if (cachedRes.containsKey(n)) {
            return cachedRes.get(n);
        }

        int res = 0;

        for (int left = 0; left < n; left++) {
            res += generate(left, cachedRes) * generate((n - 1 - left), cachedRes);
        }

        cachedRes.put(n, res);
        return res;


    }
}
