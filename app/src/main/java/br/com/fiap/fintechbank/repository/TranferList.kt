package br.com.fiap.fintechbank.repository

import br.com.fiap.fintechbank.R
import br.com.fiap.fintechbank.model.Transfer

fun  getAllTranfer(): List<Transfer>{
    return listOf(
        Transfer(1, "Trade Bitcoin", "+R$10.000,00", R.drawable.transfer),
        Transfer(2, "Venda GGBR4", "+R$1.000,00", R.drawable.transfer),
        Transfer(3, "Venda BMW M3", "+R$200.000,00", R.drawable.transfer),
        Transfer(4, "Venda Milhas", "+R$500,00", R.drawable.transfer),
        Transfer(5, "Venda Magalu", "+R$150,00", R.drawable.transfer),
        Transfer(6, "Trade Ethereum", "+R$150,00", R.drawable.transfer),
        Transfer(7, "Venda ITUB4", "+R$250,00", R.drawable.transfer),
        Transfer(8, "Venda ITUB4", "+R$800,00", R.drawable.transfer),
    )
}