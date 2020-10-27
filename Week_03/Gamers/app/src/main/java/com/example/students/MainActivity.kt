package com.example.students
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val players = listOf(
            User("Leandro", 50),
            User("Endrew", 51),
            User("Luis", 49),
            User("Ricardo Nunes", 10),
            User("Franciso de Fevereiro Duarte Lamarão", 20),
            User("Mariana", 60),
            User("João", 100),
            User("Gabriel", 35),
            User("Darwin", 3),
            User("Everton", 30),
            User("Pizzi", 0),
            User("Neuer", 100),
            User("Salvio", 69)
        )

        rv_Viewer.apply {
            adapter = RecyclerAdapter(players)
        }
    }
}


