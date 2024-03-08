package br.com.fiap.fintech.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.fintechbank.database.dao.ExtratoDao
import br.com.fiap.fintechbank.model.Extrato

@Database(entities = [Extrato::class], version = 1)
abstract class ExtratoDb : RoomDatabase() {

    abstract fun extratoDao(): ExtratoDao

    companion object {

        private lateinit var instace: ExtratoDb

        fun getDatabase(context: Context): ExtratoDb{
            if(!::instace.isInitialized){
                instace = Room
                    .databaseBuilder(
                    context, ExtratoDb::class.java, "extrato_db"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instace
        }
    }

}