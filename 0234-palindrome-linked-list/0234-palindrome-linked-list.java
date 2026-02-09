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
        if(head==null || head.next==null){
            return head;
        }
        ListNode prev = null;
        ListNode temp = head;
       
        while(temp!=null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
         if (head == null || head.next == null) {
            return true;  // It's a palindrome by definition
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second_half = reverseList(slow.next);
        ListNode first_half = head;
        while(second_half!=null){
            if(first_half.val != second_half.val){
                return false;
            }
            first_half = first_half.next;
            second_half = second_half.next;

        }
        return true;
    }
}

/*
Approach:

1) Use the slow and fast pointer technique to find the middle of the linked list.

2) Reverse the second half of the list starting from the node after the middle.

3) Compare nodes from the first half and the reversed second half; if all values match, the list is a palindrome.
 */