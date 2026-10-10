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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inorder_indexmap  = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inorder_indexmap.put(inorder[i],i);
        }
        TreeNode root = buildTreeHelper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,inorder_indexmap);
        return root;
    }
    public TreeNode buildTreeHelper(int[] preorder,int preStart, int preEnd, int[] inorder,int inStart, int inEnd, Map<Integer,Integer> inorder_indexmap){
        if(preStart>preEnd || inStart>inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRootIndex = inorder_indexmap.get(root.val);
        int nodesOnLeftOfRoot = inRootIndex-inStart;
        root.left = buildTreeHelper(preorder,preStart+1,preStart+nodesOnLeftOfRoot,inorder, inStart ,inRootIndex-1,inorder_indexmap);
        root.right = buildTreeHelper(preorder,preStart+nodesOnLeftOfRoot+1,preEnd,inorder,inRootIndex+1,inEnd,inorder_indexmap);
        return root;

    }
}