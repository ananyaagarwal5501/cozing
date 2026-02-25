/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame 
{
    public int guessNumber(int n) 
    {
        int l=1;
        int e= n;
        int ans= -1;
        while(l<=e)
        {
            int pick= l+ (e-l)/2;
            int p= guess(pick);
            if(p == 0)
            {
                ans= pick;
                break;
            }

            else if(p == 1) //smaller hai m
            {
                l= pick +1;
            }
            else//(guess(pick) == -1)
            {
                e= pick-1;
            }
        }
        return ans;
    }
}