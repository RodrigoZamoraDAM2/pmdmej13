package com.example.pmdmej13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pmdmej13.databinding.ObjetoeventBinding

class ObjetoEvent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ObjetoeventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var heroe = intent?.getSerializableExtra("heroe") as Personaje
        var artilugio = Objeto(5,10,20)



        binding.recoger.setOnClickListener(){
            val intent = Intent(this@ObjetoEvent,Events::class.java)
            if(heroe.calcularPeso()+artilugio.peso <= heroe.pesoMochila)
                heroe.meterEnMochila(artilugio)
            println("tenemos "+heroe.mochila.size+" objetos en la mochila")
            intent.putExtra("heroe",heroe)
            startActivity(intent)
        }
        binding.objcontinuar.setOnClickListener(){
            val intent = Intent(this@ObjetoEvent,Events::class.java)
            intent.putExtra("heroe",heroe)
            startActivity(intent)
        }
    }
}