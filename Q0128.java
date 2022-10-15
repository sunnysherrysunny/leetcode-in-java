import java.util.HashSet;
import java.util.Set;

public class Q0128 {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int curr;
        int currCount = 1;
        int bestCount = 1;

        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                curr = num + 1;
                currCount = 1;
                while (numSet.contains(curr)) {
                    currCount++;
                    curr++;
                }
                bestCount = Math.max(currCount, bestCount);
            }
        }

        return bestCount;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }
}
