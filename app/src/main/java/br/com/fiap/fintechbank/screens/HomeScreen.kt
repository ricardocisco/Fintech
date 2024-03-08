package br.com.fiap.fintechbank.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.fintechbank.R
import br.com.fiap.fintechbank.components.ButtonWithText
import br.com.fiap.fintech.components.TransferenciaCard
import br.com.fiap.fintechbank.repository.getAllTranfer


@Composable
fun HomeScreen(valController: NavController, nome: String, saldo: String){

    var transferList by remember {
        mutableStateOf(getAllTranfer())
    }

    Column (){
        Row(
            modifier = Modifier
                .height(100.dp)
                .background(colorResource(id = R.color.gray_100))
                .shadow(1.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                fontWeight = FontWeight.Normal,
                fontSize = 22.sp,
                text = "Olá, $nome"
            )
            IconButton(onClick = {valController.navigate("login")}) {
                Icon(
                    painter = painterResource(id = R.drawable.notifications),
                    contentDescription = "Notifications",
                    modifier = Modifier
                        .size(35.dp),
                )
            }
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(22.dp)
        ){
            Text(
                fontSize = 24.sp,
                text = "Meu saldo:"
            )
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    fontSize = 22.sp,
                    text = "R$$saldo"
                )
                Icon(
                    painter = painterResource(id = R.drawable.eye),
                    contentDescription = "Notifications",
                    modifier = Modifier
                        .size(35.dp),
                )
            }
            LazyRow(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .padding(vertical = 8.dp)
            ) {
                item {
                    ButtonWithText(
                        iconId = R.drawable.up,
                        text = "Receber",
                        onClick = {valController.navigate("receipt")}
                    )
                }
                item {
                    ButtonWithText(
                        iconId = R.drawable.down,
                        text = "Gastos",
                        onClick = {valController.navigate("spend")}
                    )
                }
                item {
                    ButtonWithText(
                        iconId = R.drawable.extrato,
                        text = "Extrato",
                        onClick = {valController.navigate("")}
                    )
                }
                item {
                    ButtonWithText(
                        iconId = R.drawable.graph,
                        text = "Investir",
                        onClick = {valController.navigate("")}
                    )
                }
                item {
                    ButtonWithText(
                        iconId = R.drawable.pagar,
                        text = "Pagar",
                        onClick = {valController.navigate("")}
                    )
                }
                item {
                    ButtonWithText(
                        iconId = R.drawable.recarga,
                        text = "Recarga",
                        onClick = {valController.navigate("")}
                    )
                }
            }
            Spacer(modifier = Modifier.padding(top = 20.dp))
            LazyColumn(
                modifier = Modifier.weight(1f)
            ){
                items(transferList){
                    TransferenciaCard(transfer = it)
                }
            }
            Spacer(modifier = Modifier.padding(top = 15.dp))
            Row(
                modifier = Modifier
                    .padding(20.dp)
                    .padding(horizontal = 50.dp)
                    .fillMaxWidth()
                    .clip(CircleShape)
                    .background(colorResource(id = R.color.gray_100)),
                horizontalArrangement = Arrangement.Center
            ){
                IconButton(onClick = {valController.navigate("login")}) {
                    Icon(
                        painterResource(id = R.drawable.home),
                        contentDescription = "Inicio",
                        modifier = Modifier
                            .size(36.dp),
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painterResource(id = R.drawable.cartao),
                        contentDescription = "Cartao",
                        modifier = Modifier
                            .size(36.dp),
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painterResource(id = R.drawable.graph),
                        contentDescription = "Investimentos",
                        modifier = Modifier
                            .size(36.dp),
                    )
                }
                IconButton(onClick = {valController.navigate("config/440/137485/Ricardo")}) {
                    Icon(
                        painterResource(id = R.drawable.menu),
                        contentDescription = "Menu",
                        modifier = Modifier
                            .size(36.dp),
                    )
                }
            }
        }
    }
}



