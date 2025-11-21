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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode a, TreeNode b) {
        // both null → symmetric
        if (a == null && b == null) return true;

        // one null → not symmetric
        if (a == null || b == null) return false;

        // values must match AND children must mirror
        return (a.val == b.val) 
            && isMirror(a.left, b.right)
            && isMirror(a.right, b.left);
    }
}

 /*
class Solution {
    public boolean isSymmetric(TreeNode root) 
    {
        
        if(root.left.val == root.right.val) return true;
        if(root.left == null && root.right != null) return false;
        if(root.left != null && root.right == null) return false;
        if(root.left.right.val != root.right.left.val) return false;
        if(root.left.left.val != root.right.right.val) return false;

        return isSymmetric(root.left) && isSymmetric(root.right);
        
    }
}*/