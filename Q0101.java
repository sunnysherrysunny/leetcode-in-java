public class Q0101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return isEqual(root.left, root.right);

    }

    public boolean isEqual(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;

        if (left == null && right != null)
            return false;

        if (right == null && left != null)
            return false;

        return (left.val == right.val) && isEqual(left.left, right.right) &&
                isEqual(left.right, right.left);
    }
}
