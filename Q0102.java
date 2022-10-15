import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q0102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addFirst(root);
        generate(q, res);
        return res;
    }

    public void generate(LinkedList<TreeNode> q, List<List<Integer>> res) {
        if (q == null || q.size() == 0) return;

        LinkedList<TreeNode> nextQ = new LinkedList<>();
        ArrayList<Integer> currLevel = new ArrayList<>();

        while (q.size() > 0) {
            TreeNode curr = q.removeFirst();
            currLevel.add(curr.val);

            if (curr.left != null) {
                nextQ.addLast(curr.left);
            }
            if (curr.right != null) {
                nextQ.addLast(curr.right);
            }
        }
        res.add(currLevel);
        generate(nextQ, res);
    }
}
