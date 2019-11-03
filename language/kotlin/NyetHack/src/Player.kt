class Player {
    var name = "게링"
    get() = field.capitalize()
    private set(value) {
        field = value.trim()
    }

    val healthPoints = 100
    val isBlessed = true
    private val isImmortal = false

    fun castFireball(numFireballs: Int = 2) {
        println("한 덩어리의 파이어볼이 나타난다. (x$numFireballs)")
    }

    fun formatHealthStatus() = when (healthPoints) {
        100 -> "컨디션 최고에염!"
        in 90..99 -> "좀 별로에염 ㅠㅠ"
        in 75..89 -> if (isBlessed) {
            "포션빨아써염"
        } else {
            "컨디션 최악이에염 ㅠㅠ"
        }
        in 15..74 -> "집이 생각난다우!!!!!!!!1"
        else -> "집에 보내주라줘!!"
    }


    fun auraColor() =  when (isBlessed && healthPoints > 50 || isImmortal) {
        true -> "GREEN"
        else -> "NONE"
    }
}