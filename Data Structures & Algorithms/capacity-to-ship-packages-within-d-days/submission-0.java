class Solution {
      private boolean canShip(int[] weights, int days, int capacity) {
        int ships=1;
        int currShip=1;

       // System.out.println("---------- /" + capacity + "/---------------------");
        for (var w: weights) {
            if((currShip + w) <= capacity) {
                currShip+= w;
               // System.out.println("Ship #"+(ships) + " "+currShip+"/"+capacity);
            }else {
                ships++;
                currShip=w;
               // System.out.println("Loading a new ship #"+(ships));
                //System.out.println("Ship #"+(ships) + " "+currShip+"/"+capacity);

                if(ships > days)
                    return false;
            }
        }
       // System.out.println("---------- /" + capacity + "/---------------------");

        return true;
    }


    public int shipWithinDays(int[] weights, int days) {
        int minRange = 0, maxRange =0;

        for (int i = 0; i < weights.length; i++) {
            if(weights[i] > minRange)
                minRange = weights[i];

            maxRange += weights[i];
        }

        //System.out.println("min: " + minRange + " max:" + maxRange);
        //System.out.println("days: " + days);

        int l=minRange;
        int r=maxRange;

        int res =r;

        while(l <= r) {
            int m = (l + r) /2;

            if(canShip(weights, days, m)) {
                res = Math.min(res, m);
                r = m-1;
            }else {
                l = m+1;
            }
        }

        return res;
    }
}