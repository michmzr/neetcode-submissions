class TimeMap() {

    val map = HashMap<String, java.util.TreeMap<Int, String>>()

    fun set(key: String, value: String, timestamp: Int) {
        map.putIfAbsent(key, TreeMap<Int, String>())
        map.get(key)!!.put(timestamp, value)
    }

    fun get(key: String, timestamp: Int): String {
       // println(map.get(key))
        return map.get(key)!!.floorEntry(timestamp).value!!
    }
}
