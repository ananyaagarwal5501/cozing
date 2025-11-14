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
/*class Solution {
    public int maxPathSum(TreeNode root) 
    {
        int[] diameter = new int[1];
        height(root, diameter);
        int l=0;
        for(int i=0; i<diameter.length; i++)
        {
            l= l+ diameter[i];
        }
        return l;
    }

    public int height(TreeNode root, int[] diameter)
    {
        if(root== null)
        {
            return 0;
        }

        int lh= height(root.left, diameter);
        int rh= height(root.right, diameter);

        //need to take elements of nodes and add them to get the sum and chrck in each traversal of the value of sum; the size of the sum array should be equal to the diameter, at each step2
        //diameter[0] = Math.max(diameter[0], lh+rh);

        return 1+ Math.max(lh, rh);

    }
   
}
*/

class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMaxPath(root);
        return maxSum;
    }

    private int findMaxPath(TreeNode node) {
        if (node == null) return 0;

        // Recursively get max path sum of left & right subtrees
        int left = Math.max(0, findMaxPath(node.left));
        int right = Math.max(0, findMaxPath(node.right));

        // Current node’s best path (including both sides)
        int currentPath = node.val + left + right;

        // Update global maxSum if current path is better
        maxSum = Math.max(maxSum, currentPath);

        // Return max gain to parent (can only go through one side)
        return node.val + Math.max(left, right);
    }
}
