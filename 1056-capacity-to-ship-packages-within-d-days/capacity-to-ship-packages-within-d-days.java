class Solution {
    public int shipWithinDays(int[] weights, int days) 
    {
        //min capacity to have max packages wihtin d days in the ship
        int l=0;
        int e= 0;
        for(int w: weights)
        {
            l= Math.max(l, w); //ship must carry the heaviest package at once
            e= e+ w; //the highest weight would be the sum of all weights
        }
        
        while(l<=e)
        {
            int mid= l+ (e-l)/2;

            //Concept:
            //Given a 'ship capacity = mid' 
            //can we ship within days?
           if(canShip(mid, days, weights))
           {
            e = mid - 1;  // try smaller capacity
           }
            else
            {
              l= mid+1; //try larger capacity
            }

        }
        return l;
    }

    private boolean canShip(int capacity, int days, int[] weights) {
    int daysUsed = 1;
    int currentLoad = 0;

    for (int w : weights) {

        // if adding exceeds → new day
        if (currentLoad + w > capacity) {
            daysUsed++;
            currentLoad = 0;
        }

        currentLoad += w;
    }

    return daysUsed <= days;
}
}