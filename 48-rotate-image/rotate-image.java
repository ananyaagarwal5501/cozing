class Solution {
    public void rotate(int[][] matrix) 
    {
        int n= matrix.length;
        
        //1. transpose the matrix
        //2. rev the rows

        //1. transpose of the matrx: transpose only 1 triangle[upper half here], 
        for(int i=0; i<n; i++)
        {
            for(int j= i+1; j<n; j++) //dont from j=0, as it will rev the swap, no chnge will be done
            {
                //swap
                int temp= matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;               
            }
        }

        //2. rev the rows
         for(int i=0; i<n; i++)
        {
            
            int l=0; 
            int e= n-1;

            while(l<e)
            {
                //swap l and e
                int temp= matrix[i][l];
                matrix[i][l] = matrix[i][e];
                matrix[i][e] = temp;  
                l++;
                e--;   
            }
                   
    }
}
}