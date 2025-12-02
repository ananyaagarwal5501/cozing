//FOR BST: WE KNOW ITS PROPERTY THAT ALL TH ELEFT NODES OF THE ROOT ARE SMALLER THAN IT AND ALL THE RIGHT NODES ARE BIGGER THAN THE ROOT'S VALUE. 
//ALSO, WKT, FOR THE 2 NODES: 3 COND'S
                            // 1. EITHER BOTH ON LEFT OF ROOT- root goes left
                            // 2. EITHER BOTH ON RIGHT OF ROOT- root goes right
                            // 3. THE NODE FROM WHERE ONE LIES ON LEFT AND THE OTHER ON RIGHT- THE LCA

 class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(root.val> p.val && root.val> q.val)
        {
            return lowestCommonAncestor(root.left, p, q);
        }

        if(root.val< p.val && root.val< q.val)
        {
            return lowestCommonAncestor(root.right, p, q);
        }

          return root;
      
    }   
 }                                       











//follows the BT approach, takes complexity of o(n)

 /*class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(root== null || p == root || q == root)
        {
            return root;
        }      

        TreeNode left = lowestCommonAncestor( root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p ,q);

        if(left == null)
        {
            return right;
        } 

        if(right == null)
        {
            return left;
        }

        else
        {
            return root;
        }
    }
}*/