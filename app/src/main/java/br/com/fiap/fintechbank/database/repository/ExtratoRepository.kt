package br.com.fiap.fintechbank.database.repository

import android.content.Context
import br.com.fiap.fintech.database.dao.ExtratoDb
import br.com.fiap.fintechbank.model.Extrato

class ExtratoRepository(context: Context){

    var db = ExtratoDb.getDatabase(context).extratoDao()

    fun adicionar(extrato: Extrato): Long{
        return db.adicionar(extrato)
    }
    fun atualizar(extrato: Extrato): Int{
        return db.atualizar(extrato)
    }

    fun excluir(extrato: Extrato): Int {
        return db.excluir(extrato)
   }

    fun mostrarExtrato(id: Int): Extrato {
        return  db.mostrarExtrato(id)
    }

    fun listarExtrato(): List<Extrato>{
        return db.listarExtrato()
    }

}


