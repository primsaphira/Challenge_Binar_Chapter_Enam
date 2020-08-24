package com.binar.myproject.codechallengebinar_chapter5

class GameService {
    var gameSuit = arrayOf("Batu", "Gunting", "Kertas")

    fun calculateWinner(player: Int, player2: Int): Result {
        return when {
            ((gameSuit[player] == "Batu" && gameSuit[player2] == "Gunting") ||
                    (gameSuit[player] == "Kertas" && gameSuit[player2] == "Batu") ||
                    (gameSuit[player] == "Gunting" && gameSuit[player2] == "Kertas")) -> {
                Result.PEMAIN_1_MENANG
            }
            ((gameSuit[player] == "Batu" && gameSuit[player2] == "Kertas") ||
                    (gameSuit[player] == "Kertas" && gameSuit[player2] == "Gunting") ||
                    (gameSuit[player] == "Gunting" && gameSuit[player2] == "Batu")) -> {
                Result.PEMAIN_2_MENANG
            }
            else -> {
                Result.DRAW
            }
        }
    }
}