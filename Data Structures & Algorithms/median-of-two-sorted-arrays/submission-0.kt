class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
 //Stopniowe mergowanie 2 list i wtedy mediana (?)
        var merged = mutableListOf<Int>()
        val n = nums1.size
        val m = nums2.size
        var nIt = 0
        var mIt = 0

        if(n == 0 && m==0)
            return 0.0

        if((n != 0 && m ==0) || (n ==0 && m != 0)) {
            merged.addAll(nums1.toList())
            merged.addAll(nums2.toList())
        } else {
            while (merged.size < n + m) {
                //we added all n
                if(nIt == n) {
                    while (mIt < m) {
                        merged.add(nums2[mIt++])
                    }
                    break
                }

                //we added all m elements
                if(mIt == m) {
                    while (nIt < n) {
                        merged.add(nums1[nIt++])
                    }
                    break
                }

                val nEl = nums1[nIt]
                val mEl = nums2[mIt]

                if(nEl < mEl) {
                    merged.add(nEl)
                    nIt++
                } else if (mEl < nEl) {
                    merged.add(mEl)
                    mIt++
                } else { // both equals
                    merged.add(nEl)
                    merged.add(mEl)
                    nIt++
                    mIt++
                }
            }
        }

        val arr = merged.toIntArray()
        val mergedSize = arr.size

        val result: Double =
            if (mergedSize % 2 == 1) {
                arr[mergedSize / 2].toDouble()
            } else {
                (arr[mergedSize / 2 - 1] + arr[mergedSize / 2]) / 2.0
            }

        return result
    }
}
