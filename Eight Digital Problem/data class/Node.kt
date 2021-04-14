data class Node(val dig: Digital, val g: Int, var h: Int) {
    fun f() = g + h
    //g为搜索深度
    //h为到目标节点曼哈顿距离
}