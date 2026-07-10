class Solution {
       fun largestRectangleArea(heights: IntArray): Int {
        val stack = ArrayDeque<Int>()
        var maxArea:Int = 0
        val heightsPrim= heights.copyOf().plus(0)

        for(i in 0..heightsPrim.size-1 ) {
            val last = if (stack.isNotEmpty()) stack.last() else null
            while (stack.isNotEmpty() && heightsPrim[stack.last()] > heightsPrim[i]) {
                val top = stack.removeLast()
                val w = if(stack.isEmpty())  i else i - stack.last()-1

                maxArea = maxOf(maxArea, heightsPrim[top] * w)
            }
            stack.add(i)
        }

        return maxArea
    }
}
