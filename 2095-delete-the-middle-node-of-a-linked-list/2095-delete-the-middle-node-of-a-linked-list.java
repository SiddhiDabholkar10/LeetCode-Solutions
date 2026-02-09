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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null) return head;
        if(head.next == null){
            head = null;
            return head;
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

        }
        if(fast.next != null){
            //even length;
            slow.next = slow.next.next;
        }
        else{
            prev.next = slow.next;
        }
        return head;
    }
}