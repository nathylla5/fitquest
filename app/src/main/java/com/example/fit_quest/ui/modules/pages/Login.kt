package com.example.fit_quest.ui.modules.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import com.google.firebase.ktx.Firebase


@Composable
fun Login(
    onLogin: () -> Unit,
    onSignClick: () -> Unit,
    onGoogleClick: () -> Unit
) {
    val emailState = remember {
        mutableStateOf("")
    }

    val passwordState = remember {
        mutableStateOf("")
    }

    lateinit var auth: FirebaseAuth;
    auth = Firebase.auth

    fun login(){
        auth.signInWithEmailAndPassword(emailState.value,passwordState.value).addOnCompleteListener{task ->
            if (task.isSuccessful){
                onLogin()
            }
        }
    }

    Column(
        modifier = Modifier
            .background(color = screenLight)
            .fillMaxSize()
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(0.dp))
            Image(
                modifier = Modifier
                    .width(155.dp)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.logo_light),
                contentDescription = null,
                contentScale = ContentScale.FillHeight
            )



            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                item {
                    //Spacer(modifier = Modifier.height(24.dp))
                    Text(text = "Entre", style = TextStyle(fontSize = 32.sp, color = primaryLight))
                    Spacer(modifier = Modifier.height(24.dp))
                }
                item {
                    InputItem(
                        data = emailState,
                        text = "E-mail",
                        VisualTransformation.None
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    InputItem(
                        data = passwordState,
                        text = "Senha",
                        PasswordVisualTransformation()
                    )
                }
            }
            Column {
                ButtonItem(
                    text = "Entrar",
                    icon = null,
                    colorButton = primaryLight,
                    colorText = containerOrTextLight,
                    click = { login() })
                Spacer(modifier = Modifier.height(16.dp))
                ButtonItem(
                    text = "Entrar com Google",
                    icon = R.drawable.google,
                    colorButton = containerOrTextLight,
                    colorText = textLight,
                    click = { onGoogleClick })

                Spacer(modifier = Modifier.height(88.dp))

                Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Text(
                        text = "Não tem perfil? ",
                        style = TextStyle(
                            fontWeight = FontWeight.Medium, fontSize = 16.sp, color = textLight
                        )
                    )
                    TextButton(
                        onClick = onSignClick,
                        contentPadding = PaddingValues(
                            start = 0.dp,
                            top = 1.dp,
                            end = 4.dp,
                            bottom = 4.dp
                        ),
                        modifier = Modifier
                            .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp)
                            .heightIn(max = 24.dp),
                    ) {
                        Text(

                            text = "Cadastre-se",
                            style = TextStyle(
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