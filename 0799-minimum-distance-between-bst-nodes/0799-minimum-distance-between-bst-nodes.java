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
    private int minDiff = Integer.MAX_VALUE;
    private Integer prev= null;
    public int minDiffInBST(TreeNode root) {
        inorder (root);
        return minDiff;
    }
    private void inorder(TreeNode node){
        if(node== null){
            return;
        }
        inorder(node.left);

        // Process current node
        if (prev != null) {
            // Calculate difference with previous value and update minDiff if smaller
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;
        
        // Traverse right subtree
        inorder(node.right);
    }
}