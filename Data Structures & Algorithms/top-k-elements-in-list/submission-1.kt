class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        var counts = HashMap<Int,Int>()

        for(n in nums) counts.merge(n, 1, Int::plus)

        var result = IntArray(k)
        var heapMax = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.second })
        for(k in counts) {
            heapMax.offer(Pair(k.key, k.value))
        }

        for(i in 1..k) {
            result[i-1]  = heapMax.poll().first
        }

        return result
    }
}
