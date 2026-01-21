class Solution {
    public int[] rearrangeArray(int[] nums) 
    {
        int n= nums.length; //even n/2 odd and n/2 even 

        int[] ans= new int[n];
        int posindex= 0;
        int negindex= 1;

        for(int i=0; i<n; i++)
        {
            if(nums[i] >= 0)
            {
                ans[posindex]= nums[i];
                posindex += 2;
            }
            else
            {
                ans[negindex]= nums[i];
                negindex += 2;
            }
        }

        return ans;
    }
}







/*
        int n = nums.length;
        int[] pos = new int[n / 2];
        int[] neg = new int[n / 2];

        int p = 0, q = 0;

        // Separate positives and negatives
        for (int num : nums) {
            if (num > 0) pos[p++] = num;
            else neg[q++] = num;
        }

        // Merge alternately
        int[] ans = new int[n];
        int i = 0;
        p = 0; q = 0;

        while (p < pos.length) {
            ans[i++] = pos[p++];
            ans[i++] = neg[q++];
        }

        return ans;
    }
}*/
