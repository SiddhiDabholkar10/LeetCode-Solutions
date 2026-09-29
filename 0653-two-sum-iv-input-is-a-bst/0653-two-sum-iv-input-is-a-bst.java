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
class BSTIterator{
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    boolean reverse = true;
    public BSTIterator(TreeNode root, boolean isReverse){
        reverse = isReverse;
        pushAll(root);
    }
    public boolean hasNext(){
        return !stack.isEmpty();
    }
    public int next(){
        TreeNode tempNode = stack.pop();
        if (reverse) pushAll(tempNode.left);  // Reverse inorder: after root, explore left subtree         
        else pushAll(tempNode.right);  // Normal inorder: after root, explore right subtree
        return tempNode.val;
    }
    public void pushAll(TreeNode node){
        while(node!=null){
            stack.push(node);
            if(reverse) node = node.right;   //push all rights - because its reverse
            else node = node.left;
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        BSTIterator l = new BSTIterator(root,false);  //on left end
        BSTIterator r = new BSTIterator(root,true);   //on right end

        int i = l.next();
        int j = r.next();
        while(i<j){
            if(i+j==k) return true;
            else if(i+j<k) i=l.next();
            else j=r.next();
        }
        return false;

    }
}