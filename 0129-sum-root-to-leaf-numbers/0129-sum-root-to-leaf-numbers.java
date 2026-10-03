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
    public void dfs(TreeNode node, String path, ArrayList<String> paths){
        if(node == null) return;
        path+=node.val;
        if((node.left == null) && (node.right==null)){
            paths.add(path);
            return;
        }
        dfs(node.left, path, paths);
        dfs(node.right, path, paths);
    }
    public int sumNumbers(TreeNode root) {
        String path = "";
        int result = 0;
        ArrayList<String> paths = new ArrayList<>();
        dfs(root, path, paths);
        for(String numStr: paths){
            result += Integer.parseInt(numStr);
        }
        return result;
    }
}