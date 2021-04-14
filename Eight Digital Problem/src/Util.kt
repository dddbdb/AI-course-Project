object Util {

    private fun getInversionNumber(list:ArrayList<Int>):Int{
        var inverNum=0
        for (i in 1..list.size) {
            if(list[i-1]!=0)
                for (j in 1..i) {
                    if (list[j-1]>list[i-1])
                        inverNum++
                }
        }
        return inverNum
    }

    fun isSolvable(initDig: Digital, targetDig: Digital)=getInversionNumber(initDig.digital)%2==getInversionNumber(targetDig.digital)%2

}