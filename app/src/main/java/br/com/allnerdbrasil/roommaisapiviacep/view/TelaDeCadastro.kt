package br.com.allnerdbrasil.roommaisapiviacep.view

import br.com.allnerdbrasil.roommaisapiviacep.controler.CadastroController
import br.com.allnerdbrasil.roommaisapiviacep.model.Endereco

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

// Tela de cadastro que usa Compose Material3
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaDeCadastro(context: Context) {
    val controller = remember { CadastroController(context) }

    // Estados dos campos
    var cep by remember { mutableStateOf("") }
    var logradouro by remember { mutableStateOf("") }
    var bairro by remember { mutableStateOf("") }
    var cidade by remember { mutableStateOf("") }
    var uf by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope() // Coroutines sem lifecycleScope

    Column(modifier = Modifier.padding(16.dp)) {

        // Campo de CEP
        OutlinedTextField(
            value = cep,
            onValueChange = {
                cep = it
                if (cep.length == 8) { // Quando completar 8 dígitos, busca automaticamente
                    scope.launch {
                        val endereco = controller.buscarEnderecoPorCep(cep)
                        logradouro = endereco.logradouro ?: ""
                        bairro = endereco.bairro ?: ""
                        cidade = endereco.localidade ?: ""
                        uf = endereco.uf ?: ""
                    }
                }
            },
            label = { Text("CEP") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        // Logradouro
        OutlinedTextField(
            value = logradouro,
            onValueChange = { logradouro = it },
            label = { Text("Logradouro") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        // Bairro
        OutlinedTextField(
            value = bairro,
            onValueChange = { bairro = it },
            label = { Text("Bairro") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        // Cidade
        OutlinedTextField(
            value = cidade,
            onValueChange = { cidade = it },
            label = { Text("Cidade") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        // UF
        OutlinedTextField(
            value = uf,
            onValueChange = { uf = it },
            label = { Text("UF") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        // Botão para salvar no BD
        Button(
            onClick = {
                scope.launch {
                    controller.salvarEndereco(
                        Endereco(
                            cep = cep,
                            logradouro = logradouro,
                            bairro = bairro,
                            localidade = cidade,
                            uf = uf
                        )
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Salvar")
        }
    }
}
