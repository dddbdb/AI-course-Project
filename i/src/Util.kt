import kotlin.String
import kotlin.system.exitProcess

object Util {

    fun getSelectFacors(input: Int, show: ArrayList<Char>): Char = show.get(input - 1)

    fun getForbiddenRules(sel: Char, rul: Map<Char, String>): String? = rul.get(sel)

    fun showFac(show: ArrayList<Char>, fac: Map<Char, String>) {
        println("*********************************当前可选择*********************************")
        var i = 1
        for (r in show) {
            if (i - i / 5 * 5 == 0 || i == show.size)
                println("$i.${fac.get(r)}")
            else {
                val out = i.toString() + "." + fac.get(r)
                val oLength=i.toString().length+fac.get(r)!!.length*1.67+1
                val tabN=5-oLength/4
                System.out.printf(out)
                for (int in 1..tabN.toInt())
                {
                    System.out.printf("\t")
                }
            }
            i++
        }
    }

    fun showSel(sel: ArrayList<Char>, fac: Map<Char, String>) {
        var i = 1
        println("*********************************当前已选择*********************************")
        for (r in sel) {
            if (r != '1') {
                if (i == sel.size - 1) {
                    println("$i.${fac.get(r)}")
                } else print("$i.${fac.get(r)}\t")
                i++
            }
        }
    }

    fun showresult(sel: ArrayList<Char>) {
        println("*********************************识别的结果*********************************")
        when {
            sel.contains('t') -> println("该动物是信天翁")
            sel.contains('s') -> println("该动物是企鹅")
            sel.contains('p') && sel.contains('q') -> println("该动物是鸵鸟")
            sel.contains('n') -> {
                if (sel.contains('j') || sel.contains('k')) println("该动物是斑马")
                if (sel.contains('l')) println("该动物是虎")
            }
            sel.contains('m') -> {
                if (sel.contains('o')) println("该动物是长颈鹿")
                if (sel.contains('l')) println("该动物是金钱豹")
            }
        }
        exitProcess(1);
    }
}