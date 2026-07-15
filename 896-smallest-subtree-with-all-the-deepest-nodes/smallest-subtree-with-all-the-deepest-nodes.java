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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        map.put(root,null);
        List<TreeNode> deep=new ArrayList<>();
        while(!q.isEmpty()){
            int size=q.size();
            deep=new ArrayList<>();
            while(size-->0){
                TreeNode curr=q.poll();
                deep.add(curr);

                if(curr.left!=null){
                    map.put(curr.left,curr);
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    map.put(curr.right,curr);
                    q.offer(curr.right);
                }
            }
        }
        while(deep.size()>1){
            HashSet<TreeNode>set=new HashSet<>();
            for(TreeNode node:deep){
                set.add(map.get(node));
            }
            deep=new ArrayList<>(set);
        }
        return deep.get(0);
        
    }
}