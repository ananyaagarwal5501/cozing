//CONDITION: PAIR SHOULD BE COMPLETE!!! OF ( AND ). BOTH SHOULD HAVE THE SAME COUNT.
class Solution {
    public List<String> generateParenthesis(int n) 
    {
        ArrayList<String> list= new ArrayList<>();
        recur(list, n, "", 0, 0);  
        return list;
        
    }

    void recur(ArrayList<String> list, int n, String current, int open, int close)
    {
        //base case
        if(open== n && close== n)
        {
            list.add(current);
            return;//reurn the final string arraylist without adding any extra characters
        }
       
    if(open<n)
    {
        recur(list, n, current+"(", open+1, close );

    }
    if(close<open)

    {
     recur(list, n, current+")", open, close+1);
    }
}
}