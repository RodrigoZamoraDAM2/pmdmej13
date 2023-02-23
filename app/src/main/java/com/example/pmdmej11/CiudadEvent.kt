package com.example.pmdmej13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pmdmej13.databinding.CiudadeventBinding

class CiudadEvent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = CiudadeventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var heroe = intent?.getSerializableExtra("heroe") as Personaje


        binding.entrar.setOnClickListener(){
            startActivity(Intent(this@CiudadEvent,Blank::class.java))
        }
        binding.ciucontinuar.setOnClickListener(){
            val intent = Intent(this@CiudadEvent,Events::class.java)
            intent.putExtra("heroe",heroe)
            startActivity(intent)
        }
    }
}