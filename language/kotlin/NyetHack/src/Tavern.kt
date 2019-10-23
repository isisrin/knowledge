import kotlin.math.roundToInt

const val TAVERN_NAME = "나옹's 펍"
var playerGold = 10
var playerSilver = 10

fun main(args: Array<String>) {

    placeOrder("느린마을,막걸리, 5.910")
    placeOrder("느린마을,막걸리, 5.910")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("게린이눈 $tavernMaster 에게 주문한다.")

    val (type, name, price) = menuData.split(',')
    val message = "게린이는 $price 원으로 $name ($type)을 구입한다."
    println(message)

    performPurchase(price.toDouble())

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

fun performPurchase(price: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)

    if (totalPurse > price) {
        println("지갑 전체 금액: 지폐 $totalPurse")
        println("지폐 $price 로 술을 구입함")
        val remainingBalance = totalPurse - price
        println("남은 잔액: ${"%.2f".format(remainingBalance)}")

        val remainingGold = remainingBalance.toInt()
        val remainSilver = (remainingBalance % 1 * 100).roundToInt()
        playerGold = remainingGold
        playerSilver = remainSilver
        displayBalance()
    } else {
        println("돈이 없자나 이생퀴얌!")
    }
}

fun displayBalance() {
    println("게린이의 지갑 잔액: 지폐: $playerGold 개, 동전: $playerSilver 개")
}