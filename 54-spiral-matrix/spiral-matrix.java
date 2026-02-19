class Solution {
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        int n= matrix.length;
        int m= matrix[0].length;

        int top= 0;
        int left=0;
        int right= m-1;
        int bottom= n-1;

        List<Integer> ans= new ArrayList<>();

        while(top<= bottom && left<= right)
        {
        //performing the dir: right-> down ->left -> up, shift the start point, repeat.
        //1. right direction
        for(int i= left; i<=right; i++)
        {
            ans.add(matrix[top][i]);
        }       
        top++;

        //2. down direction
        for(int i=top; i<= bottom; i++)
        {
            ans.add(matrix[i][right]);
        }
        right--;

        if(top <= bottom) //EDGE: to check if the other row is still there, or a single row
        {
        //3. left direction
        for(int i=right; i>=left; i--)
        {
            ans.add(matrix[bottom][i]);
        }
         bottom--;
        }

        if(left<= right) //EDGE 
        {
        //4. up direction
        for(int i=bottom; i>=top; i--)
        {
            ans.add(matrix[i][left]);
        }
        left++;
        }
        
    }
    return ans;
    }
}