public class Q0021 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode left = list1;
        ListNode right = list2;
        ListNode res = new ListNode();
        ListNode curr = res;

        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = new ListNode(left.val);
                curr = curr.next;
                left = left.next;
            } else {
                curr.next = new ListNode(right.val);
                curr = curr.next;
                right = right.next;
            }
        }

        while (left != null) {
            curr.next = new ListNode(left.val);
            curr = curr.next;
            left = left.next;
        }

        while (right != null) {
            curr.next = new ListNode(right.val);
            curr = curr.next;
            right = right.next;
        }

        return res.next;
    }
}
