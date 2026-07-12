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
    public TreeNode createBinaryTree(int[][] descriptions) {
       HashMap<Integer,TreeNode> map=new HashMap<>();
       HashSet<Integer> childSet=new HashSet<>(); 

       for(int temp[]:descriptions){
        int parent=temp[0];
        int child=temp[1];
        int left=temp[2];
       
       if(!map.containsKey(parent)){
        map.put(parent,new TreeNode(parent));
       }
       if(!map.containsKey(child)){
        map.put(child,new TreeNode(child));
       }
       
       TreeNode parentNode = map.get(parent);
       TreeNode childNode = map.get(child);
       if(left==1){
        parentNode.left=childNode;
       }else{
        parentNode.right=childNode;
       }

       childSet.add(child);
    }
       for(int node : map.keySet()) {
            if (!childSet.contains(node)) {
                return map.get(node);
            }
        }
    return null;
}
}