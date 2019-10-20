fun main(args: Array<String>) {
    var beverage = readLine()
    beverage = null

    val beverageServed: String = beverage ?: "막걸리나!"
    println(beverageServed)
}