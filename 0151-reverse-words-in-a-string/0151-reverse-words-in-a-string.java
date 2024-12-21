class Solution {
    public String reverseWords(String s) {
        // 1. Reverse the whole string
        StringBuilder sb = new StringBuilder(s).reverse();
        int i = 0;
        // Main pointers
        int r = 0;
        int l = 0;
        int n = sb.length();
        char[] chars = sb.toString().toCharArray();

        while (i < n) {
            // Find the end of the current word
            while (i < n && chars[i] != ' ') {
                chars[r++] = chars[i++];
            }
            // If there was a word, reverse it
            if (l < r) {
                reverse(chars, l, r - 1);
                if (r < n) { // Only add a space if within bounds
                    chars[r++] = ' ';
                }
                l = r;
            }
            i++; // Keeps moving non-stop
        }

        // Remove trailing space and return the result
        return new String(chars, 0, r > 0 && chars[r - 1] == ' ' ? r - 1 : r);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}

   