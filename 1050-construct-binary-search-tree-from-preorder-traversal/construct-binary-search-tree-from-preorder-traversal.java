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
    public TreeNode bstFromPreorder(int[] preorder) 
    {
        ArrayList<TreeNode> arr = new ArrayList<>();
        TreeNode root;

        root.val= preorder[0];
        arr.add(root);//root added to the bst 

        int n= preorder.size;
        for(int i=0; i<n; i++)
        {


        }
        
    }
}*/
class Solution {
    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int min, int max) {
        if (index == preorder.length) return null;

        int val = preorder[index];
        if (val < min || val > max) return null;

        TreeNode root = new TreeNode(val);
        index++;

        // Left subtree: range = (min , val)
        root.left = build(preorder, min, val);

        // Right subtree: range = (val , max)
        root.right = build(preorder, val, max);

        return root;
    }
}
