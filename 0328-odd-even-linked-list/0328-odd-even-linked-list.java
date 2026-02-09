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


 //Odd Indexed nodes should be before even indexed nodes.
class Solution {
    public ListNode oddEvenList(ListNode head) {

        //empty or single node linked list
        if(head == null || head.next == null){
            return head;
        }
    
        ListNode even_head = null;
        ListNode odd_head = null;
        ListNode even_tail = null;
        ListNode odd_tail = null;
        ListNode current = head;
        int length = 1;
        while(current!= null){
            
            if(length % 2  == 0){
                if(even_head == null ){
                    even_head = current;
                    even_tail = current;
                }
                else{
                    even_tail.next = current;
                    even_tail = current;
                }
            }
            else{
                if(odd_head == null){
                    odd_head = current;
                    odd_tail = current;
                }
                else{
                    odd_tail.next = current;
                    odd_tail = current;
                }
                
            }
            current = current.next;
            length ++;
        }
        
        // If no even nodes found, return odd list
        if (even_head == null) return odd_head;

        // If no odd nodes found, return even list
        if (odd_head == null) return even_head;


        
        // Odd indexed nodes -> even indexed nodes
        odd_tail.next = even_head;
        even_tail.next = null;
        return odd_head;
        

        
    }
}