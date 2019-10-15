fun main(args: Array<String>) {
    val name = "혜린"
    var healthPoints = 100
    val isBlessed = true

    var karma= (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 15 ).toInt()  //보라보라하도록 해놨다
    val auraColor = when (karma) {
        in 0..5 -> "'레드'벨벳"
        in 6..10 -> "'오렌지'캬라멜"
        in 11..15 -> "방탄소년단('보라')"
        in 16..20 -> "그린은 모르겠다"
        else -> "똥색인가욤?"
    }

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

    val statusFormatString = "(HP: $healthStatus)(A: $auraColor) -> $name $healthStatus"

    println("$statusFormatString")
}