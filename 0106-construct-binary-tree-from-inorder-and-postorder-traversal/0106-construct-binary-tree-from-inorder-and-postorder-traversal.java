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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         Map<Integer,Integer> inorder_indexmap  = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inorder_indexmap.put(inorder[i],i);
        }
        TreeNode root = buildTreeHelper(postorder,postorder.length-1,0,inorder,0,inorder.length-1,inorder_indexmap);
        return root;
    }
    public TreeNode buildTreeHelper(int[] postorder,int postStart, int postEnd, int[] inorder,int inStart, int inEnd, Map<Integer,Integer> inorder_indexmap){
        if(postStart<postEnd || inStart>inEnd) return null;
        TreeNode root = new TreeNode(postorder[postStart]);
        int inRootIndex = inorder_indexmap.get(root.val);
        int nodesOnLeftOfRoot = inRootIndex-inStart;
        root.left = buildTreeHelper(postorder,postEnd+nodesOnLeftOfRoot-1, postEnd ,inorder, inStart ,inRootIndex-1,inorder_indexmap);
        root.right = buildTreeHelper(postorder,postStart-1,postEnd+nodesOnLeftOfRoot,inorder,inRootIndex+1,inEnd,inorder_indexmap);
        return root;

    }
}