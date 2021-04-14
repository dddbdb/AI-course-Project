fun main(){

    val ident=Identification()
    val fac = Factors().factors
    val r = Rules().rules
    val show = mutableListOf(
        'a',
        'b',
        'c',
        'd',
        'e',
        'f',
        'g',
        'h',
        'i',
        'j',
        'k',
        'l',
        'm',
        'n',
        'o',
        'p',
        'q',
        'r',
        's',
        't'
    )

    while (true)
     ident.identification(fac,r,show)
}