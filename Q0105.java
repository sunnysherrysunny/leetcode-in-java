import java.util.HashMap;

public class Q0105 {
    int preIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> indexes = new HashMap<>();
        preIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            indexes.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, preorder.length - 1, indexes);

    }

    public TreeNode build(int[] preorder, int[] inorder, int ordL, int ordR,
                          HashMap<Integer, Integer> indexes) {

        if (ordL > ordR)
            return null;


        int currRoot = preorder[preIndex];
        preIndex++;
        int ordIndex = indexes.get(currRoot);
        TreeNode res = new TreeNode(currRoot);
        res.left = build(preorder, inorder, ordL, ordIndex - 1, indexes);
        res.right = build(preorder, inorder, ordIndex + 1, ordR, indexes);
        return res;
    }
}

