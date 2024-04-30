package com.example.fit_quest.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fit_quest.ui.theme.accentLight
import com.example.fit_quest.ui.theme.containerOrTextLight
import com.example.fit_quest.ui.theme.primaryLight
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun CardTraining(onCardTrainingClick: () -> Unit,id: String, nome: String, descricao: String, data: String) {
    val store : FirebaseFirestore = Firebase.firestore
    fun exclude (){
        store.collection("treinos").document(id).delete().addOnCompleteListener{
            if (it.isSuccessful){
                println("Excluiu")
            }
        }
    }

    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = onCardTrainingClick, shape = RoundedCornerShape(8.dp), contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerOrTextLight
        )
    ) {
        Card(
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = containerOrTextLight,
            )
        ) {
            Row (modifier = Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically){
                Text(
                    modifier = Modifier,
                    text = nome,
                    textAlign = TextAlign.Start,
                    style = TextStyle(fontSize = 20.sp)
                )
                IconButton(modifier =  Modifier.height(20.dp), onClick = { exclude() }) {
                    Text(text = "excluir", style = TextStyle(color = Color.Red))
                }
            }
            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp), text = descricao, textAlign = TextAlign.Start, style = TextStyle(fontSize = 14.sp))
            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp), text = data, textAlign = TextAlign.Start)
        }
    }

}