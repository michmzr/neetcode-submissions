class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()

        val res = mutableListOf<List<Int>>()

             fun dfs(i: Int, cur: MutableList<Int>, total: Int) {
            if(total == target) {
                res.add(ArrayList(cur))
                return
            }

            if(i >= nums.size || total > target) {
                return
            }

            cur.add(nums[i])
            dfs(i, cur, total + nums[i])
            cur.removeAt(cur.size -1) //do a backstep

            val j = i+1
            if(j < nums.size && (nums[j] + total <= target))
                dfs(i+1, cur, total) // try with next number
        }

        dfs(0, mutableListOf(), 0)

        return res
    }
}
