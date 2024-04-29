package com.example.fit_quest.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonItem(
    text: String,
    icon: Int?,
    colorButton: Color,
    colorText: Color?,
    click: () -> Unit,
) {
    Button(
        onClick = click,
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(4.dp),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorButton
        )
    ) {
        if (icon != null) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                painter = painterResource(id = icon),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.padding(4.dp))
        }

        if (colorText != null) {
            Text(
                text = text, style = TextStyle(colorText),
                fontSize = 20.sp
            )
        }
    }
}