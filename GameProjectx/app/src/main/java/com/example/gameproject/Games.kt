package com.example.gameproject

//Oyun özelliklerinin olduğu data classı tanımlıyoruz.
data class Games(var gameImage : Int, var name : String, var metacratics : String, var scores : String, var genres : String) : java.io.Serializable{

}
