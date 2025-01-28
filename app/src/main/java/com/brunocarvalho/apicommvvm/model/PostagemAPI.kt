package com.brunocarvalho.apicommvvm.model

import com.brunocarvalho.apicommvvm.api.JsonPlaceAPI

class PostagemAPI(private val jsonPlaceAPI: JsonPlaceAPI) {

    suspend fun recuperarPostagens(): List<Postagem> {

        try {
            val retorno = jsonPlaceAPI.recuperarPostagens()
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