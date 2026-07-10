class Solution {
       fun largestRectangleArea(heights: IntArray): Int {
        /*
        maxArea = 0
        stack = pusty
        heights' = heights + [0]
        for i in 0 .. heights'.length-1:
            while stack not empty AND heights'[stack.top] > heights'[i]:
                top = stack.pop()
                w = stack empty ? i : i - stack.top - 1
                maxArea = max(maxArea, heights'[top] * w)
            stack.push(i)
        return maxArea
*/
        val stack = ArrayDeque<Int>()
        var maxArea:Int = 0
        val heightsPrim= heights.copyOf().plus(0)

        for(i in 0..heightsPrim.size-1 ) {
            val last = if (stack.isNotEmpty()) stack.last() else null
            println("i: $i, stack.last():${last} height: ${heightsPrim[i]}")
            while (stack.isNotEmpty() && heightsPrim[stack.last()] > heightsPrim[i]) {
                val top = stack.removeLast()
                val w = if(stack.isEmpty())  i else i - stack.last()-1

                println("top: $top, maxArea: ${maxOf(maxArea, heightsPrim[top] * w)}")
                maxArea = maxOf(maxArea, heightsPrim[top] * w)
            }
            stack.add(i)
            println("--------------")
        }

        return maxArea
    }
}
