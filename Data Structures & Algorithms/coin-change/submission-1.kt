class Solution {
     fun coinChange(coins: IntArray, amount: Int): Int {
        val INF = Int.MAX_VALUE-1
        var hm = mutableMapOf<Int, Int>(0 to 0)

        fun dfs(amt: Int):Int {
            if(hm.contains(amt))
                return hm[amt]!!

            if(amt == 0)
                return  0

            var res = INF
            for(coin in coins) {
                if(amt - coin >= 0)
                    res = minOf(res, 1 + dfs(amt-coin))
            }
            hm[amt] = res
            return res
        }

        val minCoins = dfs(amount)

        return if(minCoins>= INF) -1 else minCoins
    }
}
