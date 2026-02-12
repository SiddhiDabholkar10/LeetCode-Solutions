/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //if any one list is null, they dont have a common point, so we return null
        if(headA==null || headB==null){
            return headA;
        }

        //traversal pointers
        ListNode t1 = headA;
        ListNode t2 = headB;
        while(t1!=t2){     //if t1=t2 at first itself, we return t1  otherwise we traverse;
            t1=t1.next;
            t2=t2.next;

            //if t1=t2 at anypoint / or if they both reach null at same time  we return the common point ; which is null because they never connected 
            if(t1==t2){
                return t1;
            }

            //if first list reached end; send it to head of opposite list; to catch up on the distance (ALIGN)
            if(t1==null){
                t1=headB;
            }

            //if second list reached end;send it to head of opposite list; to catch up on the distance (ALIGN)
            if(t2==null){
                t2=headA;
            }

        }
        return t1;
    }
}