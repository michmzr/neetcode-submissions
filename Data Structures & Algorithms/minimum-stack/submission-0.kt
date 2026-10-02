class MinStack() {

    var stack = LinkedList<Int>()
    var mins = PriorityQueue<Int>()

    fun push(`val`: Int) {
        stack.addLast(`val`)
        mins.add(`val`)
    }

    fun pushVal(nr: Int) {
        push(nr)
    }

    fun pop() {
        val el = stack.removeLast()
        mins.remove(el)
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return mins.first()
    }
}
