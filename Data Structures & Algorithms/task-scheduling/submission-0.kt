class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        if (n == 0) return tasks.size

        // Zlicz wystąpienia każdego zadania (26 wielkich liter A-Z)
        val counts = IntArray(26)
        for (task in tasks) {
            counts[task - 'A']++
        }

        val maxFreq = counts.max()
        // Ile zadań osiąga maksymalną częstość
        val maxCount = counts.count { it == maxFreq }

        // Długość harmonogramu wyznaczona przez najczęstsze zadanie(a) + puste sloty
        val scheduleByMostFrequent = (maxFreq - 1) * (n + 1) + maxCount

        // Jeśli zadań jest bardzo dużo, wypełnią wszystkie luki idle
        return max(tasks.size, scheduleByMostFrequent)
    }
}
