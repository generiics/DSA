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
    int ans=0;
    public int longestZigZag(TreeNode root) {
        dfs(root, true,0);
        return ans;
        
    }
    private void dfs(TreeNode root,boolean right,int steps){
        if(root==null){
            return;
        }
        ans=Math.max(ans,steps);
        if(right){
            dfs(root.right,false,steps+1);
            dfs(root.left,true,1);
        }else{
            dfs(root.left,true,steps+1);
            dfs(root.right,false,1);
        }

    }
}