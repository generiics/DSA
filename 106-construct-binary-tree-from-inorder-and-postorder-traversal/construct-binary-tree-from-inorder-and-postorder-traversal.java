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

    public TreeNode solve(int[] inorder, int[] postorder, int start, int end, int[] idx) {

        if (start > end) {
            return null;
        }

        int rootVal = postorder[idx[0]--];   

        int i = start;
        for (; i <= end; i++) {
            if (inorder[i] == rootVal) {
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);

        
        root.right = solve(inorder, postorder, i + 1, end, idx);
        root.left = solve(inorder, postorder, start, i - 1, idx);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        int[] idx = {postorder.length - 1};  

        return solve(inorder, postorder, 0, inorder.length - 1, idx);
    }
}