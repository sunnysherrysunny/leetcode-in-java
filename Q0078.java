import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 1) {
            res.add(new ArrayList<>());
            List<Integer> singleton = new ArrayList<>();
            singleton.add(nums[0]);
            res.add(singleton);
            return res;
        }

        List<List<Integer>> prev = subsets(Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> curr = new ArrayList<>();


        for (List<Integer> elem : prev) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[0]);
            for (int i : elem) {
                tmp.add(i);
            }
            curr.add(tmp);

        }
        curr.addAll(prev);
        return curr;
    }
}
