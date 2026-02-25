/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) 
    {
        int l=1;
        int e= n;
        int bad=1;

        while(l<=e)
        {
            int m= l+(e-l)/2;
            if(isBadVersion(m)) //true
            {
                bad= m;
                e= m-1;
            }        

            else
            {
                l= m+1;
            }
        }
        return bad;
    }
}