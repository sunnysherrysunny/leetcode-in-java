public class Q0024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode virtualHead = new ListNode(0, head);

        ListNode curr = virtualHead;
        while (curr.next != null && curr.next.next != null) {
            curr.next = swap(curr.next, curr.next.next);
            curr = curr.next.next;
        }
        return virtualHead.next;
    }

    public ListNode swap(ListNode l1, ListNode l2) {
        ListNode tmp = l2.next;
        l2.next = l1;
        l1.next = tmp;
        return l2;
    }
}