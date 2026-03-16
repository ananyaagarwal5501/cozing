class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
    {
     int m= matrix.length; //row
     int n=matrix[0].length; //column

     //starting from right top corner
     int row=0;
     int col= n-1;
     
while(row<m && col >=0)
{
     if(matrix[row][col] == target)
     {
        return true;
     }

     else if(matrix[row][col] > target)
     {
        col--;
     }
     else
     {
        row++;
     }
    }
    return false;
}
}


        
   