package com.example.pmdmej13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pmdmej13.databinding.RaceBinding


class Race : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = RaceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var raza = ""

        binding.humano.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.humano)
            raza = "humano"
        }
        binding.elfo.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.elfo)
            raza = "elfo"
        }
        binding.enano.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.enano)
            raza = "enano"
        }
        binding.goblin.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.goblin)
            raza = "goblin"
        }
        binding.aceptar.setOnClickListener(){
            val intent = Intent(this@Race, RPGClass::class.java)
            intent.putExtra("raza",raza)
            startActivity(intent)
        }
    }
}