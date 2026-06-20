/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int index=0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        preorder(root,sb);
        return sb.toString();
    }
    public void preorder(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");
        preorder(root.left,sb);
        preorder(root.right,sb);
    }

    
    public TreeNode deserialize(String data) {
        String[] arr=data.split(",");
        index=0;
        return build(arr);
    }
    public TreeNode build(String[] arr){
        if(index>=arr.length || arr[index].equals("N")){
            index++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(arr[index++]));
        root.left=build(arr);
        root.right=build(arr);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));