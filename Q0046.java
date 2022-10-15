import java.util.ArrayList;
import java.util.List;

public class Q0046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int len = nums.length;
        ArrayList<Integer> rest = new ArrayList<>(len + 1);
        for (int i = 0; i < len; i++) {
            rest.add(nums[i]);
        }
        generate(rest, new ArrayList<Integer>(), res);
        return res;

    }

    public void generate(ArrayList<Integer> rest, ArrayList<Integer> curr, List<List<Integer>> res) {
        int len = rest.size();
        if (len == 0) {
            res.add(curr);
            return;
        }

        for (int i = 0; i < len; i++) {
            ArrayList<Integer> nextRest = new ArrayList<>(rest);
            ArrayList<Integer> nextCurr = new ArrayList<>(curr);
            nextCurr.add(nextRest.remove(i));
            generate(nextRest, nextCurr, res);
        }

    }
}
