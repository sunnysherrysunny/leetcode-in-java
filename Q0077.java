import java.util.ArrayList;
import java.util.List;

public class Q0077 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        create(1, n, k, new ArrayList<Integer>(), res);
        return res;

    }

    public void create(int start, int end, int left, List<Integer> curr, List<List<Integer>> res) {

        if (left == 0) {
            res.add(curr);
            //System.out.println(curr);
            return;
        }

        if (start > end || end - start + 1 < left) {
            return;
        }

        List<Integer> newCurr = new ArrayList<>(curr);
        curr.add(start);
        create(start + 1, end, left - 1, curr, res);
        create(start + 1, end, left, newCurr, res);

    }
}
