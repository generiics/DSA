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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newR=new TreeNode(val);
            newR.left=root;
            return newR;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int level=1;

        while(!q.isEmpty()){
            int size=q.size();
            

            if(level==depth-1){
                while(size-->0){
                TreeNode curr =q.poll();

                TreeNode oldleft=curr.left;
                TreeNode oldright=curr.right;
                curr.left=new TreeNode(val);
                curr.right=new TreeNode(val);
                curr.left.left=oldleft;
                curr.right.right=oldright;
                }
                return root;
            }
            while(size-->0){
                TreeNode curr=q.poll();

                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
                level++;
            }
            return root;
        }
    }
