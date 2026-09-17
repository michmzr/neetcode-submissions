class Solution {
  fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
                    // first- index of array, second - value
        val heap = PriorityQueue<Pair<Int, Int>>(compareByDescending { it.second })
        val maxValues = mutableListOf<Int>()
        var windowSize:Int=0

        for(i in 0..nums.size -1 ) {
            windowSize++

            //add current element
            val curr = nums[i]
            heap.add(Pair(i, curr))

            while (heap.peek().first <= i - k) {
                heap.poll()
            }

            //We reached window
            if(windowSize >= k) {
                //get the max of window
                maxValues.add(heap.peek().second)
            }
        }

        return  maxValues.toIntArray()
    }
}