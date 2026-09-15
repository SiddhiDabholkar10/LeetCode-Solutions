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
    public boolean isSymHelper(TreeNode root1, TreeNode root2){
        if (root1 == null || root2 == null) {
            // If one subtree is null, the other
            // must also be null for symmetry
            return root1 == root2;
        }
        return (root1.val == root2.val && isSymHelper(root1.left,root2.right) && isSymHelper(root1.right, root2.left));
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymHelper(root.left,root.right);
    }
}