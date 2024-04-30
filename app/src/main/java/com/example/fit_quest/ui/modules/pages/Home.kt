package com.example.fit_quest.ui.modules.pages

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
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
import com.example.fit_quest.models.Training
import com.example.fit_quest.ui.components.CardTraining
import com.example.fit_quest.ui.theme.primaryLight
import com.example.fit_quest.ui.theme.screenLight
import com.example.fit_quest.ui.theme.secundaryLight
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(onSignOut: () -> Unit, onCardTrainingClick: () -> Unit, onCreateTraining: () -> Unit) {
    val scrollState = rememberScrollState()
    var trainingList = remember {
        mutableStateOf(emptyList<Training>())
    }

    lateinit var auth: FirebaseAuth;
    auth = Firebase.auth

    val store: FirebaseFirestore = Firebase.firestore
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
                        Spacer(modifier = Modifier.padding(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            Arrangement.SpaceBetween,
                            Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Treinos",
                                style = TextStyle(
                                    color = primaryLight,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 24.sp
                                )
                            )
                            Button(onClick = { onCreateTraining() }, colors = ButtonDefaults.buttonColors(
                                containerColor = screenLight
                            )) {
                                Text(
                                    text = "cadastrar",
                                    style = TextStyle(
                                        color = secundaryLight,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp
                                    )
                                )
                            }
                        }
                        Spacer(modifier = Modifier.padding(8.dp))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .verticalScroll(scrollState),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            LaunchedEffect(Unit) {
                                store.collection("treinos").addSnapshotListener{ snapshot, e ->
                                    if (e!=null){
                                        println("Ocorreu um erro")
                                    }
                                    if (snapshot != null) {
                                        var data = emptyList<Training>()
                                        for (document in snapshot.documents) {
                                            var item = Training(
                                                id = document.id,
                                                nome = document.data?.get("nome").toString(),
                                                descricao = document.data?.get("descricao")
                                                    .toString(),
                                                data = document.data?.get("data")
                                                    .toString()
                                            )
                                            data = data + item
                                        }
                                        trainingList.value = data
                                    }
                                }
                            }
                            for (training in trainingList.value) {
                                CardTraining(
                                    onCardTrainingClick = { /*TODO*/ },
                                    id = training.id,
                                    nome = training.nome,
                                    descricao = training.descricao,
                                    data = training.data
                                )
                            }
                        }
                    }
                }
            )
        }
    }
}