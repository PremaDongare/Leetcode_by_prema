class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int st = 1, end = A.length - 2; // Start and end indices, excluding first and last as they can't be peaks.

        while (st <= end) {
            int mid = st + (end - st) / 2;

            // Check if mid is the peak
            if (A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                return mid;
            }
            // Move to the right half
            else if (A[mid - 1] < A[mid]) {
                st = mid + 1;
            } 
            // Move to the left half
            else {
                end = mid - 1;
            }
        }

        // If no peak is found (though it's guaranteed in a mountain array)
        return -1;
    }
}
