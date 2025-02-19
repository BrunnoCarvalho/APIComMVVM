package com.brunocarvalho.apicommvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brunocarvalho.apicommvvm.model.Postagem
import com.brunocarvalho.apicommvvm.model.PostagemAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostagemViewModel(private val postagemAPI: PostagemAPI): ViewModel() {

    val listaPostagens = MutableLiveData<List<Postagem>>()

    fun recuperarPostagens(){

        viewModelScope.launch(Dispatchers.IO) {
            val postagens = postagemAPI.recuperarPostagens()
            listaPostagens.postValue(postagens)
        }
    }

}