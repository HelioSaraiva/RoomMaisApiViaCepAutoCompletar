package br.com.allnerdbrasil.roommaisapiviacep.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Objeto Retrofit configurado para acessar a API do ViaCEP
object RetrofitInstance {
    private const val BASE_URL = "https://viacep.com.br/ws/"

    val api: ViaCepService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ViaCepService::class.java)
    }
}
