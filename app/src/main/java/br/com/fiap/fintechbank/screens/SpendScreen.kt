package br.com.fiap.fintechbank.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.fintechbank.R

@Composable
fun SpendScreen(valController: NavController) {
    Column {
        Row(
            modifier = Modifier
                .height(100.dp)
                .background(colorResource(id = R.color.gray_100))
                .shadow(1.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            IconButton(onClick = {
                valController.navigate("home/Ricardo/100,00")
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = "Fechar",
                    modifier = Modifier
                        .size(35.dp),
                )
            }
            Text(
                modifier = Modifier.padding(start = 30.dp),
                fontWeight = FontWeight.Normal,
                fontSize = 22.sp,
                text = "Gastos"
            )
        }
    }
}