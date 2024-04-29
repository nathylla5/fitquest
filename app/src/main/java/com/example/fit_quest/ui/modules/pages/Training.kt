package com.example.fit_quest.ui.modules.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fit_quest.R
import com.example.fit_quest.ui.components.CardExercise
import com.example.fit_quest.ui.theme.primaryLight
import com.example.fit_quest.ui.theme.screenLight
import com.example.fit_quest.ui.theme.textDark

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun Training(onCardExerciseClick: () -> Unit, onBackTrainingClick: () -> Unit) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(screenLight),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp),
            modifier = Modifier.background(Color.White)
        ) {
            Surface(modifier = Modifier.fillMaxWidth(), color = primaryLight) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier
                        .background(primaryLight)
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(start = 24.dp, top = 24.dp, end = 24.dp)
                ) {
                    Button(
                        onClick = onBackTrainingClick,
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
                            text = "Segunda-feira",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = textDark,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = "28/04/2024",
                            style = TextStyle(fontSize = 12.sp, color = textDark)
                        )
                    }
                    Spacer(modifier = Modifier.width(32.dp))
                }
            }
            Surface(color = screenLight, modifier = Modifier.fillMaxWidth()) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    color = primaryLight,
                ) {}
                Column(
                    modifier = Modifier
                        .padding(horizontal = 32.dp, vertical = 24.dp)
                        .verticalScroll(
                            scrollState
                        ), Arrangement.spacedBy(8.dp)
                ) {
                    CardExercise(onCardExerciseClick, modifier = Modifier)
                    CardExercise(onCardExerciseClick, modifier = Modifier)
                    CardExercise(onCardExerciseClick, modifier = Modifier)
                    CardExercise(onCardExerciseClick, modifier = Modifier)
                    CardExercise(onCardExerciseClick, modifier = Modifier)
                }
            }
        }
    }
}

/*Scaffold(
            modifier = Modifier
                .padding(18.dp)
                .background(screenLight),
            topBar = {
                , content = {
                Column(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize()
                        .background(color = screenLight),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        modifier = Modifier
                            .padding(32.dp)
                            .background(color = primaryLight)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = "Content of the page",
                            fontSize = 30.sp,
                            color = Color.White
                        )
                    }
                }

            }
        )*/