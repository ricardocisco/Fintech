package br.com.fiap.fintechbank.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_extrato")
data class Extrato(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var nome: String = "",
    var price: String = "",
)
