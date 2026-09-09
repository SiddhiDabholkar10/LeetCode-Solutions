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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ansList = new ArrayList<>();
        if(root == null) return ansList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i=0;i<size;i++){
                if(queue.peek().left != null) queue.add(queue.peek().left);
                if(queue.peek().right !=null) queue.add(queue.peek().right);
                levelList.add(queue.poll().val);
            }
            ansList.add(levelList);
        }
        return ansList;
    }
}