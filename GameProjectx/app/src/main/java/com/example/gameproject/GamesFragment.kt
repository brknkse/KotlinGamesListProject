package com.example.gameproject

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_games.*
import kotlinx.android.synthetic.main.list_item.*


class GamesFragment : Fragment() {

    //Tanımlamalarımızı yapıyoruz.
    private lateinit var adapter: MyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var gamesArrayList : ArrayList<Games>

    lateinit var imageId : Array<Int>
    lateinit var namee : Array<String>
    lateinit var metacriticc : Array<String>
    lateinit var scoree : Array<String>
    lateinit var genree : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_games, container, false)
    }





    override fun onViewCreated(view: View,savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        //İlk olarak gamesArrayList'i oluşturan fonksiyonu çağırıyoruz.
        dataInitialize()

        //Burada recyclerView tanımlamalarını yapıyoruz.
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MyAdapter(gamesArrayList)
        recyclerView.adapter = adapter


    }

    




    //Oyunları gamesArrayList'e atayacak fonksiyonu tanımlıyoruz.
    private fun dataInitialize(){
        gamesArrayList = arrayListOf<Games>()

        imageId = arrayOf(
            R.drawable.gtav,
            R.drawable.portal,
            R.drawable.witcher,
            R.drawable.left,
            R.drawable.gtav,
            R.drawable.portal,
            R.drawable.witcher,
            R.drawable.left


        )

        namee = arrayOf(
            "Grand Theft Auto V",
            "Portal 2",
            "The Witcher 3:Wil Hunt",
            "Left 4 Dead 2","Grand Theft Auto V",
            "Portal 2",
            "The Witcher 3:Wil Hunt",
            "Left 4 Dead 2"
        )

        metacriticc = arrayOf(
            "metacritic:",
            "metacritic:",
            "metacritic:",
            "metacritic:",
            "metacritic:",
            "metacritic:",
            "metacritic:",
            "metacritic:"
        )

        scoree = arrayOf(
            "96","95","89","89","96","95","89","89"
        )

        genree = arrayOf("Action,shooter","Action,puzzle","Action,puzzle","Action,puzzle","Action,shooter","Action,puzzle","Action,puzzle","Action,puzzle")

        //for döngüsü ile bütün oyunları gamesArrayList içine ekliyoruz
        for(i in imageId.indices){
            val games = Games(imageId[i],namee[i],metacriticc[i],scoree[i],genree[i])
            gamesArrayList.add(games)
        }

    }


}