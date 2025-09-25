package br.com.allnerdbrasil.roommaisapiviacep.controler


import android.content.Context
import android.widget.Toast
import br.com.allnerdbrasil.roommaisapiviacep.data.local.AppDatabase
import br.com.allnerdbrasil.roommaisapiviacep.data.local.EnderecoEntity
import br.com.allnerdbrasil.roommaisapiviacep.data.remote.RetrofitInstance
import br.com.allnerdbrasil.roommaisapiviacep.model.Endereco
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// Controller responsável por orquestrar regras de negócio
class CadastroController(private val context: Context) {

    private val enderecoDao = AppDatabase.getDatabase(context).enderecoDao()

    // Buscar endereço na API ViaCEP
    suspend fun buscarEnderecoPorCep(cep: String): Endereco {
        return withContext(Dispatchers.IO) {
            RetrofitInstance.api.buscarEndereco(cep)
        }
    }

    // Salvar endereço no banco local
    suspend fun salvarEndereco(endereco: Endereco) {
        withContext(Dispatchers.IO) {
            try {
                val entidade = EnderecoEntity(
                    cep = endereco.cep ?: "",
                    logradouro = endereco.logradouro ?: "",
                    bairro = endereco.bairro ?: "",
                    cidade = endereco.localidade ?: "",
                    uf = endereco.uf ?: ""
                )
                enderecoDao.inserir(entidade)
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Endereço salvo com sucesso!", Toast.LENGTH_SHORT).show()
                }

            }catch (e: NumberFormatException){
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "Erro ao salvar endereço: ${e.message}", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}

