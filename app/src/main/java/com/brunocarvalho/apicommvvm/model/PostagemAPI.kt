package com.brunocarvalho.apicommvvm.model

import com.brunocarvalho.apicommvvm.api.RetrofitService

class PostagemAPI {

    suspend fun recuperarPostagens(): List<Postagem> {

        val jsonPlace = RetrofitService.getJsonPlace()

        try {
            val retorno = jsonPlace.recuperarPostagens()
            if(retorno.isSuccessful){
                retorno.body()?.let { postagens ->
                    return postagens
                }
            }
        }catch (erroRecuperarPostagem: Exception){
            erroRecuperarPostagem.printStackTrace()
        }

        return emptyList()
    }

}