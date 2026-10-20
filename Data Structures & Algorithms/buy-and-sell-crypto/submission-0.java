class Solution {
    public int maxProfit(int[] prices) {
               int[] mins = new int[prices.length];

        int max = 0;

        if(prices.length == 1)
            return 0;

        mins[0] = prices[0];

        for(int curr =1; curr < prices.length; curr++) {
            if(prices[curr] < mins[curr-1])
                mins[curr] = prices[curr-1];
            else
                mins[curr] = mins[curr-1];

            int currPrice = prices[curr];
            int income = currPrice - mins[curr];

            if(income > max) {
                System.out.println("New record: " + income + " on i=" + curr+ " min[curr]" + mins[curr]);
                max = income;
            }

        }


        return max;
    }
}
