import java.util.ArrayList;
import java.util.List;

public class Q0039 {


    public static void backtrack(int[] candidates, int target, List<Integer> possibleRes, List<List<Integer>> finalResult, int start) {
        if (target == 0) {
            finalResult.add(new ArrayList<>(possibleRes));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int curr = candidates[i];
            if (curr <= target) {
                possibleRes.add(curr);
                backtrack(candidates, target - curr, possibleRes, finalResult, i);
                possibleRes.remove(possibleRes.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        //candidates = Arrays.stream(candidates).sorted().toArray();
        List<List<Integer>> finalResult = new ArrayList<>();
        backtrack(candidates, target, new ArrayList<>(), finalResult, 0);
        return finalResult;
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{8, 4, 7, 3};
        int target = 11;
        List<List<Integer>> combinationSum = combinationSum(candidates, target);
        System.out.println(combinationSum);
    }
}
