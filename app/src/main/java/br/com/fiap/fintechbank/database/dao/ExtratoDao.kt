package br.com.fiap.fintechbank.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.fintechbank.model.Extrato

@Dao
interface ExtratoDao {

    @Insert
    fun adicionar(extrato: Extrato): Long

    @Update
    fun atualizar(extrato: Extrato): Int
    @Delete
    fun excluir(extrato: Extrato): Int

    @Query("SELECT * FROM tbl_extrato WHERE id = :id")
    fun mostrarExtrato(id: Int): Extrato

    @Query("SELECT * FROM tbl_extrato ORDER BY nome ASC")
    fun listarExtrato(): List<Extrato>

}