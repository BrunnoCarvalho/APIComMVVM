package com.brunocarvalho.apicommvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.brunocarvalho.apicommvvm.databinding.ActivityMainBinding
import com.brunocarvalho.apicommvvm.viewmodel.PostagemViewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var postagemViewModel: PostagemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        postagemViewModel = ViewModelProvider(this)[PostagemViewModel::class.java]

        postagemViewModel.listaPostagens.observe(this){ postagens ->

            var listaResultado = ""
            postagens.forEach { postagem ->
                listaResultado += " ${postagem.id} + ${postagem.title} \n"
            }

            binding.textResultado.text = listaResultado

        }
    }

    override fun onStart() {
        super.onStart()
        postagemViewModel.recuperarPostagens()

    }
}