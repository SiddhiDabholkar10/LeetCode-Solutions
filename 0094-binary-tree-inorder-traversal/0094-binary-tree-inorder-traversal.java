/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left==null){   //left is null
                inorder.add(curr.val);
                curr = curr.right;
            }
            else{  //left exist; go to the last guy 
                TreeNode last = curr.left;
                while(last.right!=null && last.right!=curr){
                    last = last.right;
                }
                if(last.right == null){
                    last.right = curr;
                    curr = curr.left;
                }
                //already thread exist
                else if(last.right == curr){
                    inorder.add(curr.val);
                    last.right = null;
                    curr = curr.right;
                }
            }
        }
        return  inorder;
    }
}
 