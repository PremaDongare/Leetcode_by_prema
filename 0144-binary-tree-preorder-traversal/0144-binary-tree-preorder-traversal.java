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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result= new ArrayList<>();
        preorder(root, result);
        return result;
        
    }
    private void preorder(TreeNode node, List<Integer> result){

        if(node == null){
            return;
        }
        //root
        result.add(node.val);
        //left
        preorder(node.left, result);
        //right
        preorder(node.right, result);
    }
}