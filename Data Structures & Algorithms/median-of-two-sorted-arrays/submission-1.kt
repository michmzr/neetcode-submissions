class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
  val n = nums1.size
        val m = nums2.size
        val total = n + m

        if (total == 0) return 0.0

        var i = 0
        var j = 0
        var prev = 0
        var curr = 0

        for (count in 0..total / 2) {
            prev = curr
            curr = when {
                i >= n -> nums2[j++]
                j >= m -> nums1[i++]
                nums1[i] <= nums2[j] -> nums1[i++]
                else -> nums2[j++]
            }
        }

        return if (total % 2 == 1) curr.toDouble() else (prev + curr) / 2.0
    }
}
