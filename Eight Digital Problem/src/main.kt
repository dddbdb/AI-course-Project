fun main() {

    val initDig = Digital(
        arrayListOf(
            1, 2, 3,
            4, 5, 6,
            7, 8, 0
        )
    )

    val targetDig = Digital(
        arrayListOf(
            1, 2, 3,
            4, 5, 6,
            7, 8, 0
        )
    )
    AStar.startGetTarget(initDig,targetDig)
}