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
    
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[1];
    maxSum[0]= Integer.MIN_VALUE;

        findMaxPath(root, maxSum);
        return maxSum[0];
    }

    private int findMaxPath(TreeNode node, int[] maxSum) {
        if (node == null) return 0;

       
        int le= Math.max(0, findMaxPath(node.left, maxSum));
        int re= Math.max(0, findMaxPath(node.right, maxSum));

              
        maxSum[0]= Math.max(maxSum[0], le+re+node.val);
        

        return node.val+ Math.max(le, re);
    }
    
}



