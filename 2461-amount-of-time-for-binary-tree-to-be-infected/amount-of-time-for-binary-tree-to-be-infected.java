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
    HashMap<TreeNode ,TreeNode> parent=new HashMap<>();
    TreeNode StartNode;
    public int amountOfTime(TreeNode root, int start) {
        build(root,null,start);
        return bfs(StartNode);   
    }
    public void build(TreeNode node,TreeNode par,int start){
        if(node==null){
            return;
        }
        parent.put(node,par);
        if(node.val==start){
            StartNode=node;
        }
        build(node.left,node,start);
        build(node.right,node,start);
    }
     private int bfs(TreeNode start) {

        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> vis = new HashSet<>();

        q.add(start);
        vis.add(start);

        int time = -1;

        while (!q.isEmpty()) {

            int size = q.size();
            time++;

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();

                
                if (curr.left != null && !vis.contains(curr.left)) {
                    vis.add(curr.left);
                    q.add(curr.left);
                }

        
                if (curr.right != null && !vis.contains(curr.right)) {
                    vis.add(curr.right);
                    q.add(curr.right);
                }

                
                TreeNode par = parent.get(curr);
                if (par != null && !vis.contains(par)) {
                    vis.add(par);
                    q.add(par);
                }
            }
        }

        return time;
    }
}