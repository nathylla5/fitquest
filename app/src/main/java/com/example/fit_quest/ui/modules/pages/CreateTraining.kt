package com.example.fit_quest.ui.modules.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fit_quest.R
import com.example.fit_quest.ui.components.ButtonItem
import com.example.fit_quest.ui.components.DataItem
import com.example.fit_quest.ui.components.InputItem
import com.example.fit_quest.ui.theme.containerOrTextLight
import com.example.fit_quest.ui.theme.primaryLight
import com.example.fit_quest.ui.theme.screenLight
import com.example.fit_quest.ui.theme.textDark
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTraining(onBackCreateTraining: () -> Unit) {
    val nomeState = remember {
        mutableStateOf("")
    }
    val descricaoState = remember {
        mutableStateOf("")
    }
    val dataState = remember {
        mutableStateOf("")
    }

    var store: FirebaseFirestore = Firebase.firestore


    fun create() {
        store.collection("treinos").add(
            hashMapOf(
                "nome" to nomeState.value,
                "descricao" to descricaoState.value,
                "data" to dataState.value
            )
        ).addOnCompleteListener{
            if(it.isSuccessful){
                onBackCreateTraining()
            }
        }
    }

    Column(modifier = Modifier.background(screenLight)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(screenLight),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(0.dp),
                modifier = Modifier.background(screenLight)
            ) {
                Surface(modifier = Modifier.fillMaxWidth(), color = screenLight) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .background(screenLight)
                            .fillMaxWidth()
                            .height(80.dp)
                            .padding(start = 24.dp, top = 24.dp, end = 24.dp)
                    ) {
                        Button(
                            onClick = onBackCreateTraining,
                            modifier = Modifier
                                .padding()
                                .width(30.dp),
                            contentPadding = PaddingValues(),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            )
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.back),
                                contentDescription = null,
                                contentScale = ContentScale.FillWidth
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                            //.padding(end = 64.dp)
                        ) {
                            Text(
                                text = "Cadastrar treino",
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    color = primaryLight,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                        Spacer(modifier = Modifier.width(32.dp))
                    }
                }
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.padding(
                        bottom = 56.dp,
                        top = 0.dp,
                        start = 56.dp,
                        end = 56.dp
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .background(
                                containerOrTextLight
                            )
                            .padding(top = 16.dp, bottom = 32.dp, start = 16.dp, end = 16.dp),
                        Arrangement.spacedBy(16.dp)
                    ) {
                        InputItem(
                            state = nomeState,
                            text = "Nome do Treino",
                            passwordVisualTransformation = VisualTransformation.None
                        )
                        InputItem(
                            state = descricaoState,
                            text = "Descrição",
                            passwordVisualTransformation = VisualTransformation.None,
                            lines = 3
                        )
                        DataItem(dataState)
                        Spacer(modifier = Modifier.padding(0.dp))
                        ButtonItem(
                            click = {create()},
                            text = "Cadastrar",
                            icon = null,
                            colorButton = primaryLight,
                            colorText = textDark
                        ) 
                    }
                }
            }
        }
    }
}