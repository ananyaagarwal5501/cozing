/*

//brute = NOT GOOD, VERY COMPLEX TC=0(N* sqrt(N))
class Solution {
    public int countPrimes(int n) 
    {
        int count=0;
        //prime numbers<n
//prime numbers: only have 2 divisors: 1 and themselves
    for(int i=2; i<n; i++)
    {
        //check if i is prime
         if(isPrime(i))
        {
            count++;
        }
    }
    return count;
    }
    
    static boolean isPrime(int i)
    {
        //edge case
        if (i < 2) return false; // 0 and 1 are not prime 
        int count=0;
        for(int j=2; j*j<= i; j++)
        {
            if(i%j==0)
            {               
                return false;
            }
        }
            return true;       
    }
}
*/

//OPTIMAL: SEIVE OF Eratosthenes
class Solution {
    public int countPrimes(int n) 
    {
        int[] prime= new int[n+1];
        //assigning all to valuee 1
        for(int i=2; i<=n; i++)
        {
            prime[i]=1;
        }

        for(int i=2; i*i<=n; i++)
        {
            if(prime[i] ==1)
            {
                for(int j= i*i; j<=n; j+=i)
                {
                    prime[j]=0; //giving all multiples 0
                }

            }
        }

        //printing
        int c=0;
        for(int i=2; i<n ;i++)
        {
            if(prime[i]==1)
            {
                c++;
            }

        }
        return c;
    }
}