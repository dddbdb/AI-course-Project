import kotlin.String
class Identification {

    val select = mutableListOf('1')
    var forbidden = ""
    val forbidR = mutableListOf('1')

 fun identification(fac:Map<Char, String>, r:Map<Char, String>, show: MutableList<Char>) {

     if (show.size > 0) {
         Util.showFac(show as ArrayList<Char>, fac)
         Util.showSel(select as ArrayList<Char>, fac)
         val s = readLine()?.toInt()
         if (s != null) {
             if (s < 1 || s > show.size) println("*********************************没有这一项*********************************")
             else {
                 select.add(Util.getSelectFacors(s, show))
                 forbidden += Util.getForbiddenRules(Util.getSelectFacors(s, show), r)
                 for (n in show) {
                     if (forbidden.contains(n, ignoreCase = true))
                         forbidR.add(n)
                 }
                 for (m in forbidR) {
                     show.remove(m)
                 }
             }
         }
     }
     else Util.showresult(select as ArrayList<Char>)
   }
}

