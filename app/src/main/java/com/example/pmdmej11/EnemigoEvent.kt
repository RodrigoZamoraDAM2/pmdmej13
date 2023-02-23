package com.example.pmdmej13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pmdmej13.databinding.EnemigoeventBinding

class EnemigoEvent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = EnemigoeventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var heroe = intent?.getSerializableExtra("heroe") as Personaje


        binding.luchar.setOnClickListener(){
            val intent = Intent(this@EnemigoEvent,Luchar::class.java)
            intent.putExtra("heroe",heroe)
            startActivity(intent)
        }
        binding.huir.setOnClickListener(){
            val intent = Intent(this@EnemigoEvent,Events::class.java)
            intent.putExtra("heroe",heroe)
            startActivity(intent)
        }
    }
}