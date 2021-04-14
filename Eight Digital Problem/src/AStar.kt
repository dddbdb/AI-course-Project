object AStar {
    private fun searchSolution(openlist: NodeList, closelist: NodeList, targetDig: Digital) {
        openlist.sortList()
        closelist.nodeList.add(openlist.nodeList[0])
        val next = openlist.nodeList[0].dig.getNext()
        val g=openlist.nodeList[0].g + 1
        openlist.nodeList.removeAt(0)
        for (node in closelist.nodeList)
        {
            if(next.contains(node.dig))
                next.remove(node.dig)
        }
        for (node in openlist.nodeList)
        {
            if(next.contains(node.dig))
                next.remove(node.dig)
        }
        for (i in 1..next.size) {
            openlist.nodeList.add(Node(next[i - 1], g, next[i - 1].getH(targetDig)))
        }
    }


    private fun searchByStep(openlist: NodeList, closelist: NodeList, targetDig: Digital){
        searchSolution(openlist,closelist, targetDig)
            println("**************选择的节点**************")
            closelist.nodeList[closelist.nodeList.size - 1].dig.showDig()
            println("**************openlist**************")
            for (i in 1..openlist.nodeList.size) {
                println("g:" + openlist.nodeList[i - 1].g +",h:" + openlist.nodeList[i - 1].h +  ",f:" + openlist.nodeList[i - 1].f())
                openlist.nodeList[i - 1].dig.showDig()
            }
            println("**************closelist**************")
            val size = closelist.nodeList.size
            for (i in 1..closelist.nodeList.size) {
                println("g:" + closelist.nodeList[size - i].g +",h:" + closelist.nodeList[size - i].h +  ",f:" + closelist.nodeList[size - i].f())
                closelist.nodeList[size - i].dig.showDig()
            }
    }

    fun startGetTarget(initDig:Digital,targetDig:Digital){
        println("初始棋盘：")
        initDig.showDig()
        println("目标棋盘：")
        targetDig.showDig()
        if (!Util.isSolvable(initDig, targetDig))
            println("此棋盘无解")
        else {
            if (initDig == targetDig)
                println("初始和目标棋盘相同")
            else {
                println("请选择模式：")
                println("0：逐步搜索")
                println("1：自动搜索")


                //region 初始化open和close表
                val next = initDig.getNext()
                val openlist = NodeList(mutableListOf(Node(next[0],1 , next[0].getH(targetDig))))
                for (i in 2..next.size) {
                    openlist.nodeList.add(Node(next[i - 1],1 , next[i - 1].getH(targetDig)))
                }
                val closelist = NodeList(mutableListOf(Node(initDig, 0, initDig.getH(targetDig))))
                //endregion


                val s: Int = readLine()?.toInt() ?: 0
                var d = 2
                if (s == 0) {
                    while(closelist.nodeList[closelist.nodeList.size - 1].h != 0) {
                        println("**************第" + d + "次搜索**************")
                        searchByStep(openlist, closelist, targetDig)
                        d++
                        readLine()
                    }
                    println("**************搜索完成**************")
                } else {
                    while (closelist.nodeList[0].h != 0) {
                        searchSolution(openlist, closelist, targetDig)
                        closelist.sortByH()
                    }
                }
                println("**********解**********")
                println("初始棋盘：")
                initDig.showDig()
                closelist.showSolution()
            }
        }
    }
}