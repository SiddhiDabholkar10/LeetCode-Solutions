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
    public TreeNode markParents_getTarget(TreeNode root, Map<TreeNode,TreeNode> parent_track, int start){
        TreeNode target = null;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr.val == start) target = curr;
            if(curr.left!=null){
                parent_track.put(curr.left,curr);
                queue.offer(curr.left);
            }
            if(curr.right!=null){
                parent_track.put(curr.right,curr);
                queue.offer(curr.right);
            }
        }
        return target;
    }
    public int amountOfTime(TreeNode root, int start) {
        if(root == null) return 0;
        
        Map<TreeNode,TreeNode> parent_track  = new HashMap<>();
        TreeNode target =  markParents_getTarget(root,parent_track, start);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int burn = 0;
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left!=null && !visited.contains(node.left)){
                    burn = 1;
                    queue.offer(node.left);
                    visited.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)){
                    burn = 1;
                    queue.offer(node.right);
                    visited.add(node.right);
                }
                if(parent_track.get(node)!=null && !visited.contains(parent_track.get(node))){
                    burn = 1;
                    queue.offer(parent_track.get(node));
                    visited.add(parent_track.get(node));
                }
            }
            if(burn == 1) time++;
        }
        return time;

    }
}