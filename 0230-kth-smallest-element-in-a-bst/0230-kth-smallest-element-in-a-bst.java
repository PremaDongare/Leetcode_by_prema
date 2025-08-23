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
    public int kthSmallest(TreeNode root, int k) {
       if(root == null) return -1; 

       Queue<TreeNode> q= new LinkedList<>();
       List<Integer> values = new ArrayList<>();
       q.add(root);

       while(!q.isEmpty()){
        TreeNode Node = q.poll();
        values.add(Node.val);

        if(Node.left!=null) q.add(Node.left);
        if(Node.right!=null) q.add(Node.right);
       }

       Collections.sort(values);
       return values.get(k-1);

    }

}