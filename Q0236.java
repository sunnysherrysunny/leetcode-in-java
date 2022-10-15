public class Q0236 {

    public static boolean recur(TreeNode root, TreeNode p, TreeNode q, TreeNode[] res) {
        if (root == null) return false;
        boolean left = recur(root.left, p, q, res);
        boolean right = recur(root.right, p, q, res);
        if (((root.val == p.val || root.val == q.val) && (left || right))
                || (left && right)) {
            res[0] = root;
        }
        return (left || right);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] res = new TreeNode[1];
        recur(root, p, q, res);
        return res[0];
    }
}
