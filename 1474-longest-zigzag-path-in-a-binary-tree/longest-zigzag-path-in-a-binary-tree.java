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
    class Pair{
        int leftzig;
        int rightzig;
        Pair(int leftzig,int rightzig){
            this.leftzig=leftzig;
            this.rightzig=rightzig;
        }
    }
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return ans;
    }
    private Pair dfs(TreeNode root){
        if(root==null){
            return new Pair(-1, -1);
        }
        Pair left=dfs(root.left);
        Pair right=dfs(root.right);

       int leftzig=left.rightzig+1;
       int rightzig= right.leftzig+1;

       ans=Math.max(ans,Math.max(leftzig,rightzig));
       return new Pair(leftzig,rightzig);
    }
}