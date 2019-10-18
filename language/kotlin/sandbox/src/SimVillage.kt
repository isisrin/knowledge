fun main(args: Array<String>) {
    runSimulation("혜린", ::printConstructionCost) {playerName, numBuildings ->
        val currentYear = 2019
        println("$numBuildings 채의 건물이 추가됨")
        "$playerName 촌장님! 여긴 동물의 숲이다구리! (copyright $currentYear)"
    }

}

inline fun runSimulation(playerName: String, costPrinter: (Int) -> Unit, greetingFuction: (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last()
    costPrinter(numBuildings)
    println(greetingFuction(playerName, numBuildings))
}

fun printConstructionCost(numBuildings: Int) {
    val cost = 500
    println("건축비용: ${cost * numBuildings}")
}
