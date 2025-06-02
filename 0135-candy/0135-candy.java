class Solution {
    public int candy(int[] ratings) {
        int n= ratings.length;
        int candies =1; // first child
        int up=0, down=0, peak=0;

        for(int i=1; i<n; i++){
            if(ratings[i] >ratings[i-1]){
                up++;
                peak=up;
                down=0;
                candies +=1+up;
            }else  if(ratings[i]== ratings[i-1]){
                // rest all if flat slop
                up=down=peak=0;
                candies +=1;
            }else{
                //down hil slope
                up=0;
                down++;
                candies +=1+down -(peak >= down ? 1:0);
            }
        }
        return candies;
        
    }
}