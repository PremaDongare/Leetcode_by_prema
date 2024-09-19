class Solution {
    public int lengthOfLastWord(String s) {

        //to break the string or to cancle the space between string
        s =s.trim();
        int lastspaceIndex= s.lastIndexOf(" ");

        return s.length() -lastspaceIndex-1;
    }
}