class LRUCache(capacity: Int) {

    var cache = HashMap<Int, Node>()
    var order = LinkedList<Pair<Int, Int>>()

    data class Node(var next: Node?, var prev: Node?, var value: Pair<Int, Int>){
        override fun toString(): String {
            return "{${value.first}:${value.second}} next: ${next!= null} prev: ${prev!=null}"
        }
    }

    var begin: Node? = null
    var end: Node? = null

    fun get(key: Int): Int {
        if(cache.containsKey(key)) {
            val node = cache[key]!!
            moveToHead(node)
            return node.value.second
        } else {
            return -1
        }
    }

    fun put(key: Int, value: Int) {
        if(cache.containsKey(key)) {
            val node = cache[key]!!

            node.value = Pair(key, value)
            moveToHead(node)
        } else {
            //add a new node to head
            val node = Node(next = null, prev = null, value = Pair(key, value))
            if(cache.size < capacity) {
                addToHead(node)
                cache[key] = node
            } else {
                //removeTail
                val removedNode = removeTail()
                cache.remove(removedNode.value.first)
            }
        }
    }

    private fun addToHead(node: LRUCache.Node) {
        if(begin == end  && begin == null) {
            //cache is empty
            begin = node
            end = node
        } else {
            node.next = begin
            begin = node
        }
    }

    private fun removeTail(): LRUCache.Node {
        if(begin == end  && begin == null) {
            throw IllegalStateException("Trying to remove from empty queue")
        }

        if(begin == end) {
            val last = end
            begin = null
            end = null

            return last!!
        } else {
            val secondFromTail = end!!.prev
            val last = end
            end = secondFromTail

            return last!!
        }
    }

    private fun moveToHead(node: Node) {
        node.next = begin
        begin = node
    } 
}
