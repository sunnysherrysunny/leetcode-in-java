import java.util.ArrayList;
import java.util.List;

public class Q0095 {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }


    public List<TreeNode> generate(int start, int end) {

        List<TreeNode> res = new ArrayList<>();
        List<TreeNode> left, right;
        int ls, rs;
        TreeNode currLeft;

        if (start > end) {
            res.add(null);
            return res;
        }
        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }

        for (int root = start; root <= end; root++) {
            left = generate(start, root - 1);
            right = generate(root + 1, end);
            ls = left.size();
            rs = right.size();
            for (int l = 0; l < ls; l++) {
                currLeft = left.get(l);
                for (int r = 0; r < rs; r++) {
                    res.add(new TreeNode(root, currLeft, right.get(r)));
                }
            }
        }

        return res;

    }
}
