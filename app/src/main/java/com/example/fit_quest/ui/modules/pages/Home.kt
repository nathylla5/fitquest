package com.example.fit_quest.ui.modules.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
import com.example.fit_quest.ui.components.CardTraining
import com.example.fit_quest.ui.theme.primaryLight
import com.example.fit_quest.ui.theme.screenLight
import com.example.fit_quest.ui.theme.secundaryLight
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(onSignOut: () -> Unit, onCardTrainingClick: () -> Unit) {
    val scrollState = rememberScrollState()

    lateinit var auth: FirebaseAuth;
    auth = Firebase.auth
    Column(
        modifier = Modifier
            .background(color = screenLight)
            .fillMaxSize()
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        Box(modifier = Modifier.background(screenLight)) {
            Scaffold(
                modifier = Modifier
                    .background(screenLight),
                topBar = {
                    TopAppBar(
                        title = {},
                        navigationIcon = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.logo_2),
                                    contentDescription = null,
                                    contentScale = ContentScale.FillHeight
                                )
                                Button(
                                    onClick = {
                                        auth.signOut()
                                        onSignOut()
                                    },
                                    contentPadding = PaddingValues(start = 30.dp),
                                    shape = RoundedCornerShape(0.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.Transparent
                                    )
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.exit),
                                        contentDescription = null,
                                        contentScale = ContentScale.FillHeight
                                    )
                                }
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = screenLight,
                        ),
                    )
                },
                content = {
                    Column(
                        modifier = Modifier
                            .padding(it)
                            .background(screenLight)
                            .fillMaxSize()
                    ) {
                        Spacer(modifier = Modifier.padding(18.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            Arrangement.SpaceBetween,
                            Alignment.Bottom
                        ) {
                            Text(
                                text = "Treino Semanal",
                                style = TextStyle(
                                    color = primaryLight,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 24.sp
                                )
                            )
                            Text(
                                text = "editar",
                                style = TextStyle(
                                    color = secundaryLight,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                            )
                        }
                        Spacer(modifier = Modifier.padding(8.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(scrollState)
                        ) {
                            CardTraining(onCardTrainingClick)
                            CardTraining(onCardTrainingClick)
                            CardTraining(onCardTrainingClick)
                            CardTraining(onCardTrainingClick)
                            CardTraining(onCardTrainingClick)
                            CardTraining(onCardTrainingClick)
                            CardTraining(onCardTrainingClick)
                        }
                    }
                }
            )
        }
    }
}