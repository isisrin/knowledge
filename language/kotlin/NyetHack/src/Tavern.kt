import java.io.File
import kotlin.math.roundToInt

const val TAVERN_NAME = "나옹's 펍"
var playerGold = 10
var playerSilver = 10
val patronList = mutableListOf("태태", "슙슙", "호비")
val menuList = File("data/tavern-menu-items.txt")
                .readText()
                .split("\r\n")

fun main(args: Array<String>) {
    if (patronList.contains("태태")) {
        println("술집 주인나옹이 말한다: 태태는 저쪽에 있어요!")
    } else {
        println("술집 주인나옹이 말한다: 태태는 여기 없어요ㅠㅠ")
    }

    if (patronList.containsAll(listOf("슙슙", "호비"))) {
        println("술집 주인나옹이 말한다: 호비도 윤기도 있어용")
    } else {
        println("술집 주인나옹이 말한다: 아뇨, 둘 다 있진 않아요")
    }

    patronList.forEachIndexed { index, patron ->
        println("안녕하세용 $patron 님! ${index + 1} 번째로 도착하셨네용!!")
        placeOrder(patron, menuList.shuffled().first())
    }

    menuList.forEachIndexed { index, data ->
        println("$index :  $data")
    }
}

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName 는 $tavernMaster 에게 주문한다.")

    val (type, name, price) = menuData.split(',')
    val message = "$patronName 는 $price 원으로 $name ($type)을 구입한다."
    println(message)

    performPurchase(price.toDouble())

    val phrase = if (name == "막걸리") {
        "$patronName 는 감탄한다: ${toDragonSpeak("와, $name 진짜 좋구나!")}"
    } else {
        "$patronName 는 말한다: 고마워용 $name"
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
//    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)

    if (totalPurse > price) {
        println("지갑 전체 금액: 지폐 $totalPurse")
        println("지폐 $price 로 술을 구입함")
        val remainingBalance = totalPurse - price
        println("남은 잔액: ${"%.2f".format(remainingBalance)}")

//        val remainingGold = remainingBalance.toInt()
//        val remainSilver = (remainingBalance % 1 * 100).roundToInt()
//        playerGold = remainingGold
//        playerSilver = remainSilver
//        displayBalance()
    } else {
        println("돈이 없자나 이생퀴얌!")
    }
}

fun displayBalance() {
    println("게린이의 지갑 잔액: 지폐: $playerGold 개, 동전: $playerSilver 개")
}