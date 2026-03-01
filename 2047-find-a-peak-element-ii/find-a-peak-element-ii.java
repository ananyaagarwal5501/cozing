class Solution {
    public int[] findPeakGrid(int[][] mat) 
    {
        int m= mat.length;
        int n= mat[0].length;
        int[] ans= new int[2];

        int l=0;
        int e= n-1;

        while(l<=e)
        {
            //the mid column
            int mid= l+(e-l)/2;

            //biggest row number of the mid column
            int maxrow=0;
            for(int i=0; i<m; i++)
            {
                if(mat[i][mid]> mat[maxrow][mid])
                {
                    maxrow = i; //got the largest row element of the mid column
                }
            }
                int curr= mat[maxrow][mid]; 

                //now checking for the left and right neighbours of that max row number
                int left=  mid>0 ? mat[maxrow][mid-1] : -1;
                int right= mid<n-1 ? mat[maxrow][mid+1] : -1;

                if(curr> left && curr > right)
                {
                    ans[0]= maxrow;
                    ans[1]= mid;
                    return ans;
                }
                else if(left > curr) //peak toward left
                {
                    e= mid-1;
                }
                else //peak towards the right side
                {
                    l= mid+1;
                }
                
         }
         return new int[]{-1, -1};
        }

        
    }
