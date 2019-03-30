/**
 * @author Linh
 * @class solution to merge two sorted lists
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {

                if (l1.val <= l2.val) {
                    temp.next = new ListNode(l1.val);
                    temp = temp.next;
                    l1 = l1.next;
                } else {
                    temp.next = new ListNode(l2.val);
                    temp = temp.next;
                    l2 = l2.next;
                }
            } else {
                if (l1 == null) {
                    temp.next = l2;
                    break;
                }
                if (l2 == null) {
                    temp.next = l1;
                    break;
                }
            }
        }

        return head.next;
    }
}