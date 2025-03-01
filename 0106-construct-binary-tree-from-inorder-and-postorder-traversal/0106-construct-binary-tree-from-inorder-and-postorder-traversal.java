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
    private int postIdx;
    private Map<Integer, Integer> inorderMap;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Initialize postIdx to the last element in postorder array
        postIdx = postorder.length - 1;
        
        // Create a hashmap to store value -> index mapping for inorder array
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        // Start recursive tree building
        return buildTreeHelper(postorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] postorder, int inStart, int inEnd) {
        // Base case: no elements to construct the tree
        if (inStart > inEnd) {
            return null;
        }
        
        // Create root node using the last element in postorder traversal
        int rootVal = postorder[postIdx--];
        TreeNode root = new TreeNode(rootVal);
        
        // Find position of root in inorder traversal
        int inorderIdx = inorderMap.get(rootVal);
        
        // Important: Process right subtree first in postorder traversal
        // This is because in postorder, right subtree comes before the root
        root.right = buildTreeHelper(postorder, inorderIdx + 1, inEnd);
        root.left = buildTreeHelper(postorder, inStart, inorderIdx - 1);
        
        return root;
    }
}