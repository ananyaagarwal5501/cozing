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
    public boolean findTarget(TreeNode root, int k) 
    {
        if(root == null)  return false;
        BTSIterator l= new BTSIterator( root, false); //initialised the next iterator
        BTSIterator r= new BTSIterator( root, true); //initialised the before iterator

        int i= l.next();
        int j= r.next();

        while(i<j)
        {
            if(i+j == k) return true;

            if(i+j < k) i= l.next();
            else
            {
                j= r.next();
            }
        }
        return false;
        
    }
}

public class BTSIterator
{
    Stack<TreeNode> stack= new Stack<>();
    boolean reverse= true;

    public BTSIterator(TreeNode root, boolean reverse)
    {
        this.reverse= reverse;
        pushAll(root);
    }

    public void pushAll(TreeNode node)
    {
        while( node != null)
        {
         stack.push(node); 
         if(reverse) node= node.right;
         else
         {
            node= node.left;
         }                       
        }
    }

    public boolean hasNext(TreeNode root)
    {
        return (!stack.isEmpty());
    }

    public int next()
    {
        TreeNode tmpNode= stack.pop();

        if(reverse) pushAll(tmpNode.left);  //for before one
        else
        {
        pushAll(tmpNode.right); //for next one
        }
        return tmpNode.val;  
    }
}

 /*
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
*/