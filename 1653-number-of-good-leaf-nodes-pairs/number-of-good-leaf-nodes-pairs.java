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

    int ans = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return ans;
    }

    private List<Integer> dfs(TreeNode root, int distance) {

        List<Integer> curr = new ArrayList<>();

        if (root == null) {
            return curr;
        }
        if (root.left == null && root.right == null) {
            curr.add(1);
            return curr;
        }

        List<Integer> left = dfs(root.left, distance);
        List<Integer> right = dfs(root.right, distance);
        for (int l : left) {
            for (int r : right) {
                if (l + r <= distance) {
                    ans++;
                }
            }
        }
        for (int l : left) {
            if (l + 1 <= distance) {
                curr.add(l + 1);
            }
        }
        for (int r : right) {
            if (r + 1 <= distance) {
                curr.add(r + 1);
            }
        }
        return curr;
    }
}