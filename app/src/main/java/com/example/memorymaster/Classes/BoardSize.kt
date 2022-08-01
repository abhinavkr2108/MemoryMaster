package com.example.memorymaster.Classes

enum class BoardSize(val numcards: Int) {
    EASY(8),
    MEDIUM(18),
    HARD(24);

    fun boardWidth(): Int{
        return when (this) {
            EASY -> 2
            MEDIUM -> 3
            HARD -> 4
        }
    }

    fun boardHeight(): Int{
        return numcards/boardWidth()
    }

    fun cardPairsFormed(): Int{
        return numcards/2
    }
}