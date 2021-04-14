data class NodeList(val nodeList: MutableList<Node>) {

    fun sortList()=this.nodeList.sortWith(compareBy({ it.f() }, { it.h }))
    fun sortByH()=this.nodeList.sortWith(compareBy { it.h })
    fun sortByG()=this.nodeList.sortWith(compareBy { it.g })

    private fun getSolution(closelist:NodeList): ArrayList<Node> {
        closelist.sortByG()
        val size = closelist.nodeList.size
        val solution = arrayListOf(closelist.nodeList[size-1])
        for (i in 1 until closelist.nodeList.size) {
            if(closelist.nodeList[size-i].dig.getNext().contains(solution[solution.size-1].dig))
                solution.add(closelist.nodeList[size-i])
        }
        return solution
    }

    fun showSolution(){
        val solution=getSolution(this)
        val size=solution.size
        for (i in 1..solution.size)
        {
            println("g:"+solution[size-i].g+",h:"+solution[size-i].h+",f:"+solution[size-i].f())
            solution[size-i].dig.showDig()
        }
    }
}