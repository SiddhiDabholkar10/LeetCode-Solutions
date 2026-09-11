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
    public int diameterOfBinaryTree(TreeNode root) {
        //in java variables can't be passed via reference
        if(root==null) return 0;
        int[] diameter = new int[1];
        diameter[0] = 0;
        maxDist(root,diameter);
        return diameter[0];
    }
    public int maxDist(TreeNode root, int[] diameter){
        if(root==null) return 0;
        int lh = maxDist(root.left,diameter);
        int rh= maxDist(root.right, diameter);
        diameter[0] = Math.max(diameter[0],lh+rh);
        return  1+ Math.max(lh,rh);
        
    }
}