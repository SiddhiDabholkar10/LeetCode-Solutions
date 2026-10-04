/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
     public static boolean hasPath(TreeNode root, ArrayList<Integer> arr, int x) 
    { 
       
        if (root==null) 
            return false; 
      
        // push the node's value in 'arr' 
        arr.add(root.val);     
      
       
        if (root.val == x)     
            return true; 
      
        
        if (hasPath(root.left, arr, x) || 
            hasPath(root.right, arr, x)) 
            return true; 
      
        
        arr.remove(arr.size()-1); 
        return false;             
    } 

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();
        hasPath(root, path1, p.val);
        hasPath(root, path2, q.val);
        Integer lca = null;

        for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if (path1.get(i).equals(path2.get(i))) {
                lca = path1.get(i);
            } else {
                break;
            }
        }

        TreeNode lca_node = new TreeNode(lca);
        return lca_node;
    }
}