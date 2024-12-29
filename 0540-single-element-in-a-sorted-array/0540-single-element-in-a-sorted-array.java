class Solution {
    public int singleNonDuplicate(int[] A) {
        int n = A.length;
        if (n == 1) return A[0]; // If there's only one element, return it

        int st = 0, end = n - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            // Edge cases for the first and last elements
            if (mid == 0 && A[mid] != A[mid + 1]) return A[mid];
            if (mid == n - 1 && A[mid] != A[mid - 1]) return A[mid];

            // Check if mid is the single element
            if (A[mid - 1] != A[mid] && A[mid] != A[mid + 1]) return A[mid];

            // Binary search logic
            if (mid % 2 == 0) { // Even index
                if (A[mid] == A[mid + 1]) {
                    // Single element is on the right side
                    st = mid + 2;
                } else {
                    // Single element is on the left side
                    end = mid - 1;
                }
            } else { // Odd index
                if (A[mid] == A[mid - 1]) {
                    // Single element is on the right side
                    st = mid + 1;
                } else {
                    // Single element is on the left side
                    end = mid - 1;
                }
            }
        }

        return -1; // If no single element is found
    }
}
