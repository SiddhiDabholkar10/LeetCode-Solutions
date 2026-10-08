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
    public int countLeftHeight(TreeNode node){
        int lh = 0;
        while(node!=null){
            lh++;
            node = node.left;
        }
        return lh;
        
    }
    public int countRightHeight(TreeNode node){
        int rh = 0;
        while(node!=null){
            rh++;
            node = node.right;
        }
        return rh;
    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lh = countLeftHeight(root);
        int rh = countRightHeight(root);
        if (lh == rh) return (1 << lh) - 1;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}