package com.example.memorymaster.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.memorymaster.Classes.BoardSize
import com.example.memorymaster.Classes.MemoryCard
import com.example.memorymaster.R
import kotlin.math.min

class EasyLevelAdapter(
    private val context: Context,
    private val boardSize: BoardSize,
    private val cardImages: List<MemoryCard>,
    private val clickListner: cardClickListner
) :
    RecyclerView.Adapter<EasyLevelAdapter.ViewHolder>() {

    interface cardClickListner {
        fun onCardClicked(position: Int){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Creating Card width and height programmatically
        val cardWidth = parent.width/boardSize.boardWidth()
        val cardHeight = parent.height/boardSize.boardHeight()
        val cardSideLength = min(cardHeight, cardWidth)
        val view = LayoutInflater.from(context).inflate(R.layout.item_card_view, parent, false)

        //Setting Card width and height programmatically
        val layoutParams = view.findViewById<CardView>(R.id.itemCardView).layoutParams
        layoutParams.width = cardSideLength
        layoutParams.height = cardSideLength
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return boardSize.numcards
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageButton = itemView.findViewById<ImageButton>(R.id.itemImageButton)
        fun bind(position: Int) {
            val cardFinalImage = cardImages[position]
            imageButton.setImageResource(if (cardFinalImage.isFaceUp) cardFinalImage.cardIdentifier else R.mipmap.ic_launcher_adaptive_back)

            imageButton.alpha = if (cardFinalImage.matchedPair == true) 0.4f else 1.0f
            if (cardFinalImage.matchedPair == true){
                val colorState = ContextCompat.getColorStateList(context, R.color.grey)
                ViewCompat.setBackgroundTintList(imageButton, colorState)
            }

            imageButton.setOnClickListener {
                Log.i("EasyImageButton", "Clicked on Button ${position}")
                clickListner.onCardClicked(position)

            }
        }
    }

}

