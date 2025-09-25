package br.com.allnerdbrasil.roommaisapiviacep.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

// Entidade do banco Room que será persistida
@Entity(tableName = "enderecos")
data class EnderecoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // ID gerado automaticamente
    val cep: String,
    val logradouro: String,
    val bairro: String,
    val cidade: String,
    val uf: String
)
