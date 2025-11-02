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
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        ArrayList<Integer> result= new ArrayList<>();
        if(root== null) //base case
        {
            return result;
        }
       
        //2. left subtree
        result.addAll(inorderTraversal(root.left));

         //1. add the val of root
        result.add(root.val);


        //3. right subtree
        result.addAll(inorderTraversal(root.right));
        
        return result;
        
    }
}