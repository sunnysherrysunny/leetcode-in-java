public class Q0098 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isBST(TreeNode root, long lo, long hi) {
        if (root == null) return true;
        if (root.val < lo || root.val > hi) return false;
        return isBST(root.left, lo, root.val - 1) && isBST(root.right, root.val + 1, hi);
    }
}
