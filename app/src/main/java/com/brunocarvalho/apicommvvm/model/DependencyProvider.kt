package com.brunocarvalho.apicommvvm.model

import com.brunocarvalho.apicommvvm.api.RetrofitService

object DependencyProvider {

    private val jsonPlaceAPI = RetrofitService.getJsonPlace()

    val postagemRepository: PostagemAPI by lazy {
        PostagemAPI(jsonPlaceAPI)
    }
}
