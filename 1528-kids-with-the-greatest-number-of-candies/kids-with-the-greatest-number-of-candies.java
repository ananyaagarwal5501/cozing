class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {


        int len= candies.length;
        int[] aa= new int[len];
        int s=0;
        
        int max;
        max= candies[0];
        for(int i=0; i<len;i++)
        
        {
            if(candies[i]>=max)
            {
                max= candies[i]; //maximum got of the array 
            }
            aa[i]= (candies[i]+ extraCandies);
        }

        List<Boolean> result = new ArrayList<>();
        for(int j=0; j<len; j++)
        {
            if(aa[j]>=max)
            {
                result.add(true);
            }
            else
            {
                result.add(false);
            }
        }
         return result;
        
        
        
    }
}