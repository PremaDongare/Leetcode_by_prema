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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Result list to store level-wise values
        List<List<Integer>> result = new ArrayList<>();
        
        // If root is null, return empty list
        if (root == null) {
            return result;
        }
        
        // Queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        // Process each level
        while (!queue.isEmpty()) {
            // Number of nodes in current level
            int levelSize = queue.size();
            // List to store current level's values
            List<Integer> currentLevel = new ArrayList<>();
            
            // Process all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                
                // Add left child to queue if exists
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // Add right child to queue if exists
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            // Add current level to result
            result.add(currentLevel);
        }
        
        return result;
    }
}