package br.com.fiap.fintechbank.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.fintechbank.R


@Composable
fun LoginScreen(valController: NavController){

    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier.fillMaxWidth()){
            Row(modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.menu),
                        contentDescription = "Menu Bar",
                        modifier = Modifier
                            .size(50.dp),
                    )
                }
                Text(fontSize = 34.sp, fontWeight = FontWeight.Medium, fontFamily = FontFamily.SansSerif ,text = "CSBank")
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.notifications),
                        contentDescription = "Notifications",
                        modifier = Modifier
                            .size(50.dp),
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(top = 150.dp, start = 30.dp, end = 30.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Text(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        text = "Email",
                        textAlign = TextAlign.Start
                    )
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        placeholder = { Text("exemplo@gmail.com") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.gray_100)),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email
                        ),
                    )
                }
                Spacer(modifier = Modifier.padding(18.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        text = "Senha",
                        textAlign = TextAlign.Start
                    )
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        placeholder = { Text("sua senha") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.gray_100)),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        ),
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            textDecoration = TextDecoration.Underline,
                            fontSize = 14.sp,
                            text = "Criar uma conta"
                        )
                        Text(
                            textDecoration = TextDecoration.Underline,
                            fontSize = 14.sp,
                            text = "Esqueci minha senha"
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Button(
                    modifier = Modifier
                        .size(width = 200.dp, height = 50.dp)
                        .shadow(4.dp, shape = CircleShape, clip = true),
                    colors = ButtonDefaults.buttonColors((colorResource(id = R.color.gray_100))),
                    onClick = {valController.navigate("home/Ricardo/100,00")}
                ) {
                    Text(color = Color.Black, fontSize = 18.sp, text = "Entrar")
                }
                Spacer(modifier = Modifier.padding(24.dp))
                Button(
                    modifier = Modifier
                        .size(width = 300.dp, height = 50.dp)
                        .shadow(4.dp, shape = CircleShape, clip = true),
                    colors = ButtonDefaults.buttonColors((colorResource(id = R.color.gray_100))),
                    onClick = { /*TODO*/ }
                ) {
                    Text(color = Color.Black, fontSize = 18.sp, text = "Continue com o Google")
                }
                Spacer(modifier = Modifier.padding(6.dp))
                Button(
                    modifier = Modifier
                        .size(width = 300.dp, height = 50.dp)
                        .shadow(4.dp, shape = CircleShape, clip = true),
                    colors = ButtonDefaults.buttonColors((colorResource(id = R.color.gray_100))),
                    onClick = { /*TODO*/ }
                ) {
                    Text(color = Color.Black, fontSize = 18.sp, text = "Continue com a Apple")
                }
            }
        }
    }
}