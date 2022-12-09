public class Q0328 {

    public static void helper(ListNode head, ListNode tail,
                              ListNode originalTail) {
        if (head == originalTail) {
            return;
        }

        if (head.next == originalTail) {
            ListNode newTail = head.next;
            head.next = head.next.next;
            tail.next = newTail;
            newTail.next = null;
            return;
        }

        ListNode newTail = head.next;
        head.next = head.next.next;
        tail.next = newTail;
        newTail.next = null;
        helper(head.next, newTail, originalTail);

    }


    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        if (head == tail || head.next == tail) {
            return head;
        }
        helper(head, tail, tail);
        return head;
    }
}
