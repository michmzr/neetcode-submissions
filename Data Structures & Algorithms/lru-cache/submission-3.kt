class LRUCache(val capacity: Int) {

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
            } else {
                //removeTail
                val removedNode = removeTail()
                cache.remove(removedNode.value.first)
                addToHead(node)
            }

            cache[key] = node
        }
    }

    private fun addToHead(node: LRUCache.Node) {
        node.prev = null
        node.next = begin

        if (begin == null) {
            end = node
        } else {
            begin!!.prev = node
        }

        begin = node
    }

    private fun removeTail(): LRUCache.Node {
        if(end == null) {
            throw IllegalStateException("Trying to remove from empty queue")
        }

        val last = end!!

        if(begin == end) {
            begin = null
            end = null
        } else {
           end = last.prev
            end!!.next = null
        }

        last.prev = null
        last.next = null

        return last
    }

    private fun moveToHead(node: Node) {
       if(node == begin) {
           return
       }


        node.prev?.next = node.next
        node.next?.prev = node.prev

        if (node == end) {
            end = node.prev
        }

        node.prev = null
        node.next = begin

        begin?.prev = node
        begin = node

        if (end == null) {
            end = node
        }
    }

    fun print() {
        var curr = begin
        while(curr != null) {
            print("{${curr.value.first}:${curr.value.second}},")

            curr = curr.next
        }
    }
}
