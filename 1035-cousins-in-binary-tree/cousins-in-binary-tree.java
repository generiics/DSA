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

    TreeNode parentX = null;
    TreeNode parentY = null;

    int depthX = -1;
    int depthY = -1;

    public boolean isCousins(TreeNode root, int x, int y) {

        dfs(root, null, 0, x, y);

        return depthX == depthY && parentX != parentY;
    }

    private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y) {

        if (root == null)
            return;

        if (root.val == x) {
            parentX = parent;
            depthX = depth;
        }

        if (root.val == y) {
            parentY = parent;
            depthY = depth;
        }

        dfs(root.left, root, depth + 1, x, y);
        dfs(root.right, root, depth + 1, x, y);
    }
}