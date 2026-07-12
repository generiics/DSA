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
    public int minimumOperations(TreeNode root) {
        
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int level=0;
        int ans=0;

        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> list=new ArrayList<>();

            while(size-->0){
                TreeNode curr=q.poll();
                list.add(curr.val);

                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
            ans+=minSwap(list);
            level++;
        }
        return ans;
    }
    public int minSwap(List<Integer>list){
         int n = list.size();
        ArrayList<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(list.get(i), i);
        }

        int swaps = 0;
        for (int i = 0; i < n; i++) {
           if (list.get(i).equals(sorted.get(i))) {
                continue;
            }

            swaps++;

            int correctValue = sorted.get(i);

            int index = map.get(correctValue);

    
            map.put(list.get(i), index);
            map.put(correctValue, i);
            Collections.swap(list, i, index);
        }

        return swaps;
    }
}