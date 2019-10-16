fun main(args: Array<String>) {
    val healthPoints = 100
    val isBlessed = true
    val isImmortal = false

    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    printPlayerStatus(auraColor, isBlessed = true, name = "혜린", healthStatus = healthStatus)
    castFireball()

    performCombat()
    performCombat("나옹")
    performCombat("나옹", true)
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) = when (healthPoints) {
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

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println("(Aura : $auraColor) " + "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean) =  when (isBlessed && healthPoints > 50 || isImmortal) {
        true -> "GREEN"
        else -> "NONE"
}

private fun castFireball(numFireballs: Int = 2) = println("한 덩어리의 파이어볼이 나타난다. (x$numFireballs)")

private fun performCombat() = println("쓰러트릴 적이 없음돠")

private fun performCombat(enemyName: String) = println("$enemyName 네 놈이 적이냣!!")

private fun performCombat(enemyName: String, isBlessed: Boolean) {
    if (isBlessed) {
        println("$enemyName 네 놈이 적이냣!! 게린에게 힐 시전!!")
    } else {
        println("$enemyName 네 놈이 적이냣!!")
    }
}
