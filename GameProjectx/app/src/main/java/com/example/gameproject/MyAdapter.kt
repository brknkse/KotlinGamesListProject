package com.example.gameproject

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.shapes.Shape
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import kotlinx.android.synthetic.main.fragment_games.view.*
import kotlinx.android.synthetic.main.list_item.view.*

class MyAdapter(private val gamesList:ArrayList<Games>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
        parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        val currentItem = gamesList[position]
        holder.gameImage.setImageResource(currentItem.gameImage)
        holder.name.text = currentItem.name
        holder.metacritics.text = currentItem.metacratics
        holder.scores.text = currentItem.scores
        holder.genres.text = currentItem.genres

        //Bir oyuna tıklandığında oluşan renk animasyonunu tanımladık
        holder.itemView.itemLayout.setOnClickListener {
            it.setBackgroundColor(0xE0E0E0)
        }
        //Bir oyuna tıklandığında o oyunun details sayfasına gitmesini ve açılan oyunların arka
        // planının değişmesini tanımladık.
        holder.itemView.setOnClickListener{

            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            //inten.putExtra ile gamesListteki elemanları gameDetail ile "key" bağlantısı oluşturuyoruz.
            intent.putExtra("gameDetail",gamesList.get(position))
            holder.itemView.context.startActivity(intent)
            holder.itemView.setBackgroundColor(Color.parseColor("#E0E0E0"))


        }


    }

    override fun getItemCount(): Int {
        return gamesList.size
    }
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val gameImage : ShapeableImageView = itemView.findViewById(R.id.GameImage)
        val name : TextView = itemView.findViewById(R.id.gameName)
        val metacritics : TextView = itemView.findViewById(R.id.gameMetacritic)
        val scores : TextView = itemView.findViewById(R.id.gameScore)
        val genres : TextView = itemView.findViewById(R.id.gameGenre)

    }
}