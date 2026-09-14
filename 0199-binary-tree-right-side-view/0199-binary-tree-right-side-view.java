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
    public List<List<Integer>> levelOrderTraversal(TreeNode root){
        List<List<Integer>> levelAns = new ArrayList<>();
        Queue<TreeNode> todo = new LinkedList<>();
        todo.offer(root);
        while(!todo.isEmpty()){
            int size = todo.size();
            List<Integer> level = new ArrayList<>();
            
            for(int i=0;i<size;i++){
                TreeNode curr = todo.poll();
                level.add(curr.val);
                if(curr.left != null) todo.offer(curr.left);
                if(curr.right != null) todo.offer(curr.right);
            }
            levelAns.add(level);
            
            
        }
        return levelAns;
       

    }
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        List<List<Integer>> levels = levelOrderTraversal(root);
       
        for(List<Integer> level : levels){
            int size = level.size();
            ans.add(level.get(level.size()-1));
        }
        return ans;
    }
}