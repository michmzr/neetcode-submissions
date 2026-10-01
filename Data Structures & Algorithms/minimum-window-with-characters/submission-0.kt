class Solution {
  fun minWindow(s: String, t: String): String {
        if(s.isEmpty() || t.isEmpty())
            return ""

        if(t.length > s.length)
            return ""

        var left = 0

        val window = HashMap<Char, Int>()
        val need = HashMap<Char, Int>()

        for (c in t) {
            need[c] = need.getOrDefault(c, 0) + 1
        }
        val required = need.entries.sumOf { it.value }
        var have = 0

        var result = ""

        for (right in s.indices) {
            // dodaj s[right] do window
            val c = s[right]
            window[c] = window.getOrDefault(c, 0) + 1

            // jeśli znak osiągnął wymagany licznik, have++
            if(need.containsKey(c) && window[c]!! <= need[c]!!  )
                have++

            while (have == required) {
                // zapisz najlepsze okno
                val currWindow =  s.substring(left, right + 1)
                if(result.isEmpty() || currWindow.length < result.length)
                   result = currWindow

                // usuń s[left]
                val leftChar = s[left]

                // jeśli po usunięciu brakuje znaku, have--
                if (need.containsKey(leftChar) && window[leftChar]!! <= need[leftChar]!!) {
                    have--
                }
                window[leftChar] = window[leftChar]!! - 1

                // left++
                left++
            }
        }

        return result
    }
}
