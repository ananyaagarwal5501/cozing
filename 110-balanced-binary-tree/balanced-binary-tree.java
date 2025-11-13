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
    public boolean isBalanced(TreeNode root) 
    {
        return height(root) != -1;
    }

    public int height(TreeNode root)
    {
        //hl-rl <=1

        if(root == null)
        {
            return 0;
        }

        int hl= height(root.left);
        if(hl== -1)
        {
            return -1;
        }

        int rh= height(root.right);
        if(rh == -1)
        {
            return -1;
        }

        if(Math.abs(hl- rh) > 1)
        {
            return -1;
        }

        return 1+ Math.max(hl, rh);
        
    }
}