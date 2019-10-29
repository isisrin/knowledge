import java.io.File

const val TAVERN_NAME = "나옹's 펍"
val patronList = mutableListOf("태태", "슙슙", "호비")
val lastName = listOf("김", "민", "정")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
                .readText()
                .split("\r\n")
val patronGold = mutableMapOf<String, Double>()
val menuStartCount = 30

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

    println("*** 어서오세용~~ $TAVERN_NAME ***")
    menuList.forEachIndexed { index, data ->
            var (firstName, secondName, price) = data.split(",")
            var productLength = "$firstName$secondName$price".length
            var star = getStars(productLength)
            println("$firstName $secondName$star$price")
    }

    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }
    println(uniquePatrons)

    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }
}

private fun getStars(productLength: Int): String{
    var star = "*"
    println("머리가 아프다 $productLength")
    for (i in 0..menuStartCount.minus(productLength)) {
        star += "*"
    }
    return star
}

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName 는 $tavernMaster 에게 주문한다.")

    val (type, name, price) = menuData.split(',')
    val message = "$patronName 는 $price 원으로 $name ($type)을 구입한다."
    println(message)

    performPurchase(price.toDouble(), patronName)

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

fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}

private fun displayPatronBalances() {
    patronGold.forEach { patron, balace -> {
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}