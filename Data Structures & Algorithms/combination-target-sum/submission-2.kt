class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
      nums.sort()

        val res = ArrayList<List<Int>>()
        val cur = ArrayList<Int>()

        fun backtrack(start: Int, remaining: Int) {
            if(remaining == 0) {
                res.add(ArrayList(cur))
                return
            }

            for(i in start until nums.size) {
                val num = nums[i]
                if(num > remaining) {
                    break
                }

                cur.add(num)
                backtrack(i, remaining- num)

                //real backtrack
                cur.removeAt(cur.size - 1)
            }
        }

        backtrack(0, target)

        return res
    }
}
