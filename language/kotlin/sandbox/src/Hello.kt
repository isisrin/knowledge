const val MAX_EXPERIENCE: Int = 5000
const val VAR_NAME = "Unicorn's Horn"
fun main(args: Array<String>) {
    val playerName = "Hyerin"
    var experiencePoints = 5
    var hasSteed = false
    var hasHorse = false
    var money = 50
    val menu = mapOf("beer" to 3, "soju" to 5)
    experiencePoints += 5
    println(experiencePoints)
    println(playerName)

    reverseName(playerName)
}
fun reverseName(playerName: String) {
    return println(playerName.reversed())
}