class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
          // Get the sizes of the two arrays
    int n1 = a.length;
    int n2 = b.length;

    // Ensure the smaller array is passed first for binary search
    if (n1 > n2) {
        return findMedianSortedArrays(b, a);
    }

    // Binary search variables for the smaller array
    int low = 0, high = n1;
    int left = (n1 + n2 + 1) / 2; // Total elements needed on the left partition

    while (low <= high) {
        // Midpoints for partitioning the arrays
        int mid1 = (low + high) / 2; // Partition point for array 'a'
        int mid2 = left - mid1;     // Partition point for array 'b'

        // Get the elements around the partitions
        // Use Integer.MIN_VALUE and Integer.MAX_VALUE to handle edge cases
        int l1 = (mid1 == 0) ? Integer.MIN_VALUE : a[mid1 - 1]; // Left max of 'a'
        int l2 = (mid2 == 0) ? Integer.MIN_VALUE : b[mid2 - 1]; // Left max of 'b'
        int r1 = (mid1 == n1) ? Integer.MAX_VALUE : a[mid1];    // Right min of 'a'
        int r2 = (mid2 == n2) ? Integer.MAX_VALUE : b[mid2];    // Right min of 'b'

        // Check if the partitions are valid
        if (l1 <= r2 && l2 <= r1) {
            // If the total number of elements is even, return the average of the middle two elements
            if ((n1 + n2) % 2 == 0) {
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } 
            // If odd, return the max of the left partition
            else {
                return Math.max(l1, l2);
            }
        } 
        // If 'l1' is greater than 'r2', move the partition in 'a' to the left
        else if (l1 > r2) {
            high = mid1 - 1;
        } 
        // If 'l2' is greater than 'r1', move the partition in 'a' to the right
        else {
            low = mid1 + 1;
        }
    }

    // This return should never be reached if the input arrays are valid
    return 0.0;
}
}