class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long MOD = 1_000_000_007;
        
        // Arrays to store boundaries
        int[] leftBoundary = new int[n];
        int[] rightBoundary = new int[n];
        
        // Stack to find next smaller element
        Stack<Integer> stack = new Stack<>();
        
        // Find left boundaries (first smaller element to the left)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            leftBoundary[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        // Clear stack for right boundaries
        stack.clear();
        
        // Find right boundaries (first smaller element to the right)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            rightBoundary[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        // Calculate prefix sums
        long[] prefixSum = new long[n + 1];
        prefixSum[0] = 0;  // Initialize first element as 0
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (long)nums[i];  // Cast to long to prevent overflow
        }
        
        // Find maximum min-product
        long maxProduct = 0;
        for (int i = 0; i < n; i++) {
            // Get the boundaries of the current subarray
            int left = leftBoundary[i] + 1;
            int right = rightBoundary[i] - 1;
            
            // Calculate the sum of the range using prefix sums
            // right + 1 because we want to include the right boundary
            // left because prefixSum[left] represents sum up to but not including left
            long rangeSum = prefixSum[right + 1] - prefixSum[left];
            
            // Calculate product (cast nums[i] to long to prevent overflow)
            long product = rangeSum * (long)nums[i];
            
            // Update maximum product if necessary
            maxProduct = Math.max(maxProduct, product);
            
            /* Uncomment for debugging
            System.out.println("Element: " + nums[i] + 
                             " Left: " + left + 
                             " Right: " + right + 
                             " RangeSum: " + rangeSum + 
                             " Product: " + product);
            */
        }
        
        // Return the result modulo 10^9 + 7
        return (int)(maxProduct % MOD);
    }
}