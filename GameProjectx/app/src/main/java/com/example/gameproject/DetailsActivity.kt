package com.example.gameproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.gameproject.databinding.ActivityDetailsBinding
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDetailsBinding
    public lateinit var favoritesGamesList: ArrayList<Games>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Bindingi tanımlıyoruz..
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //intent ile bağlantıyı sağlayarak daha sonrasında adapter kısmında oluşturduğumuz
        // gameDetail ile verileri "get" kullanarak çekiyoruz.
        val intent = intent
        val selectedGame = intent.getSerializableExtra("gameDetail") as Games

        //Binding kullanarak resimleri direkt imageView'a aktarıyoruz.
        binding.detailImage.setImageResource(selectedGame.gameImage)
        binding.gameDetailName.text = selectedGame.name

        //Reddite gitmek için buton işlevini ayarlıyoruz.
        val redditButton : Button = findViewById(R.id.redditButton)

        redditButton.setOnClickListener{
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.reddit.com/r/GrandTheftAutoV/")

            startActivity(openURL)
        }

        //Websiteye gitmek için buton işlevini ayarlıyoruz.
        val websiteButton : Button = findViewById(R.id.websiteButton)

        websiteButton.setOnClickListener{
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.rockstargames.com/gta-v")

            startActivity(openURL)
        }



    }



}