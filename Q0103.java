import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Q0103 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addFirst(root);
        generate(q, res, true);
        return res;
    }

    public void generate(LinkedList<TreeNode> q, List<List<Integer>> res, boolean isLeft) {
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

        if (!isLeft) Collections.reverse(currLevel);
        res.add(currLevel);
        generate(nextQ, res, !isLeft);
    }
}
