class MedianFinder {
 //Higher half
    var minHeap = PriorityQueue<Int>()

    // Lower bound
    var maxHeap = PriorityQueue<Int>(Collections.reverseOrder())

    fun addNum(num: Int) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num)
        } else{
            minHeap.add(num)
        }

        reBalance()
    }

    private fun reBalance() {
        if(maxHeap.size - minHeap.size > 1) {
            minHeap.add(maxHeap.poll())
        } else if(minHeap.size - maxHeap.size > 1) {
            maxHeap.add(minHeap.poll())
        }
    }

    fun findMedian(): Double {
       // println("max: $maxHeap min: $minHeap, ")

        if(maxHeap.size == minHeap.size) {
            return (maxHeap.peek() + minHeap.peek()).toDouble() / 2.0
        }

        return if (maxHeap.size > minHeap.size) {
            maxHeap.peek().toDouble()
        } else {
            minHeap.peek().toDouble()
        }
    }
}
