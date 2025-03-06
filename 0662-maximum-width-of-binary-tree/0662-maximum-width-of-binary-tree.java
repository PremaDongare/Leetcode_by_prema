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
 class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x){val=x;}
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int maxWidth=0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index; // Normalize indexes
            int left = 0, right = 0;
            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                TreeNode node = current.node;
                int index = current.index - minIndex; // Normalize index

                if (i == 0) left = index;   // First node in the level
                if (i == size - 1) right = index; // Last node in the level

                if (node.left != null) queue.offer(new Pair(node.left, index * 2 + 1));
                if (node.right != null) queue.offer(new Pair(node.right, index * 2 + 2));
            }

            maxWidth = Math.max(maxWidth, right - left + 1);
        }

        return maxWidth;
    }
}

// Helper class to store node and its index
class Pair {
    TreeNode node;
    int index;
    Pair(TreeNode n, int i) {
        node = n;
        index = i;
    }
}
    
