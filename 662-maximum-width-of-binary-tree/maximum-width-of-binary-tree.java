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
    class  Pair{
        TreeNode node;
        int idx;
    
    Pair(TreeNode node,int idx){
        this.node=node;
        this.idx=idx;
    }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int maxwidth=0;
        while(!q.isEmpty()) {
            int l=q.peek().idx;
            int r=((LinkedList<Pair>)q).peekLast().idx;
            maxwidth=Math.max(maxwidth,r-l+1);

            int n=q.size();
            while(n-->0){
                TreeNode curr=q.peek().node;
                int idx=q.peek().idx;
                q.poll();

                if(curr.left!=null){
                    q.add(new Pair(curr.left,2*idx+1));

                }
                if(curr.right!=null){
                    q.add(new Pair(curr.right,2*idx+2));
                }
            }
        }
        return maxwidth;
    }
}