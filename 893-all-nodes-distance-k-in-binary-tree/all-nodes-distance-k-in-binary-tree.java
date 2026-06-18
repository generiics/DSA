/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        buildParent(root, null);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int dist = 0;

        while (!q.isEmpty()) {

            if (dist == k) break;

            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();

                if (curr.left != null && !visited.contains(curr.left)) {
                    q.offer(curr.left);
                    visited.add(curr.left);
                }

                if (curr.right != null && !visited.contains(curr.right)) {
                    q.offer(curr.right);
                    visited.add(curr.right);
                }

                TreeNode par = parent.get(curr);
                if (par != null && !visited.contains(par)) {
                    q.offer(par);
                    visited.add(par);
                }
            }

            dist++;
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }

        return ans;
    }

    private void buildParent(TreeNode node, TreeNode par) {
        if (node == null) return;

        parent.put(node, par);

        buildParent(node.left, node);
        buildParent(node.right, node);
        
    }
}