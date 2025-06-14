class Solution {
    public int minMaxDifference(int num) {
        // convert num to strings
        String minnum=Integer.toString(num);
        String maxnum= Integer.toString(num);

        int n = minnum.length();

    // first digit in maximum that is not 9 replace it with 9

    char ch = ' ';
    for(int i=0; i<n;i++){
        if(maxnum.charAt(i)!='9'){
            ch=maxnum.charAt(i);
            break;
        }
    }
    if(ch != ' '){
        maxnum=maxnum.replace(ch,'9');
    }
    // replace 1st digit with 0
    ch= minnum.charAt(0);
    minnum=minnum.replace(ch,'0');

    return Integer.parseInt(maxnum) - Integer.parseInt(minnum);
    }
}