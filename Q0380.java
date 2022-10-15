import java.util.*;

public class Q0380 {
    private final Map<Integer, Integer> valToIndex;
    private final List<Integer> integerList;

    private final Random rand;

    public Q0380() {
        valToIndex = new HashMap<>();
        integerList = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        valToIndex.put(val, integerList.size());
        integerList.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }

        int idx = valToIndex.get(val);
        valToIndex.remove(val);
        if (idx != integerList.size() - 1) {
            int valToSwap = integerList.get(integerList.size() - 1);
            valToIndex.put(valToSwap, idx);
            integerList.set(idx, valToSwap);
        }
        integerList.remove(integerList.size() - 1);
        return true;
    }

    public int getRandom() {
        int idx = rand.nextInt(integerList.size());
        return integerList.get(idx);
    }
}
