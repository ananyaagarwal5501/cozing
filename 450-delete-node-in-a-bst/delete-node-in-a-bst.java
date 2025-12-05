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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            // Key is in the left subtree
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            // Key is in the right subtree
            root.right = deleteNode(root.right, key);
        } else {
            // Found the node to delete

            // Case 1: no left child
            if (root.left == null) {
                return root.right;
            }
            // Case 2: no right child
            else if (root.right == null) {
                return root.left;
            }

            // Case 3: two children
            // Find inorder successor (smallest in right subtree)
            TreeNode successor = findMin(root.right);

            // Copy successor's value into this node
            root.val = successor.val;

            // Delete the successor node from right subtree
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    private TreeNode findMin(TreeNode node) {
        // In BST, min is always the left-most node
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
