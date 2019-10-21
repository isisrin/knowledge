const val TAVERN_NAME = "나옹's 펍"
fun main(args: Array<String>) {

    placeOrder("느린마을,막걸리,8.000")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("게린이눈 $tavernMaster 에게 주문한다.")

    val (type, name, price) = menuData.split(',')
    val message = "게린이는 $price 원으로 $name ($type)을 구입한다."
    println(message)

    val phrase = if (name == "막걸리") {
        "게린이는 감탄한다: ${toDragonSpeak("와, $name 진짜 좋구나!")}"
    } else {
        "게린이 말한다: 고마워용 $name"
    }

    println(phrase)
}

private fun toDragonSpeak(phrase: String) =
        phrase.replace(Regex("[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]")) {
            when (it.value) {
                "막" -> "꿹"
                "걸" -> "뷁"
                "리" -> "쭭"
                else -> it.value
            }
        }