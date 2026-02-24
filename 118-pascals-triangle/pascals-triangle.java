class Solution {
    public List<List<Integer>> generate(int numRows) 
    {
        List<List<Integer>> answ= new ArrayList<>();

        //print the row each
        for(int row=1; row<=numRows; row++)
        {
            List<Integer> temp= new ArrayList<>();
            int ans=1;
            temp.add(ans);
            for(int col=1; col<row; col++)
            {
               ans= ans*(row-col);
               ans= ans/col;
               temp.add(ans);               
            }
            answ.add(temp);
        }

        return answ;
    }

}
        
        





       
   