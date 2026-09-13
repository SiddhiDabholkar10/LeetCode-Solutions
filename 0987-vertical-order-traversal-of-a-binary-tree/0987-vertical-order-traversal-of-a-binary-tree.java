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
    static class NodeInfo{
        TreeNode node;
        int vertical;
        int level;
        NodeInfo(TreeNode n, int v, int l){
            node = n;
            vertical = v;
            level = l; 
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        //map: vertical -> level -> node_val
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> nodes = new TreeMap<>();
        //Queue for BFS traversal 
        Queue<NodeInfo> todo = new LinkedList<>();
        //add root to todo with coordinates
        todo.offer(new NodeInfo(root,0,0));
        while(!todo.isEmpty()){

            //take all info of the first entry in the queue
            NodeInfo n = todo.poll();
            TreeNode temp = n.node;
            int x = n.vertical;
            int y = n.level;

            //put this info in the map
            nodes.putIfAbsent(x,new TreeMap<>());  //creating structure for x
            nodes.get(x).putIfAbsent(y,new PriorityQueue<>()); //creating structure for why within x
            //now that x and y exist and are mapped -> put val of this node
            nodes.get(x).get(y).offer(temp.val);  
            //If left of curr node exist -> add it to queue for bfs
            if(temp.left!=null){
                todo.offer(new NodeInfo(temp.left,x-1,y+1));
            }

            //If right of curr node exist -> add it to queue for bfs
            if(temp.right!=null){
                todo.offer(new NodeInfo(temp.right,x+1,y+1));
            }
        }
        //Map "nodes" is created in the above code 
        //Next we will get answer from that map
        for(TreeMap<Integer,PriorityQueue<Integer>> ys: nodes.values()){
            List<Integer> col = new ArrayList<>();
            for(PriorityQueue<Integer> pq: ys.values()){
                while(!pq.isEmpty()){
                    col.add(pq.poll());
                }
            }
            ans.add(col);
        }

        return ans;

    }
}