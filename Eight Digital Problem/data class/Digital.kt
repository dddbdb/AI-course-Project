data class Digital(val digital: ArrayList<Int>) {

    fun showDig() {
        for (i in 1..this.digital.size) {
            print(this.digital[i - 1])
            if (i == 3 || i == 6 || i == 9) println()
        }
        println()
    }

    fun getNext(): ArrayList<Digital> {
        val nextdigital = ArrayList<Digital>()
        for (i in 1..this.digital.size)
            if (this.digital[i - 1] == 0) {
                if (i > 3) {
                    val al = ArrayList<Int>()
                    al.addAll(this.digital)
                    val above = Digital(al)
                    above.digital[i - 1] = above.digital[i - 4]
                    above.digital[i - 4] = 0
                    nextdigital.add(above)
                }
                if (i < 7) {
                    val bl = ArrayList<Int>()
                    bl.addAll(this.digital)
                    val below = Digital(bl)
                    below.digital[i - 1] = below.digital[i + 2]
                    below.digital[i + 2] = 0
                    nextdigital.add(below)
                }
                if (i % 3 == 0 || i % 3 == 2) {
                    val ll = ArrayList<Int>()
                    ll.addAll(this.digital)
                    val left = Digital(ll)
                    left.digital[i - 1] = left.digital[i - 2]
                    left.digital[i - 2] = 0
                    nextdigital.add(left)
                }
                if (i % 3 == 1 || i % 3 == 2) {
                    val rl = ArrayList<Int>()
                    rl.addAll(this.digital)
                    val right = Digital(rl)
                    right.digital[i - 1] = right.digital[i]
                    right.digital[i] = 0
                    nextdigital.add(right)
                }
            }
        return nextdigital
    }

    fun getH(targetDig: Digital):Int{
        var h =0
        for(i in 1..this.digital.size)
        {

            if (this.digital[i-1]!=targetDig.digital[i-1])
                h++
        }
        return h
    }
}