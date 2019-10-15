fun main(args: Array<String>) {
    val name = "혜린"
    var healthPoints = 100
    val isBlessed = true
    var isImmortal = false

    var auraVisible = isBlessed && healthPoints > 50 || isImmortal
    var auraColor = if (auraVisible) "GREEN" else "NONE"

    var healthStatus = when (healthPoints ) {
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

    println("(Aura : $auraColor) " + "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}