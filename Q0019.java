public class Q0019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        boolean isTargetCreated = false;
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode target = dummyHead;
        ListNode curr = dummyHead;
        int counter = 0;
        while (curr != null) {
            if (isTargetCreated) {
                curr = curr.next;
                target = target.next;
            } else {
                if (counter == n) {
                    isTargetCreated = true;
                }
                curr = curr.next;
                counter++;
            }

        }
        target.next = target.next.next;
        return dummyHead.next;
    }
}
