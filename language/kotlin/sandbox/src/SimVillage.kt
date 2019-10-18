fun main(args: Array<String>) {
    runSimulation()
}

inline fun runSimulation() {
    val greetingFunction = configureGreetingFunction()
    println(greetingFunction("혜린"))
    println(greetingFunction("혜린"))
}

fun configureGreetingFunction(): (String) -> String {
    val structureType = "병원"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2019
        numBuildings += 1
        println("$numBuildings 채의 $structureType 이 추가됨")
        "동물의 숲에 온 것을 환영한다구리!! $playerName (copyright $currentYear)"
    }
}
