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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fit_quest.R
import com.example.fit_quest.ui.components.ButtonItem
import com.example.fit_quest.ui.components.InputItem
import com.example.fit_quest.ui.theme.containerOrTextLight
import com.example.fit_quest.ui.theme.primaryLight
import com.example.fit_quest.ui.theme.screenLight
import com.example.fit_quest.ui.theme.textLight
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(
    onSignUp: () -> Unit, onLoginClick: () -> Unit
) {
    val nameState = remember {
        mutableStateOf("")
    }

    val emailState = remember {
        mutableStateOf("")
    }

    val passwordState = remember {
        mutableStateOf("")
    }

    lateinit var auth: FirebaseAuth;
    auth = Firebase.auth

    fun createUser() {
        auth.createUserWithEmailAndPassword(emailState.value, passwordState.value)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    auth.currentUser?.updateProfile(
                        userProfileChangeRequest {
                            displayName = nameState.value
                        })?.addOnCompleteListener { task2 ->
                        if (task2.isSuccessful) {
                            onSignUp()
                        }
                    }
                }

            }
    }

    Box(modifier = Modifier.background(screenLight)) {
        Scaffold(modifier = Modifier
            .padding(32.dp)
            .background(screenLight), topBar = {
            TopAppBar(
                title = {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 32.dp)
                    ) {
                        Text(
                            text = "Cadastre-se",
                            style = TextStyle(fontSize = 32.sp, color = primaryLight)
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Image(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = null,
                            contentScale = ContentScale.Fit
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = screenLight,
                ),
            )
        }, content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(screenLight),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(0.dp))
                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    item {
                        InputItem(
                            state = nameState, text = "Nome completo", passwordVisualTransformation = VisualTransformation.None
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        InputItem(
                            state = emailState, text = "Email", passwordVisualTransformation = PasswordVisualTransformation()
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        InputItem(
                            state = passwordState, text = "Senha", passwordVisualTransformation = PasswordVisualTransformation()
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        InputItem(
                            state = passwordState,
                            text = "Confirme sua senha",
                            passwordVisualTransformation = PasswordVisualTransformation()
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                    }

                    item {
                        val isChecked = remember { mutableStateOf(false) }

                        Row(
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            Checkbox(
                                checked = isChecked.value,
                                onCheckedChange = { isChecked.value = it },
                                enabled = true,
                                colors = CheckboxDefaults.colors(
                                    checkedColor = primaryLight,
                                    uncheckedColor = primaryLight,
                                    checkmarkColor = containerOrTextLight,
                                    disabledCheckedColor = primaryLight,
                                    disabledUncheckedColor = primaryLight,
                                    disabledIndeterminateColor = primaryLight
                                ),
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(4.dp),
                            )

                            Spacer(modifier = Modifier.padding(4.dp))

                            Text(
                                "Concordo com os ",
                                modifier = Modifier.padding(top = 2.dp),
                                textAlign = TextAlign.Start,
                                fontSize = 16.sp,
                                color = textLight
                            )
                            Text(
                                "termos de uso",
                                modifier = Modifier.padding(top = 2.dp),
                                textAlign = TextAlign.Start,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = textLight
                            )
                        }
                    }

                }

                Column {
                    ButtonItem(text = "Cadastrar",
                        icon = null,
                        colorButton = primaryLight,
                        colorText = containerOrTextLight,
                        click = { createUser() })
                    Spacer(modifier = Modifier.height(144.dp))

                    Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                        Row(horizontalArrangement = Arrangement.Start) {
                            Text(
                                text = "Já tem perfil? ", style = TextStyle(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = 16.sp,
                                    color = textLight
                                )
                            )
                            TextButton(
                                onClick = onLoginClick,
                                contentPadding = PaddingValues(
                                    start = 0.dp, top = 1.dp, end = 16.dp, bottom = 6.dp
                                ),
                                modifier = Modifier
                                    //.defaultMinSize(minWidth = 1.dp, minHeight = 1.dp)
                                    .heightIn(max = 24.dp),
                            ) {
                                Text(
                                    text = "Entre", style = TextStyle(
                                        color = textLight,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp,
                                    )
                                )
                            }
                        }

                    }
                }
            }
        }
        )
    }
}