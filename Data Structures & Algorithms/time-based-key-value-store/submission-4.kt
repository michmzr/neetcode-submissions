class TimeMap() {

    val map = HashMap<String, java.util.TreeMap<Int, String>>()

    fun set(key: String, value: String, timestamp: Int) {
        map.putIfAbsent(key, TreeMap<Int, String>())
        map.get(key)!!.put(timestamp, value)
    }

     fun get(key: String, timestamp: Int): String? {
        val floor =map.get(key)?.floorEntry(timestamp)
        return if(floor != null) floor.value else ""
    }
}
