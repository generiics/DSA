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
    int n;
    public TreeNode solve(String s,int[] i,int depth){
        if(i[0]>=n){
            return null;
        }
        int j=i[0];
        while(j<n && s.charAt(j)=='-'){
            j++;
        }
        int dash=j-i[0];
        if(dash!=depth){
            return null;
        }
        i[0]+=dash;
        int value=0;
         while (j < n && Character.isDigit(s.charAt(j))) {
            value = value * 10 + (s.charAt(j) - '0');
            j++;
            i[0]++;
        }
        TreeNode root=new TreeNode(value);
        root.left=solve(s,i,depth+1);
        root.right=solve(s,i,depth+1);
        return root;

    }
    public TreeNode recoverFromPreorder(String traversal) {
        n=traversal.length();
        int[] i={0};
        int depth=0;
        return solve(traversal,i,depth);
    }
}