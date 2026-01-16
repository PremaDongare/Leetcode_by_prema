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
        if(root == null) return null;
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else if(key >root.val){
            root.right= deleteNode(root.right, key);
        }
           else{
            // case with no left child
            if(root.left == null)
            return root.right;

            // case with no right child
            if(root.right == null)
            return root.left;

            //more  then two child
            TreeNode rightsucc= findMin(root.right);
            root.val = rightsucc.val;
            root.right= deleteNode(root.right, rightsucc.val);
           }
           return root;
    }
    //function to find min val
    private TreeNode findMin(TreeNode node){
        while(node.left != null)
        node = node.left;
        return node;
    }
}