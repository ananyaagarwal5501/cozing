class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int m= matrix.length;
        int n= matrix[0].length;

        int l=0;
        int h= m-1;

        while(l<=h)
        {
            int mid= l+ (h-l)/2; //mid column
             
            if(matrix[mid][0] <= target)
            {
               l= mid+1; 
            }

            else
            {
                h= mid-1;
            }
        }  
        if (h < 0) return false;
        return (findcol(matrix, h, n, target ));
    }

    public boolean findcol(int[][] arr, int row, int ncols, int t)
    {
        int l=0;
        int h= ncols-1;
        
        while(l <=h)
        {
            int mid= l+(h-l)/2;
            if(arr[row][mid] == t)
            {
                return true;
            }
            else if(arr[row][mid] < t)
            {
                l= mid+1;
            }
            else
            {
                h= mid-1;
            }
        }
        return false;
    }
}