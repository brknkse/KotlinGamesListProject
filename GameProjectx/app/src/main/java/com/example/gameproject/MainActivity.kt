package com.example.gameproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.gameproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Daha sonra tanımlamak üzere bindingi yaratıyoruz.
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Bindingi tanımlıyoruz.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(GamesFragment())


        //SetOnItemSelectedListener ile iconlara tıklandığında ne olacağını tanımlıyoruz.
        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.joystick->replaceFragment(GamesFragment())
                R.id.star->replaceFragment(FavoritesFragment())

                else->{

                }

            }
            true
        }

    }
    //Fragmentlar arası geçişte birbiri üzerine çakışmamalarını sağlıyoruz.
    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }


}