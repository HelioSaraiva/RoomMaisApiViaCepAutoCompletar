package br.com.allnerdbrasil.roommaisapiviacep.model


// Modelo que representa a resposta da API ViaCEP
data class Endereco(
    val cep: String? = "",
    val logradouro: String? = "",
    val bairro: String? = "",
    val localidade: String? = "",
    val uf: String? = ""
)
