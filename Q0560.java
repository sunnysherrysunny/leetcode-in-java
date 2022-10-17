import java.util.HashMap;

public class Q0560 {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        m.put(0, 1);
        int target;
        int sumSoFar = 0;
        int count = 0;
        for (int num : nums) {
            target = sumSoFar - (k - num);
            if (m.containsKey(target)) {
                count += m.get(target);
            }
            sumSoFar += num;
            int newFreq = 0;
            if (m.containsKey(sumSoFar)) {
                newFreq = m.get(sumSoFar);
            }
            m.put(sumSoFar, newFreq + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{0, 0, 0, 0, 0}, 0));
    }
}
