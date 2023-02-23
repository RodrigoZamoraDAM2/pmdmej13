package com.example.pmdmej13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pmdmej13.databinding.RpgclassBinding


class RPGClass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = RpgclassBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var clase = ""
        var raza = intent.getStringExtra("raza")


        binding.ladron.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.ladron)
            clase = "ladron"
        }
        binding.berserker.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.berserker)
            clase = "berserker"
        }
        binding.mago.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.mago)
            clase = "mago"
        }
        binding.guerrero.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.guerrero)
            clase = "guerrero"
        }
        binding.arquero.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.arquero)
            clase = "arquero"
        }
        binding.mercader.setOnClickListener(){
            binding.imageView.setImageResource(R.drawable.mercader)
            clase = "mercader"
        }
        binding.aceptar.setOnClickListener(){
            val intent = Intent(this@RPGClass, CharacterDetails::class.java)
            intent.putExtra("raza",raza)
            intent.putExtra("clase",clase)
            startActivity(intent)
        }
    }
}