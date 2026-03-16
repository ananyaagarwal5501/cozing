class Solution {
    public String longestCommonPrefix(String[] strs) 
    {
        StringBuilder res= new StringBuilder();
        //res="";

        int n= strs.length;
        Arrays.sort(strs);

        //comparing the 1st and the last strings
        char[] fst= strs[0].toCharArray();
        char[] last= strs[n-1].toCharArray();

        for(int i=0; i<fst.length; i++)
        {
            if(fst[i] != last[i])
            {
                break;
            }
            res.append(fst[i]);
        }

        return res.toString();
        
    }
}