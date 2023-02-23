package com.example.pmdmej13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pmdmej13.Objeto
import com.example.pmdmej13.Personaje
import com.example.pmdmej13.databinding.LucharBinding
import kotlin.random.Random

class Luchar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = LucharBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var heroe = intent.getSerializableExtra("heroe") as Personaje
        var vidaEnemigo = 0
        var fuerza = 0
        var artilugio = Objeto(5,10,20)

        if (Random.nextInt(1, 11) > 8){
            vidaEnemigo = 200
            fuerza = 30
        }
        else {
            vidaEnemigo = 100
            fuerza = 20
        }
        binding.enemybar.max = vidaEnemigo
        binding.enemybar.min = 0
        binding.enemybar.progress = 0

        binding.playerbar.max = heroe.vida
        binding.playerbar.min = 0
        binding.playerbar.progress = 0

        println("Fuerza"+heroe.fuerza)
        println("Defensa"+heroe.defensa)
        println("Vida"+heroe.vida)


        binding.atacar.setOnClickListener(){
            if (Random.nextInt(1,7)>3){
                binding.enemybar.progress += heroe.fuerza
                vidaEnemigo -= heroe.fuerza
            }
            var ataque = fuerza/heroe.defensa
            binding.playerbar.progress += ataque
            heroe.vida -= ataque

            if(vidaEnemigo <= 0){
                heroe.meterEnMochila(artilugio)
                heroe.monedero += 100
            }
            if(heroe.vida <= 0){
                startActivity(Intent(this@Luchar,Blank::class.java))
            }
        }
        binding.huir.setOnClickListener(){
            if(Random.nextInt(1,7)>4){
                val intent = Intent(this@Luchar,Events::class.java)
                intent.putExtra("heroe",heroe)
                startActivity(intent)
            }
            else{
                binding.enemybar.progress += fuerza/heroe.defensa

                if(binding.enemybar.progress >= vidaEnemigo){
                    heroe.meterEnMochila(artilugio)
                    heroe.monedero += 100
                }
                if(binding.playerbar.progress >= heroe.vida){
                    startActivity(Intent(this@Luchar,Blank::class.java))
                }
            }
        }
        binding.objeto.setOnClickListener(){
            if (heroe.mochila.size>0){
                heroe.sacarDeMochila(heroe.mochila.size)
                binding.playerbar.progress -= 20
                heroe.vida += 20
            }
        }
    }
}