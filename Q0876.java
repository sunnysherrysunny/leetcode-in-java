public class Q0876 {

    public ListNode findMiddle(ListNode head, ListNode currMiddle, boolean move) {
        if (head == null) {
            return currMiddle;
        }
        if (move) {
            return findMiddle(head.next, currMiddle.next, false);
        } else {
            return findMiddle(head.next, currMiddle, true);
        }
    }

    public ListNode middleNode(ListNode head) {
        return findMiddle(head, head, true);
    }
}
