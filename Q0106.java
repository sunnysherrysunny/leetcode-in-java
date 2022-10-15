import java.util.HashMap;

public class Q0106 {
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> indexes = new HashMap<>();
        postIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            indexes.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1, indexes);

    }


    public TreeNode build(int[] preorder, int ordL, int ordR,
                          HashMap<Integer, Integer> indexes) {

        if (ordL > ordR)
            return null;

        int currRoot = preorder[postIndex];
        postIndex--;
        int ordIndex = indexes.get(currRoot);
        TreeNode res = new TreeNode(currRoot);
        res.right = build(preorder, ordIndex + 1, ordR, indexes);
        res.left = build(preorder, ordL, ordIndex - 1, indexes);
        return res;
    }
}
