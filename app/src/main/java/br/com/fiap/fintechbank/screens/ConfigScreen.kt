package br.com.fiap.fintechbank.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.fiap.fintechbank.R

@Composable
fun ConfigScreen(valController: NavHostController, agencia: String, conta: String, nome: String) {
    Column () {
        Row(
            modifier = Modifier
                .height(100.dp)
                .background(colorResource(id = R.color.gray_100))
                .shadow(1.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.perfil),
                contentDescription = "Perfil",
                modifier = Modifier
                    .padding(start = 40.dp)
                    .height(50.dp)
                    .clip(CircleShape))
            Column(
                modifier = Modifier.padding(5.dp),
            ){
                Text(
                    fontWeight = FontWeight.Normal,
                    fontSize = 22.sp,
                    text = "$nome"
                )
                Row {
                    Text(modifier = Modifier.padding(end = 10.dp), text = "Agência:$agencia")
                    Text(text = "Conta:$conta")
                }
            }
        }
        Column(
        ){
            Box(modifier = Modifier
                .clickable { true }
                .background(colorResource(id = R.color.gray_100))
                .shadow(1.dp)
                .fillMaxWidth()){
                Row(
                    modifier = Modifier
                        .padding(25.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(painter = painterResource(id = R.drawable.settings), contentDescription = "Notificações", Modifier.size(32.dp))
                    Text(text = "Configurações", modifier = Modifier.padding(start = 8.dp))
                }
            }
            Box(modifier = Modifier
                .clickable { true }
                .background(colorResource(id = R.color.gray_100))
                .shadow(1.dp)
                .fillMaxWidth()){
                Row(
                    modifier = Modifier
                        .padding(25.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(painter = painterResource(id = R.drawable.account), contentDescription = "Notificações", Modifier.size(32.dp))
                    Text(text = "Documentos", modifier = Modifier.padding(start = 8.dp))
                }
            }
            Box(modifier = Modifier
                .clickable { true }
                .background(colorResource(id = R.color.gray_100))
                .shadow(1.dp)
                .fillMaxWidth()){
                Row(
                    modifier = Modifier
                        .padding(25.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(painter = painterResource(id = R.drawable.notifications), contentDescription = "Notificações", Modifier.size(32.dp))
                    Text(text = "Notificações", modifier = Modifier.padding(start = 8.dp))
                }
            }
            Box(
                modifier = Modifier
                    .clickable { /* true */ }
                    .background(colorResource(id = R.color.gray_100))
                    .shadow(1.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(25.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.key),
                        contentDescription = "Segurança",
                        modifier = Modifier.size(32.dp)
                    )
                    Text(
                        text = "Segurança", modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
            Box(modifier = Modifier
                .clickable { true }
                .background(colorResource(id = R.color.gray_100))
                .shadow(1.dp)
                .fillMaxWidth(),
                ){
                Row(modifier = Modifier
                    .padding(25.dp)
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                    )
                {
                    Icon(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = "Indicação",
                        Modifier.size(32.dp)
                    )
                    Text(text = "Indicação", modifier = Modifier.padding(start = 8.dp))
                }
            }
        }
        Box(
            modifier = Modifier
                .padding(20.dp, top = 150.dp)
                .padding(horizontal = 80.dp)
                .fillMaxWidth()
        ){
            Button(
                onClick = { valController.navigate("login")},
                modifier = Modifier
                    .clickable { true }
                    .fillMaxWidth()
                    .padding(12.dp),
                colors = ButtonDefaults.buttonColors((colorResource(id = R.color.gray_100)))
            ){
                Icon(
                    painter = painterResource(id = R.drawable.exit),
                    contentDescription = "Sair do Aplicativo",
                    tint = Color.Black,
                )
                Text(text = "Sair do Aplicativo", modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                    color = Color.Black
                )

            }
        }
    }
}