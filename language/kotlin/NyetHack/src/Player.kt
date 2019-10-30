class Player {
    var name = "게링"
    get() = field.capitalize()
    set(value) {
        field = value.trim()
    }

    fun castFireball(numFireballs: Int = 2) {
        println("한 덩어리의 파이어볼이 나타난다. (x$numFireballs)")
    }
}