package com.example.fit_quest.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.fit_quest.ui.theme.containerOrTextLight
import com.example.fit_quest.ui.theme.primaryLight

@Composable
fun CardTraining(onCardTrainingClick: () -> Unit) {
    Button(
        onClick = onCardTrainingClick, shape = RoundedCornerShape(0.dp), contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        )
    ) {
        Card(
            modifier = Modifier
                .height(128.dp)
                .width(88.dp)
                .padding(4.dp),
            colors = CardDefaults.cardColors(
                containerColor = containerOrTextLight,
                contentColor = primaryLight
            )
        ) {
            Text(modifier = Modifier.fillMaxWidth(), text = "Segunda", textAlign = TextAlign.Center)
        }
    }

}