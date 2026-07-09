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
    HashMap<Integer,Integer> map=new HashMap<>();
    List<Integer> list=new ArrayList<>();
    public int[] findMode(TreeNode root) {
        dfs(root);
        int maxFreq=0;

        for(int freq:map.values()){
            maxFreq=Math.max(maxFreq,freq);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == maxFreq) {
                list.add(key);
            } 
        }
        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
    
    return ans;
    }
    private void dfs(TreeNode root){
        if(root==null) return;
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        dfs(root.left);
        dfs(root.right);
    }
}