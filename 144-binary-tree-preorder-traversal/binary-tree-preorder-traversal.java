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
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        ArrayList<Integer> result= new ArrayList<>();
        if(root== null) //base case
        {
            return result;
        }
        //1. add the val of root
        result.add(root.val);

        //2. left subtree
        result.addAll(preorderTraversal(root.left));

        //3. right subtree
        result.addAll(preorderTraversal(root.right));
        
        return result;
        
    }
}
*/

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) 
    {
        ArrayList<Integer> result= new ArrayList<>();

        if(root== null) //base case
        {
            return result;
        }

        Stack<TreeNode> st= new Stack<>();
        st.push(root);

        while(!st.isEmpty())
        {
            TreeNode current= st.pop();
            result.add(current.val);

            if(current.right != null)
            {
                st.push(current.right);
            }

            if(current.left != null)
            {
                st.push(current.left);
            }
        }
       return result ;
    }
}


        