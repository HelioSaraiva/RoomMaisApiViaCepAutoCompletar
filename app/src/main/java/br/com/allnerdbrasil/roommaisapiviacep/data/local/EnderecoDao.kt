package br.com.allnerdbrasil.roommaisapiviacep.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// DAO do Room: interface que contém os métodos de acesso ao BD
@Dao
interface EnderecoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(endereco: EnderecoEntity)

    @Query("SELECT * FROM enderecos")
    suspend fun listarTodos(): List<EnderecoEntity>
}
