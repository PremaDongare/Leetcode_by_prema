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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> s = new Stack<>();

        s.push(p);
        s.push(q);

        while(!s.isEmpty()){
            TreeNode node1 = s.pop();
            TreeNode node2 = s.pop();

            if(node1 == null && node2 == null){
                continue;
            }
            if(node1 == null || node2 == null){
                return false;
            }
            if (node1.val != node2.val){
                return false;
            }
            s.push(node1.left);
            s.push(node2.left);

            s.push(node1.right);
            s.push(node2.right);
        }
        return true;
    }
}