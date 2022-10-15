import java.util.ArrayList;
import java.util.List;

public class Q0094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>(100);
        traverse(root, res);
        return res;
    }

    public void traverse(TreeNode root, List<Integer> res) {
        if (root == null) return;
        traverse(root.left, res);

        res.add(root.val);

        traverse(root.right, res);
    }
}