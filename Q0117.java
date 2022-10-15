import java.util.LinkedList;


public class Q0117 {
    public Node connect(Node root) {
        if (root == null)
            return root;

        LinkedList<Node> q = new LinkedList<>();
        q.addFirst(root);
        generate(q);
        return root;
    }

    public void generate(LinkedList<Node> q) {
        if (q == null || q.size() == 0)
            return;

        LinkedList<Node> nextQ = new LinkedList<>();

        Node prev = q.removeFirst();
        if (prev.left != null) {
            nextQ.addLast(prev.left);
        }
        if (prev.right != null) {
            nextQ.addLast(prev.right);
        }

        while (q.size() > 0) {
            Node curr = q.removeFirst();
            prev.next = curr;
            prev = curr;

            if (curr.left != null) {
                nextQ.addLast(curr.left);
            }
            if (curr.right != null) {
                nextQ.addLast(curr.right);
            }
        }

        generate(nextQ);
    }
}
