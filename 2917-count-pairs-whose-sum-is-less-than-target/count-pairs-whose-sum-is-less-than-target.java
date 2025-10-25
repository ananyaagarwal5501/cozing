/*//WHEN THE ARRAY IS TOLD TO BE SORTED:- 

class Solution {
    public int countPairs(List<Integer> nums, int target) 
    {
        int n= nums.size();

        int left= 0; //index
        int right= n-1; //index
        int count=0;
        int sum=0;

        if(left< right)
        {
            sum= nums.get(left)+ nums.get(right);

            if(sum< target) //badiya hai
            {
                count += (right - left);// concept: as array is sorted, so, if by index the sum of both l and r is smaller than target, then obv, all the pairs of the same l and rest all r-- will automatically be less taht target.

                left++;
            }
            else
            {
            right--; // to get new pairs with the same left value
            }
        }

        return count;

        
    }
}
*/
//WHEN ARRAY ISNT SORTED:- GO FOR BRUTE FORCE

class Solution {
    public int countPairs(List<Integer> nums, int target) 
    {
        int n= nums.size();
        int count=0;

        for(int i=0; i<n; i++)
        {
            for(int j= i+1; j<n;j++)
            {
                if(nums.get(i)+ nums.get(j) < target)
                {
                    count++;
                }
            }
        }
        return count;
    }
}