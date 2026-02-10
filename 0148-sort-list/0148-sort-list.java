/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

         
        ListNode slow = head;
        ListNode fast = head.next;   //minor change in tortoise hair algo to get to manage both even and odd list.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode mergeSortedList(ListNode head1, ListNode head2) {
        ListNode t1 = head1;
        ListNode t2 = head2;
        ListNode dNode = new ListNode(-1, null);
        ListNode temp = dNode;
        while (t1 != null && t2 != null) {
            if (t1.val <= t2.val) {
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            } else {
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }
        if (t1 != null) {
            temp.next = t1;
        } else {
            temp.next = t2;
        }
        return dNode.next;
    }

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode leftHead = head;
        ListNode middle = findMiddle(head);
        ListNode rightHead = middle.next;
        middle.next = null;
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        head = mergeSortedList(leftHead, rightHead);
        return head;

    }
}