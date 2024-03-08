package br.com.fiap.fintechbank.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.fintechbank.R
import br.com.fiap.fintechbank.database.repository.ExtratoRepository
import br.com.fiap.fintechbank.model.Extrato

@Composable
fun ReceiptScreen(valController: NavController) {

    var nomeState = remember {
        mutableStateOf("")
    }

    var precoState = remember {
        mutableStateOf("")
    }

    val context = LocalContext.current
    val extratoRepository = ExtratoRepository(context)

    val listarExtratoState = remember {
        mutableStateOf(extratoRepository.listarExtrato())
    }

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
                    painter = painterResource(id = R.drawable.close ),
                    contentDescription = "Fechar",
                    modifier = Modifier
                        .size(35.dp),
                )
            }
            Text(
                modifier = Modifier.padding(start = 30.dp),
                fontWeight = FontWeight.Normal,
                fontSize = 22.sp,
                text = "Recebimentos"
            )
        }
        Column {
            ExtratoForm(
                nome = nomeState.value,
                price = precoState.value,
                onNomeChange = {
                    nomeState.value = it
                },
                onPriceChange = {
                    precoState.value = it
                },
                atualizar = {listarExtratoState.value = extratoRepository.listarExtrato()}
            )
            ExtratoList(listarExtratoState){
                listarExtratoState.value = extratoRepository.listarExtrato()
            }
        }
    }
}

@Composable
fun ExtratoForm(
    nome: String,
    price: String,
    onNomeChange: (String) -> Unit,
    onPriceChange: (String) -> Unit,
    atualizar: () -> Unit
) {

    val context = LocalContext.current
    val contatoRepository = ExtratoRepository(context)


    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value = nome,
            onValueChange = { onNomeChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nome do Recbimento")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = price,
            onValueChange = { onPriceChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Preco do recebimento")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val extrato = Extrato(
                    id = 0,
                    nome = nome,
                    price = price,
                )
                contatoRepository.adicionar(extrato)
                atualizar()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Salvar",
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun ExtratoList(listarExtrato: MutableState<List<Extrato>>, atualizar: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(rememberScrollState())
    ) {
        for (extrato in listarExtrato.value){
            ExtratoCard(extrato, atualizar)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
fun ExtratoCard(extrato: Extrato, atualizar: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { true }
        ,
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )

    ) {
        val context = LocalContext.current
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier
                .padding(8.dp)
                .weight(2f)) {
                Text(
                    text = extrato.nome,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = extrato.price,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            IconButton(onClick = {
                val contatoRepository = ExtratoRepository(context)
                contatoRepository.excluir(extrato)
                atualizar()
            }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = ""
                )
            }
        }
    }
}

