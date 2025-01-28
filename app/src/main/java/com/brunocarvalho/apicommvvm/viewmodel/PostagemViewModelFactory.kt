package com.brunocarvalho.apicommvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brunocarvalho.apicommvvm.model.PostagemAPI

class PostagemViewModelFactory(private val postagemAPI: PostagemAPI): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(PostagemViewModel::class.java)){
            PostagemViewModel(postagemAPI) as T
        }else{
            throw IllegalArgumentException("ViewModel não foi configurado corretamente")
        }
    }
}