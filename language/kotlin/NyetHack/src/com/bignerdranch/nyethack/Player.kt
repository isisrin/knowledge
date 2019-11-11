package com.bignerdranch.nyethack

import java.io.File

class Player (_name: String, var healthPoints: Int = 100, val isBlessed: Boolean, private val isImmortal: Boolean) {
    var name = _name
    get() = "${field.capitalize()} 의 $hometown"
    private set(value) {
        field = value.trim()
    }

    val hometown by lazy { selectHometown() }
    var currentPosition = Coordinate(0, 0)

    init {
        require(healthPoints > 0, { "healthPoints는 0보다 커야 해욥!" })
        require(name.isNotBlank(), { "플레이어는 이름이 있어야 행!" })
    }

    constructor(name: String) : this (name,
        isBlessed = true,
        isImmortal = false) {
        if (name.contains("링")) healthPoints = 40
    }

    fun auraColor() =  when (isBlessed && healthPoints > 50 || isImmortal) {
        true -> "GREEN"
        else -> "NONE"
    }

    fun formatHealthStatus() = when (healthPoints) {
        100 -> "컨디션 최고에염!"
        in 90..99 -> "좀 별로에염 ㅠㅠ"
        in 75..89 -> "포션빨아써염"
        in 15..74 -> "집이 생각난다우!!!!!!!!1"
        else -> "집에 보내주라줘!!"
    }

    fun castFireball(numFireballs: Int = 2) {
        println("한 덩어리의 파이어볼이 나타난다. (x$numFireballs)")
    }

    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("\r\n")
        .shuffled()
        .first()
}