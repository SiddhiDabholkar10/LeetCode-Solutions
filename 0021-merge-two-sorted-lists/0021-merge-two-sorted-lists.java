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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       ListNode t1 = list1;
       ListNode t2 = list2;

       //create a dummy node for new LL
       ListNode dNode = new ListNode(-1,null);
       ListNode temp = dNode;  //temp for updating the trail in the new LL (there is no new LL really!)
       while(t1!=null && t2!=null){  //while both the nodes on both the LL exist
        if(t1.val <= t2.val){   //compare
            temp.next = t1;    //whichever is smallest - connect to the trail of temp
            temp=t1;     //update temp because now its the node that was smallest and connected
            t1=t1.next;   //go to next node in that list to continue comparing
        }
        else{
            temp.next = t2;
            temp = t2;
            t2=t2.next;
        }
       }
       if(t1!=null){   //t2 finished, but t1 still exists
        temp.next = t1;     //already t1 is sorted, so we can just connect the rest of the higher noded to the temp trail
       }
       else{
        temp.next = t2;
       }
       return dNode.next;

       //dummy was -1, after that the list started building up, so we return dNode.next as the new head;
    }
}