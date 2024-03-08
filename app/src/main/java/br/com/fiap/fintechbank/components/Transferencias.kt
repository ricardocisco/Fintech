package br.com.fiap.fintech.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.fintechbank.model.Transfer


@Composable
fun TransferenciaCard(transfer: Transfer){
    Card(
        modifier = Modifier.padding(top = 10.dp)
    ){
        Row(modifier = Modifier
            .padding(top = 20.dp, bottom = 20.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Icon(
                painter = painterResource(id = transfer.icon),
                contentDescription = "Transferencia"
            )
            Text(
                fontSize = 20.sp,
                text = transfer.name
            )
            Text(
                fontSize = 20.sp,
                text = transfer.price
            )
        }
    }
}