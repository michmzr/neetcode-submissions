class Solution {
   private boolean canShip(int[] weights, int days, int capacity) {
        int ships=1;
        int currCap=capacity;

//        System.out.println("---------- /" + capacity + "/---------------------");
        for (var w: weights) {
            if((currCap -w) < 0) {
                ships++;
//                System.out.println("Loading a new ship #"+(ships));

                if(ships > days)
                    return false;

                currCap = capacity;
            }

            currCap -=w;
        }
//        System.out.println("---------- /" + capacity + "/---------------------");

        return true;
    }


    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r =0;

        for (int i = 0; i < weights.length; i++) {
            if(weights[i] > l)
                l = weights[i];

            r += weights[i];
        }
//
//        System.out.println("min: " + l + " max:" + r);
//        System.out.println("days: " + days);

        int res =r;

        while(l <= r) {
            int cap = (l + r) /2;

            if(canShip(weights, days, cap)) {
                res = Math.min(res, cap);
                r = cap-1;
            }else {
                l = cap+1;
            }
        }

        return res;
    }
}