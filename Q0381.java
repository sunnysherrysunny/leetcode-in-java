import java.util.*;

public class Q0381 {
    private final Map<Integer, LinkedHashSet<Integer>> valToIndexes;
    private final List<Integer> integerList;

    private final Random rand;

    public Q0381() {
        valToIndexes = new HashMap<>();
        integerList = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (valToIndexes.containsKey(val)) {
            valToIndexes.get(val).add(integerList.size());
            integerList.add(val);
            return false;
        }
        LinkedHashSet<Integer> newIdxes = new LinkedHashSet<>();
        newIdxes.add(integerList.size());
        integerList.add(val);
        valToIndexes.put(val, newIdxes);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndexes.containsKey(val)) {
            return false;
        }
        LinkedHashSet<Integer> removeIndexes = valToIndexes.get(val);
        int indexToRemove = removeIndexes.iterator().next();
        removeIndexes.remove(indexToRemove);
        if (removeIndexes.size() == 0) {
            valToIndexes.remove(val);
        }
        if (indexToRemove != integerList.size() - 1) {
            int valToSwap = integerList.get(integerList.size() - 1);
            LinkedHashSet<Integer> swapIndexes = valToIndexes.get(valToSwap);
            swapIndexes.remove(integerList.size() - 1);
            swapIndexes.add(indexToRemove);
            integerList.set(indexToRemove, valToSwap);
        }
        integerList.remove(integerList.size() - 1);
        return true;
    }

    public int getRandom() {
        int idx = rand.nextInt(integerList.size());
        return integerList.get(idx);
    }
}
