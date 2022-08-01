package com.example.memorymaster.Classes

 class MemoryGame(private val boardSize: BoardSize) {

     val cards : List<MemoryCard>
     var foundPair = 0
     var indexOfCardSelected: Int? = null
     private var cardsFlipped = 0

    init {
        //Getting Randomized Images from ImageConstants Kotlin File
        val chosenImages = defaultIcons.shuffled().take(boardSize.cardPairsFormed())
        val randomizedImages = (chosenImages + chosenImages).shuffled()
        cards = randomizedImages.map { MemoryCard(it,false, false) }
    }

     fun flipCards(position: Int): Boolean {
         cardsFlipped++
         val card = cards[position]
         var foundMatch = false
         if (indexOfCardSelected == null) { //0 or 2 cards previously fliped over
             restoreCards()
             indexOfCardSelected = position
         }
         else{ // Exactly one card previously flipped over
             foundMatch = checkForMatch(indexOfCardSelected!!,position)
             indexOfCardSelected = null
         }
         card.isFaceUp = !card.isFaceUp
         return foundMatch
    }

     private fun checkForMatch(position1: Int, position2: Int): Boolean {
         if (cards[position1].cardIdentifier!= cards[position2].cardIdentifier){
             return false
         }
         else{
             cards[position1].matchedPair = true
             cards[position2].matchedPair = true
             foundPair++
         }
        return true
     }

     private fun restoreCards() {
         for (card in cards){
             if (card.matchedPair == false){
                 card.isFaceUp = false
             }
         }
     }

     fun haveWon(): Boolean {
         return foundPair == boardSize.cardPairsFormed()
     }

     fun isCardFaceUp(position: Int): Boolean {
         return cards[position].isFaceUp
     }

     fun getNumMoves(): Int {
         return cardsFlipped/2

     }





 }