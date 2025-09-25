package br.com.allnerdbrasil.roommaisapiviacep.data.remote



import br.com.allnerdbrasil.roommaisapiviacep.model.Endereco
import retrofit2.http.GET
import retrofit2.http.Path

// Interface Retrofit para acessar a API ViaCEP
interface ViaCepService {
    @GET("{cep}/json/")
    suspend fun buscarEndereco(@Path("cep") cep: String): Endereco
}
