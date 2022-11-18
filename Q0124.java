public class Q0124 {


    public static int helper(TreeNode root, int[] res) {
        if (root == null) {
            res[0] = Integer.max(res[0], 0);
            return 0;
        }
        int leftSum = helper(root.left, res);
        int rightSum = helper(root.right, res);
        int curr = Integer.max(root.val, Integer.max(root.val + leftSum,
                Integer.max(root.val + rightSum,
                        root.val + leftSum + rightSum)));
        res[0] = Integer.max(res[0], curr);
        return Integer.max(root.val, Integer.max(root.val + leftSum,
                root.val + rightSum));
    }

    public static int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        helper(root, res);
        return res[0];
    }

}
