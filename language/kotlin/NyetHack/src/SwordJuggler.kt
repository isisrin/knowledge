import java.lang.IllegalArgumentException

fun main(args: Array<String>) {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordsJuggling = 2
    }

    proficiencyCheck(swordsJuggling)
    swordsJuggling = swordsJuggling!!.plus(1)

    println("$swordsJuggling 개의 칼로 저글링 스타뚜 ")
}

fun proficiencyCheck(swordsJuggling: Int?) {
    swordsJuggling ?: throw IllegalArgumentException("저글링이 불가눙햅")
}
