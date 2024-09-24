class Solution {
    public boolean repeatedSubstringPattern(String s) {
        // Concatenate the string with itself and remove the first and last characters.
        String str = s + s;
        // Check if the original string exists in this new string, excluding the first and last characters.
        return str.substring(1, str.length() - 1).contains(s);
    }
}
