package com.example.fit_quest.ui.modules.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
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
import com.example.fit_quest.ui.theme.containerOrTextLight
import com.example.fit_quest.ui.theme.primaryLight
import com.example.fit_quest.ui.theme.textDark
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Exercise(
    onBackTrainingClick: () -> Unit,
    onClickGoNext: () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(color = Color.Transparent)
        systemUiController.setStatusBarColor(color = primaryLight)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(primaryLight),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(0.dp),
            modifier = Modifier.background(primaryLight)
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
            Surface (shape = RoundedCornerShape(16.dp), modifier = Modifier.padding(56.dp)) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            containerOrTextLight
                        ),
                    Arrangement.spacedBy(8.dp)
                ) {
                    CardExercise(onBackTrainingClick, modifier = Modifier)
                    CardExercise(onBackTrainingClick, modifier = Modifier)
                    CardExercise(onBackTrainingClick, modifier = Modifier)
                    CardExercise(onBackTrainingClick, modifier = Modifier)
                }
            }
        }
    }
}