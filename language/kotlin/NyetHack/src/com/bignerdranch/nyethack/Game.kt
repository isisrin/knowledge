package com.bignerdranch.nyethack

import java.lang.Exception
import java.lang.IllegalStateException

fun main(args: Array<String>) {

    Game.play()
    performCombat()
    performCombat("나옹")
    performCombat("나옹", true)
}

object Game {
    private val player = Player("혜링")
    private var currentRoom: Room = TownSquare()

    private var worldMap = listOf(
            listOf(currentRoom, Room("매직샵"), Room("BTS POP UP STORE")),
            listOf(Room("worderland"), Room("태태네"))
    )

    init {
        println("방문을 환영합니다.")
        player.castFireball()
    }

    fun play() {
        while (true) {
            println(currentRoom.description())
            println(currentRoom.load())

            printPlayerStatus(player)

            print("> 명령을 입력하세요: ")
            println("최근 명령: ${readLine()}")
            println(GameInput(readLine()).processCommand())
        }
    }

    private fun printPlayerStatus(player: Player) {
        println("(Aura : ${player.auraColor()} " + "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }

    private class GameInput(args: String?) {
        private val input = args ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, { "" })

        private fun commandNotFound() = "적합하지 않은 명령이에염!"

        fun processCommand() = when (command.toLowerCase()) {
            "move" -> move(argument)
            else -> commandNotFound()
        }
    }

    private fun move(directionInput: String) =
            try {
                val direction = Direction.valueOf(directionInput.toUpperCase())
                val newPosition = direction.updateCoordinate(player.currentPosition)
                if (!newPosition.isInBounds) {
                    throw IllegalStateException("$direction 쪽 방향이 범위를 벗어남")
                }

                val newRoom = worldMap[newPosition.y][newPosition.x]
                player.currentPosition = newPosition
                currentRoom = newRoom
                "OK, $direction 방향의 ${newRoom.name} 으로 이동했습니다."
            } catch (e: Exception) {
                "잘못된 방향이에욤: $directionInput"
            }
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
