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
    public ListNode reverseList(ListNode head) {
        //this is recursive approach:
       if(head == null || head.next == null){
        return head;
       }
       ListNode newHead = reverseList(head.next);
       ListNode front = head.next;

       front.next = head;
       head.next = null;
       return newHead;
    }


    /* 
    public ListNode iterativeApproach(ListNode head){
        // This is iterativeApproach
        ListNode prev = null;
        ListNode current = head;
        while(current != null){
            ListNode tempNext = current.next;
            current.next = prev;
            prev = current;
            current = tempNext;
        }
        head = prev;
        return head;
    }
    */
}