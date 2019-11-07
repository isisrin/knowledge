package com.bignerdranch.nyethack

open class Room(val name: String) {
    protected open val dangerLevel = 5

    fun description() = "Room: $name \r\n 위험수준: $dangerLevel"

    open fun load() = "아무도 여기에 오지 않았습니닭!"
}

open class TownSquare : Room("게링이네") {
    private var bellSound = "오맘맘마~~"
    final override fun load() = "당신의 참여를 돈동네사람들이 환영한다구리!! \r\n ${ringBell()}"

    override val dangerLevel = super.dangerLevel - 3
    private fun ringBell() = "당신의 도착을 종탑에서 알립니다. $bellSound"
}