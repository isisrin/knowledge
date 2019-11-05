package com.bignerdranch.nyethack

fun main(args: Array<String>) {

    val player = Player("")
    player.castFireball()

    printPlayerStatus(player)
    performCombat()
    performCombat("나옹")
    performCombat("나옹", true)
}

private fun printPlayerStatus(player: Player) {
    println("(Aura : ${player.auraColor()} " + "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}

private fun performCombat() = println("쓰러트릴 적이 없음돠")

private fun performCombat(enemyName: String) = println("$enemyName 네 놈이 적이냣!!")

private fun performCombat(enemyName: String, isBlessed: Boolean) {
    if (isBlessed) {
        println("$enemyName 네 놈이 적이냣!! 게린에게 힐 시전!!")
    } else {
        println("$enemyName 네 놈이 적이냣!!")
    }
}
