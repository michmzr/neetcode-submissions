class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
                    // first- index of array, second - value
        val heap = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.second })
        val maxValues = mutableListOf<Int>()
        var windowSize:Int=0

        for(i in 0..nums.size -1 ) {
            windowSize++

            if(windowSize > k) {
                val windowStart = max(0, i-k-1)
                heap.remove(Pair(windowStart, nums[windowStart]))
            }

            //add current element
            val curr = nums[i]
            heap.add(Pair(i, curr))

            //We reached window
            if(windowSize >= k) {
                //get the max of window
                maxValues.add(heap.peek().second)
            }
        }

        return  maxValues.toIntArray()
    }
}
