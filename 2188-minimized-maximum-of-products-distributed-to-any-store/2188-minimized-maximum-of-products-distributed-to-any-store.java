class Solution {
    // Helper function to check if the distribution is valid
    private boolean isValid(int n, int[] quantities, int maxAllowed) {
        int storeCount = 0; // Count the number of stores needed
        for (int quantity : quantities) {
            // Calculate how many stores are needed for this product type
            storeCount += (quantity + maxAllowed - 1) / maxAllowed; // Equivalent to Math.ceil(quantity / maxAllowed)
            if (storeCount > n) {
                return false; // Exceeds the number of available stores
            }
        }
        return true;
    }

    public int minimizedMaximum(int n, int[] quantities) {
        // Binary search range
        int start = 1; // Minimum possible max products per store
        int end = 0; // Maximum possible max products per store
        for (int quantity : quantities) {
            end = Math.max(end, quantity); // Maximum product count in the array
        }

        int answer = end; // Initialize the answer with the maximum possible value

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isValid(n, quantities, mid)) {
                answer = mid; // Update the answer
                end = mid - 1; // Try for a smaller maximum
            } else {
                start = mid + 1; // Increase the maximum
            }
        }

        return answer;
    }
}
