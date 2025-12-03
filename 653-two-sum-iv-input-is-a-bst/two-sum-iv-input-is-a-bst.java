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
 /*
class Solution {
    public boolean findTarget(TreeNode root, int k) 
    {
        Stack<TreeNode> stack= new Stack<>();

        //next() BSTIterator
        public findTarget(TreeNode root, int k)
        {

        }
        //before() BSTIterator

        //add both to see if we get the key

        
    }
}

*/
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

    private boolean dfs(TreeNode node, int k, HashSet<Integer> set) {
        if (node == null) return false;

        // if there exists some value = k - node.val, we are done
        if (set.contains(k - node.val)) {
            return true;
        }

        // otherwise remember this value
        set.add(node.val);

        // search left or right; if any returns true, bubble it up
        return dfs(node.left, k, set) || dfs(node.right, k, set);
    }
}
