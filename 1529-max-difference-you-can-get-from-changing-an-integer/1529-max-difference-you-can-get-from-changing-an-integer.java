class Solution {
    public int maxDiff(int num) {
        String s1= Integer.toString(num);
        String s2=s1;

        //creating max number
        int idx=-1;
        for(int i=0; i<s1.length();i++){
            if(s1.charAt(i) != '9'){
                idx=i;
                break;
            }
        }
        if(idx != -1){
            char ch = s1.charAt(idx);
            s1=s1.replace(ch,'9');
        }

        // create min number

        for(int i=0; i<s2.length(); i++){
            char ch = s2.charAt(i);
            if(i==0){
                if(ch!='1'){
                    s2=s2.replace(ch,'1');
                    break;
                }

            }
            else if(ch !='0' && ch!= s2.charAt(0)){
                s2=s2.replace(ch,'0');
                break;
            }
        }
        return Integer.parseInt(s1)-Integer.parseInt(s2);
    }
}