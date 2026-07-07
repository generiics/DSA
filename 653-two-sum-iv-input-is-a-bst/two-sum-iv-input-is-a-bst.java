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
import java.util.*;

class BSTIterator {

    Stack<TreeNode> st = new Stack<>();
    boolean reverse;

    public BSTIterator(TreeNode root, boolean reverse) {
        this.reverse = reverse;
        pushAll(root);
    }

    public void pushAll(TreeNode root) {

        while (root != null) {

            st.push(root);

            if (reverse)
                root = root.right;
            else
                root = root.left;
        }
    }

    public int next() {

        TreeNode temp = st.pop();

        if (reverse)
            pushAll(temp.left);
        else
            pushAll(temp.right);

        return temp.val;
    }
}

class Solution {

    public boolean findTarget(TreeNode root, int k) {

        if (root == null)
            return false;

        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int i = left.next();
        int j = right.next();

        while (i < j) {

            int sum = i + j;

            if (sum == k)
                return true;

            else if (sum < k)
                i = left.next();

            else
                j = right.next();
        }

        return false;
    }
}