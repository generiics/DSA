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

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            return helper(root);
        }

        return root;
    }

    private TreeNode helper(TreeNode root) {

        if (root.left == null) return root.right;

        if (root.right == null) return root.left;

        
        TreeNode rightChild = root.right;
        TreeNode lastRight = findLastRight(root.left);

        lastRight.right = rightChild;

        return root.left;
    }

    private TreeNode findLastRight(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}