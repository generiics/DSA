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
    public int maxAncestorDiff(TreeNode root) {
        solve(root,root.val,root.val);
        return ans; 
    }
    public void solve(TreeNode root,int min,int max){
        if (root==null) return;
        min=Math.min(min,root.val);
        max=Math.max(max,root.val);
        ans=Math.max(ans,max-min);
        solve(root.left,min,max);
        solve(root.right,min,max);
    }
}