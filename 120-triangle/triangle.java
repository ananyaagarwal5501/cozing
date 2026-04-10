class Solution {
    public int minimumTotal(List<List<Integer>> triangle) 
    {
        int m= triangle.size();
        int[][] dp = new int[m][m];
        
        //base case
        for(int j=0; j<m; j++)
        {
            dp[m-1][j] = triangle.get(m-1).get(j);
        }
        int[] front= new int[m];
        for(int j=0; j<m; j++)
        {
            front[j]= triangle.get(m-1).get(j);
        }

        for(int i= m-2; i>=0; i--)
        {
            int[] curr= new int[m];
            for(int j= i; j>=0; j--)
            {
                int down= triangle.get(i).get(j) + front[j];
                int diag= triangle.get(i).get(j) + front[j+1];
                curr[j]= Math.min(down, diag);
                
            }
            front= curr;
        }
            
        
        
        return front[0]; 
    }
}