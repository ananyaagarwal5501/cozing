class Solution {
    public List<Integer> majorityElement(int[] nums) 
    {
        int n= nums.length;

        ArrayList<Integer> ans= new ArrayList<>();

        //BY MOORE'S VOTING ALGO
        int el1=0;
        int ct1=0;
        int el2=0;
        int ct2=0;

        for(int i=0; i< nums.length; i++)
        {
            if(ct1 == 0 && el2 != nums[i])
            {
                ct1 = 1;
                el1= nums[i];
            }

            else if(ct2 == 0 && el1 != nums[i])
            {
                ct2 = 1;
                el2= nums[i];
            }

            else if(el1 == nums[i]) ct1++;
            else if(el2 == nums[i]) ct2++;
            else
            {
                ct1--;
                ct2--;
            }
        }
        //We must recount actual frequencies of el1 and el2.
        ct1=0;
        ct2=0;
        for(int i=0; i<n; i++)
        {
            if(nums[i] == el1 ) ct1++;
            else if(nums[i] == el2 ) ct2++; //else if prevents the double cunting in ex. [0,0,0,0]
        }
        if(ct1> (int)Math.floor(n/3))
        {
            ans.add(el1);
        }
        if(ct2> (int)Math.floor(n/3))
        {
            ans.add(el2);
        }

        return ans;
    }
}

       


  