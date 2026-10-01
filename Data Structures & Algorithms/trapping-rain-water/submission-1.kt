class Solution {
    fun trap(height: IntArray): Int {
        var result = 0

        var l = 0
        var r = height.size-1
        var lMax = height[l] //the tallest l side wall
        var rMax = height[r] //the tallest r side wall

        while(l<r) {
            if(lMax < rMax) {
                l++
                lMax = maxOf(lMax, height[l])
                result += lMax - height[l]
            }else {
                r--
                rMax = maxOf(rMax, height[r])
                result += rMax - height[r]
            }
        }

        return result
    }
}
