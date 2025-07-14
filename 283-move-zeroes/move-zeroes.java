//BRUTE:
class Solution {
    public void moveZeroes(int[] nums) 
    {
        int n= nums.length;

         ArrayList<Integer> aa = new ArrayList<>();

         //into a new arraylist, all n-zeros
         for(int i=0; i < n; i++)
            {
                if(nums[i]!=0)
                {
                    aa.add(nums[i]); 
                }
            }
            int p= aa.size();

            //the original modified with n-zeros
            for(int j=0; j<aa.size() ; j++)
            {
                nums[j]=aa.get(j);
            }

            //filled with zeros
            for(int i=p; i<=n-1; i++)
            {
                nums[i]=0;
            }
    }
}





/*class Solution {
    public void moveZeroes(int[] nums) 
    {
        int n= nums.length;
        int j= n-1;

        while(j>0)
        {
        for(int i=0; i<n; i++)
        {
            if(nums[i]==0)
            {
                swap(nums, i, j);
            }
        }
        j--;

        
    }
    }

    public void swap(int[]arr, int f, int s)
    {
        int t= arr[f];
        arr[f]= arr[s];
        arr[s]= t;
    }
}*/

/*class Solution {
    public void moveZeroes(int[] nums) 
    {
         int n= nums.length;
         for(int i=0; i<n-i-1; i++)
        {
            //int j= n-i-1;
            if(nums[i]==0)
            {
                swap(nums, i, n-i-1); //0 pahuch gye
            }

        }
        //then sorting the non-zero elements
    }

    public void swap(int[]arr, int f, int s)
    {
        int t= arr[f];
        arr[f]= arr[s];
        arr[s]= t;
    }

}*/


//instead try creating a new array and storing values in it.
/*class Solution {
    public void moveZeroes(int[] nums) 
    {
         int n= nums.length;
         ArrayList<Integer> list = new ArrayList<>();
         

         //by making a anew array to store non-zero values, comparing the length and adding rest 0

         for(int i=0; i<n-1; i++)
        {
            if(nums[i]!=0)
            {
                list.add(nums[i]);
            }
        }

        //sorting the list
        Collections.sort(list);

        //copying to the original string
        int i=0;
        for(int num: list)
        {
            nums[i++]= list.get(num);
        }
        
        //filling with zeroes
        while(i<n)
        {
            nums[i++]= 0;
        }
    }
}
    */    
        
        
        /*int z= list.size();
        
            while(list.size()<=n)
            {
                list.add(0);
                

            }*/

            
            
            
            /*int p= n-k;
            for(int z=0; z<p; z++)
            {
                ar
            }*/

     