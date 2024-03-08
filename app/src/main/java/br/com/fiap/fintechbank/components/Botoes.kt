package br.com.fiap.fintechbank.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.fiap.fintechbank.R

@Composable
fun ButtonWithText(iconId: Int, text: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(start = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            modifier = Modifier
                .clip(CircleShape)
                .background(colorResource(id = R.color.gray_100)),
            onClick = onClick
        ) {
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = "Icon Button",
                modifier = Modifier.size(28.dp),
            )
        }
        Text(text = text)
    }
}