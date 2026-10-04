class LRUCache(val capacity: Int) {
 val cache = LinkedHashMap<Int, Int>(capacity, 0.75f, true)
    fun get(key: Int): Int {
        return cache.getOrDefault(key, -1)
    }

    fun put(key: Int, value: Int) {
        cache[key] = value
    }
}
