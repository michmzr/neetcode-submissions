class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
               // first- index of array, second - value
        val heap = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.second })
        val maxValues = mutableListOf<Int>()

        for(i in 0..nums.size -1 ) {
            val windowStart = max(0, i-k-1) //todo test
            if(windowStart > 0) {
                heap.remove(Pair(windowStart, nums[windowStart]))
            }

            //add current element
            val curr = nums[i]
            if(heap.isNotEmpty() && curr > heap.peek().second) {
                heap.poll()
            }

            heap.add(Pair(i, curr))

            //We reached window
            if(i >= (k-1)) {
                //get the max of window
                maxValues.add(heap.peek().second)
            }
        }

        return  maxValues.toIntArray()
    }
}
