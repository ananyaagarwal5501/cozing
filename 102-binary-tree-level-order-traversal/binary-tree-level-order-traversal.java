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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {

        ArrayList<List<Integer>> arr= new ArrayList<>(); 
        Queue<TreeNode> queue= new LinkedList<>();
        List<Integer> ar= new ArrayList<>();
        TreeNode node= null;

        if(root == null)
        {
            return arr;
        }

        queue.add(root);
        while(!queue.isEmpty())
        {
        int size= queue.size(); // number of nodes in that level

        for(int i=0; i<size; i++) // processing for each node on the same level
        {
            node= queue.poll();
            ar.add(node.val);
        

        if(node.left!= null) // next level ka queue ready
        {
        queue.add(node.left);
        }

        if(node.right!= null)
        {
        queue.add(node.right);
        }
        }

        arr.add(new ArrayList<>(ar)); //final arraylist update
        ar.clear(); // clear ar for each level
        }

        return arr;
        
        
    }
}