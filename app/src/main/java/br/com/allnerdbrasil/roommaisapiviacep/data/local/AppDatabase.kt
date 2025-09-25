package br.com.allnerdbrasil.roommaisapiviacep.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Banco de dados Room
@Database(entities = [EnderecoEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun enderecoDao(): EnderecoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Singleton para evitar múltiplas instâncias
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instancia = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "cadastro_db"
                ).build()
                INSTANCE = instancia
                instancia
            }
        }
    }
}
