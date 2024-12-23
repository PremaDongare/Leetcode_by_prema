class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();{
            // firstly sort the array
            Arrays.sort(strs);
           //now take the last and the first string 
            char[] first = strs[0].toCharArray();
            char[] last = strs[strs.length-1].toCharArray();
             // compare the L and F string
             for(int i=0; i< first.length; i++){
                if(first[i]!= last[i])
                break;
                result.append(first[i]);
             }
              return result.toString(); 
         

        }
    }
}