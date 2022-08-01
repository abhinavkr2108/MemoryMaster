package com.example.memorymaster.Classes

data class MemoryCard(
    val cardIdentifier: Int, //Selecting a card image
    var isFaceUp: Boolean, //Initially all cards are faced down
    var matchedPair: Boolean //Initially none of the pairs are matched
)
